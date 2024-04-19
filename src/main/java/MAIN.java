import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MAIN {
    public static void main(String[] args) {
        // Crear una nueva ventana y un JTextArea
        JFrame frame = new JFrame("ADN");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea); // Agregar un scroll pane al JTextArea
        frame.add(scrollPane);

        // Crear un JComboBox
        String[] opciones = {"Generar cadena de ADN y contar genes", "Ordenar documentos", "Buscar texto"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        frame.add(comboBox, BorderLayout.NORTH);

        // Agregar un ActionListener al JComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) comboBox.getSelectedItem();
                switch (seleccionado) {
                    case "Generar cadena de ADN y contar genes":
                        String cadenaADN = Adn.generarCadenaADN(30);
                        int numeroGenes = Adn.contarGenes(cadenaADN);
                        textArea.append("Cadena de ADN generada:\n" + cadenaADN + "\n");
                        textArea.append("Número de genes en la cadena de ADN: " + numeroGenes + "\n");
                        break;
                    case "Ordenar documentos":
                        JFileChooser fileChooser = new JFileChooser();
                        int returnValue = fileChooser.showOpenDialog(null);
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            OrganizacionDocumentos.ordenarDocumentos(selectedFile.getPath());
                        }
                        break;
                    case "Buscar texto":
                        JFileChooser fileChooserBuscar = new JFileChooser();
                        int returnValueBuscar = fileChooserBuscar.showOpenDialog(null);
                        if (returnValueBuscar == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooserBuscar.getSelectedFile();
                            String palabraBusqueda = JOptionPane.showInputDialog("Introduce la palabra a buscar:");
                            BusquedaTexto buscador = new BusquedaTexto(selectedFile.getPath());
                            boolean encontradoLineal = buscador.busquedaLineal(palabraBusqueda);
                            boolean encontradoBinario = buscador.busquedaBinaria(palabraBusqueda);
                            textArea.append("Resultado de la búsqueda lineal: " + encontradoLineal + "\nResultado de la búsqueda binaria: " + encontradoBinario + "\n");
                        }
                        break;
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}