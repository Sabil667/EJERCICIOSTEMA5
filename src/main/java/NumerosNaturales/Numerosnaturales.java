package NumerosNaturales;

import javax.swing.JTextArea;
import java.io.PrintStream;

public class Numerosnaturales {
    public static void imprimirNumeros(int inicio, int fin, JTextArea textArea) {
        for (int i = inicio; i <= fin; i++) {
            textArea.append(i + "\n");
        }
    }

    public static void imprimirNumeros(int inicio, int fin, PrintStream out) {
    }
}