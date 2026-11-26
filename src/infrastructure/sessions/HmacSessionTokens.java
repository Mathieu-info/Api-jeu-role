package infrastructure.sessions;

import application.sessions.SessionTokens;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import players.PlayerId;

public class HmacSessionTokens implements SessionTokens {

	private static final String HEADER = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
	private static final Pattern SUBJECT =
		Pattern.compile("\"sub\"\\s*:\\s*\"([^\"]+)\"");
	private static final Base64.Encoder ENCODER =
		Base64.getUrlEncoder().withoutPadding();
	private static final Base64.Decoder DECODER = Base64.getUrlDecoder();

	private final byte[] secret;

	public HmacSessionTokens(String secret) {
		if (secret == null || secret.isBlank()) {
			throw new IllegalArgumentException("The token secret is empty.");
		}
		this.secret = secret.getBytes(StandardCharsets.UTF_8);
	}

	@Override
	public String issue(PlayerId playerId) {
		String header = encode(HEADER);
		String payload = encode("{\"sub\":\"" + playerId.value() + "\"}");
		String signature = ENCODER.encodeToString(
			sign(header + "." + payload)
		);
		return header + "." + payload + "." + signature;
	}

	@Override
	public Optional<PlayerId> resolve(String token) {
		try {
			String[] parts = token.split("\\.");
			if (parts.length != 3) {
				return Optional.empty();
			}
			byte[] expected = sign(parts[0] + "." + parts[1]);
			byte[] provided = DECODER.decode(parts[2]);
			if (!MessageDigest.isEqual(expected, provided)) {
				return Optional.empty();
			}
			String payload = new String(
				DECODER.decode(parts[1]),
				StandardCharsets.UTF_8
			);
			Matcher matcher = SUBJECT.matcher(payload);
			if (!matcher.find()) {
				return Optional.empty();
			}
			return Optional.of(PlayerId.of(matcher.group(1)));
		} catch (RuntimeException e) {
			return Optional.empty();
		}
	}

	private String encode(String json) {
		return ENCODER.encodeToString(json.getBytes(StandardCharsets.UTF_8));
	}

	private byte[] sign(String signingInput) {
		try {
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(new SecretKeySpec(secret, "HmacSHA256"));
			return mac.doFinal(signingInput.getBytes(StandardCharsets.US_ASCII));
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			throw new IllegalStateException("HmacSHA256 is not available", e);
		}
	}
}
