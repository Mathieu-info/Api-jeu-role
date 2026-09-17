package exceptions.experience;

public class IllegalNegativeExperiencePoint extends RuntimeException {
    public IllegalNegativeExperiencePoint(int xp) {

        super(xp + " must be a positive number");
    }
}
