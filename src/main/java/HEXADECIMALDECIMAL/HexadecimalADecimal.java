package HEXADECIMALDECIMAL;

public class HexadecimalADecimal {
    public static int convertirHexadecimalADecimal(String hex, int longitud) {
        if (longitud == 1) {
            return Character.digit(hex.charAt(0), 16);
        } else {
            return Character.digit(hex.charAt(0), 16) * (int) Math.pow(16, longitud - 1) + convertirHexadecimalADecimal(hex.substring(1), longitud - 1);
        }
    }
}