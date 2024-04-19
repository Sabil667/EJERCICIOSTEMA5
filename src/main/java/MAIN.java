import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import SumaNumerosN.NumerosN;
import NumerosNaturales.Numerosnaturales;
import CONTARDIGITOS.ContadorDeDigitos;
import POTENCIA.Potencia;
import MAXIMO.Maximo;

public class MAIN extends JFrame {
    JPanel panel;
    JTextArea textArea;

    public MAIN() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        String[] opciones = {"Seleccione una opción", "Suma de Numeros n", "Imprimir Numeros Naturales", "Contar Dígitos", "Calcular Potencia", "Calcular Máximo", "Opción 6"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        comboBox.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            String seleccionado = (String)cb.getSelectedItem();
            if (seleccionado.equals("Suma de Numeros n")) {
                int suma = NumerosN.sumaRecursiva(5);
                textArea.setText("La suma de los primeros 5 números naturales es: " + suma);
            } else if (seleccionado.equals("Imprimir Numeros Naturales")) {
                textArea.setText("");
                Numerosnaturales.imprimirNumeros(1, 10, textArea);
            } else if (seleccionado.equals("Contar Dígitos")) {
                int cantidad = ContadorDeDigitos.contarDigitos(12345);
                textArea.setText("La cantidad de dígitos de 12345 es: " + cantidad);
            } else if (seleccionado.equals("Calcular Potencia")) {
                int resultado = Potencia.calcularPotencia(2, 3);
                textArea.setText("2 elevado a 3 es: " + resultado);
            } else if (seleccionado.equals("Calcular Máximo")) {
                int[] vector = {1, 2, 3, 4, 5};
                String maximo = Maximo.calcularMaximo(vector, 0);
                textArea.setText(maximo);
            }
        });

        panel.add(comboBox);
        panel.add(textArea);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MAIN();
    }
}