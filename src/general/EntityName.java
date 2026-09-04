package general;

public class EntityName {

	private String name;

	public EntityName(String name) {
		boolean containsNumbers = name.matches(".*\\d.*");
		if (name == null || name.isEmpty() || containsNumbers == true) {
			throw new IllegalArgumentException(
				"name cannot be null or empty or contain numbers"
			);
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return String.format("Name : %s", name);
	}
}
