import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import SumaNumerosN.NumerosN;

public class MAIN extends JFrame {
    JPanel panel;

    public MAIN() {
        // Configurar la ventana
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel
        panel = new JPanel();

        // Crear un JComboBox
        String[] opciones = {"Seleccione una opción", "Suma de Numeros n", "Opción 2", "Opción 3"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        // Agregar un ActionListener al JComboBox
        comboBox.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            String seleccionado = (String)cb.getSelectedItem();
            if (seleccionado.equals("Suma de Numeros n")) {
                int suma = NumerosN.sumaRecursiva(5);
                JLabel etiquetaSuma = new JLabel("La suma de los primeros 5 números naturales es: " + suma);
                panel.add(etiquetaSuma);
                panel.revalidate();
                panel.repaint();
            }
        });

        // Agregar el JComboBox al panel
        panel.add(comboBox);

        // Agregar el panel a la ventana
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new MAIN();
    }
}