package general;
import exceptions.entity.IllegalEntityName;

public class EntityName {

	private String name;

	public EntityName(String name) {
		boolean containsNumbers = name.matches(".*\\d.*");
		if (name == null || name.isEmpty() || containsNumbers) {
            throw new IllegalEntityName(name);
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%s", name);
	}
}
