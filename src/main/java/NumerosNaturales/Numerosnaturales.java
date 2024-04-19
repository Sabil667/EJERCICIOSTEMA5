package NumerosNaturales;

public class Numerosnaturales {
    public static void imprimirNumeros(int a, int d) {
        if (a > d) {
            return;
        }

        System.out.println(a);

        imprimirNumeros(a + 1, d);
    }

    public static void main(String[] args) {
        imprimirNumeros(5, 10);
    }
}