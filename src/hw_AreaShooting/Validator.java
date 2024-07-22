package hw_AreaShooting;

public class Validator {
    public static boolean isInt(String scannerValue) {
        for (char c : scannerValue.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
