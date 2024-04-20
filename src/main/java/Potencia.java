public class Potencia {
    public static int calcularPotencia(int x, int y) {
        if (y == 0) {
            return 1;
        } else {
            return x * calcularPotencia(x, y - 1);
        }
    }
}