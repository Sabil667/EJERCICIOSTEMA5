import java.util.Random;

public class HexadecimalADecimal {
    private static final String DIGITOS_HEX = "0123456789ABCDEF";

    public static String generarHexadecimal(int longitud) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(DIGITOS_HEX.length());
            char digitoHex = DIGITOS_HEX.charAt(indice);
            sb.append(digitoHex);
        }
        return sb.toString();
    }

    public static int convertir(String hex) {
        return Integer.parseInt(hex, 16);
    }
}