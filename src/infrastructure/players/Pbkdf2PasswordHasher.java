package infrastructure.players;

import application.players.PasswordHasher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Pbkdf2PasswordHasher implements PasswordHasher {

	private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
	private static final int ITERATIONS = 210_000;
	private static final int KEY_LENGTH_BITS = 256;
	private static final int SALT_BYTES = 16;
	private static final String PREFIX = "$pbkdf2-sha256$";

	private final SecureRandom random = new SecureRandom();

	@Override
	public String hash(String password) {
		byte[] salt = new byte[SALT_BYTES];
		random.nextBytes(salt);
		byte[] derived = derive(password, salt, ITERATIONS);
		return PREFIX
			+ ITERATIONS + "$"
			+ encode(salt) + "$"
			+ encode(derived);
	}

	@Override
	public boolean verify(String password, String hash) {
		try {
			String[] parts = hash.split("\\$");
			if (parts.length != 5 || !parts[1].equals("pbkdf2-sha256")) {
				return false;
			}
			int iterations = Integer.parseInt(parts[2]);
			byte[] salt = decode(parts[3]);
			byte[] expected = decode(parts[4]);
			byte[] actual = derive(password, salt, iterations);
			return MessageDigest.isEqual(expected, actual);
		} catch (RuntimeException e) {
			return false;
		}
	}

	private byte[] derive(String password, byte[] salt, int iterations) {
		try {
			PBEKeySpec spec = new PBEKeySpec(
				password.toCharArray(),
				salt,
				iterations,
				KEY_LENGTH_BITS
			);
			return SecretKeyFactory
				.getInstance(ALGORITHM)
				.generateSecret(spec)
				.getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new IllegalStateException("Algorithm " + ALGORITHM + " not available", e);
		}
	}

	private String encode(byte[] bytes) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
	}

	private byte[] decode(String value) {
		return Base64.getUrlDecoder().decode(value);
	}
}
