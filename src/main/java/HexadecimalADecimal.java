public class HexadecimalADecimal {
    public static int convertir(String hex, int longitud) {
        if (longitud == 0) {
            return 0;
        } else {
            char ultimoDigito = hex.charAt(longitud - 1);
            int valorDecimal = Character.digit(ultimoDigito, 16);
            return valorDecimal * (int) Math.pow(16, 0) + convertir(hex.substring(0, longitud - 1), longitud - 1);
        }
    }
}