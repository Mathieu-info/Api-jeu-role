package exceptions.armor;

public class IllegalArmorAmount extends RuntimeException {
    public IllegalArmorAmount(int value) {
        super("Armor class value cannot be negative. Armor value entered: " + value);
    }
}
