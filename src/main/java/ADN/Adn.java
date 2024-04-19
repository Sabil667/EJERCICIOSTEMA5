package ADN;

import java.util.Random;

public class Adn {
    private static final String[] BASES = {"A", "T", "G", "C"};
    private static final String[] FIN_GEN = {"TAA", "TAG", "TGA"};
    private static final String INICIO_GEN = "ATG";

    public static String generarCadenaADN(int longitud) {
        Random random = new Random();
        StringBuilder cadenaADN = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            cadenaADN.append(BASES[random.nextInt(BASES.length)]);
        }
        // Aseguramos que al menos un gen esté presente en la cadena de ADN cada dos veces
        for (int i = 0; i < longitud - 6; i += 6) {
            cadenaADN.replace(i, i + 3, INICIO_GEN);
            cadenaADN.replace(i + 3, i + 6, FIN_GEN[random.nextInt(FIN_GEN.length)]);
        }
        return cadenaADN.toString();
    }

    public static int contarGenes(String cadenaADN) {
        int contadorGenes = 0;
        int inicio = cadenaADN.indexOf(INICIO_GEN);
        while (inicio != -1 && inicio + 3 < cadenaADN.length()) {
            String posibleFin = cadenaADN.substring(inicio + 3, inicio + 6);
            for (String fin : FIN_GEN) {
                if (posibleFin.equals(fin)) {
                    contadorGenes++;
                    break;
                }
            }
            inicio = cadenaADN.indexOf(INICIO_GEN, inicio + 1);
        }
        return contadorGenes;
    }
}