class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}
class AgeChecker {
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("Age must be at least 18.");
        else System.out.println("Valid age.");
    }
    public static void main(String[] args) {
        try {
            checkAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
