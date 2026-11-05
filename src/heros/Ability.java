package heros;

public enum Ability {
	STRENGTH("Strength"),
	DEXTERITY("Dexterity"),
	CONSTITUTION("Constitution"),
	INTELLIGENCE("Intelligence"),
	WISDOM("Wisdom"),
	CHARISMA("Charisma");

	private final String displayName;

	Ability(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static Ability fromName(String name) {
		if (name == null) {
			return null;
		}
		for (Ability ability : values()) {
			if (ability.displayName.equalsIgnoreCase(name.trim())) {
				return ability;
			}
		}
		return null;
	}
}
