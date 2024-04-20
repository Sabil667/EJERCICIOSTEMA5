package Ejercicios;

public class MaximoVector {
    public static int calcularMaximo(int[] vector, int inicio, int fin) {
        if (inicio == fin) {
            return vector[inicio];
        } else {
            int mitad = (inicio + fin) / 2;
            int maximoIzquierda = calcularMaximo(vector, inicio, mitad);
            int maximoDerecha = calcularMaximo(vector, mitad + 1, fin);
            return Math.max(maximoIzquierda, maximoDerecha);
        }
    }
}