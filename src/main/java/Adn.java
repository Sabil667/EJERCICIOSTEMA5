import java.util.Random;

public class Adn {
    private static final String[] NUCLEOTIDES = {"A", "C", "G", "T"};

    public static String generarCadenaADN(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(NUCLEOTIDES[random.nextInt(NUCLEOTIDES.length)]);
        }
        return sb.toString();
    }

    public static int contarGenes(String cadenaADN) {
        // Consideramos que un gen es una secuencia de 3 nucleótidos
        return cadenaADN.length() / 3;
    }
}