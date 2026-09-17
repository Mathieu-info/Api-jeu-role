package general;

@FunctionalInterface
public interface HealthScaling {

	int computeMaxHealth(int baseMaxHealth, int level);

	static HealthScaling linear(int growthPerLevel) {
		return (baseMaxHealth, level) ->
			baseMaxHealth + growthPerLevel * (level - 1);
	}
}