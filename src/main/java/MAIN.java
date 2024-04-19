import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import SumaNumerosN.NumerosN;
import NumerosNaturales.Numerosnaturales;
import CONTARDIGITOS.ContadorDeDigitos;
import POTENCIA.Potencia;  // Importar la clase Potencia

public class MAIN extends JFrame {
    JPanel panel;
    JTextArea textArea;

    public MAIN() {
        // Configurar la ventana
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel
        panel = new JPanel();

        // Crear un JComboBox
        String[] opciones = {"Seleccione una opción", "Suma de Numeros n", "Imprimir Numeros Naturales", "Contar Dígitos", "Calcular Potencia", "Opción 5"};  // Añadir "Calcular Potencia"
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        // Crear un JTextArea para mostrar los números
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        // Agregar un ActionListener al JComboBox
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
            } else if (seleccionado.equals("Calcular Potencia")) {  // Añadir este caso
                int resultado = Potencia.calcularPotencia(2, 3);
                textArea.setText("2 elevado a 3 es: " + resultado);
            }
        });

        // Agregar el JComboBox y JTextArea al panel
        panel.add(comboBox);
        panel.add(textArea);

        // Agregar el panel a la ventana
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new MAIN();
    }
}