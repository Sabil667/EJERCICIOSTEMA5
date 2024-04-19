package ADN;

import java.util.Random;

public class Adn {
    private static final String[] BASES = {"A", "T", "G", "C"};
    private static final String[] FIN_GEN = {"TAA", "TAG", "TGA"};
    private static final String INICIO_GEN = "ATG";
    private static final int LONGITUD_CADENA = 1000;

    public static String generarCadenaADN() {
        Random random = new Random();
        StringBuilder cadenaADN = new StringBuilder(LONGITUD_CADENA);
        for (int i = 0; i < LONGITUD_CADENA; i++) {
            cadenaADN.append(BASES[random.nextInt(BASES.length)]);
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

    public static void main(String[] args) {
        String cadenaADN = generarCadenaADN();
        int numeroGenes = contarGenes(cadenaADN);
        System.out.println("Cadena de ADN generada: " + cadenaADN);
        System.out.println("Número de genes en la cadena de ADN: " + numeroGenes);
    }
}