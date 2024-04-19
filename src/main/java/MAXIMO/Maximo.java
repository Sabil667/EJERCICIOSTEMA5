package MAXIMO;

public class Maximo {
    public static int calcularMaximo(int[] vector, int index) {
        if (index == vector.length - 1) {
            return vector[index];
        } else {
            return Math.max(vector[index], calcularMaximo(vector, index + 1));
        }
    }
}