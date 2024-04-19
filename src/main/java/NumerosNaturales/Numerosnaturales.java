package NumerosNaturales;

import javax.swing.JTextArea;

public class Numerosnaturales {
    public static void imprimirNumeros(int a, int d, JTextArea textArea) {
        if (a > d) {
            return;
        }

        textArea.append(a + "\n");

        imprimirNumeros(a + 1, d, textArea);
    }
}