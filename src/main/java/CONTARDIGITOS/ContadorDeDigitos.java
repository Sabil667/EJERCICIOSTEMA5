package CONTARDIGITOS;

public class ContadorDeDigitos {
    public static int contarDigitos(int n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + contarDigitos(n / 10);
        }
    }

    public static void main(String[] args) {
        System.out.println(contarDigitos(12345));  // Debería imprimir 5
    }
}