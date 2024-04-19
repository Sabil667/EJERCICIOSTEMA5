package MAXIMO;

public class Maximo {
    public static String calcularMaximo(int[] vector, int index) {
        if (index == vector.length - 1) {
            return "El valor máximo del vector [" + vector[index] + "] es: " + vector[index];
        } else {
            String maxResto = calcularMaximo(vector, index + 1);
            int maxActual = Math.max(vector[index], Integer.parseInt(maxResto.split(": ")[1]));
            return "El valor máximo del vector [" + vector[index] + ", " + maxResto.split("\\[")[1];
        }
    }
}