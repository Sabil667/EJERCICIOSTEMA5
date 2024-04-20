import Ejercicios.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class MAIN {
    public static void main(String[] args) {
        // Crear una nueva ventana y un JTextArea
        JFrame frame = new JFrame("ADN");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea); // Agregar un scroll pane al JTextArea
        frame.add(scrollPane, BorderLayout.CENTER);

        // Crear un JPanel con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel, BorderLayout.NORTH);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear un JComboBox
        String[] opciones = {"Generar cadena de ADN y contar genes", "Ordenar documentos", "Buscar texto", "Agregar fecha", "Listar fechas", "Sumar naturales", "Contar dígitos", "Calcular potencia", "Calcular máximo", "Convertir hexadecimal a decimal", "Calcular C"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        panel.add(comboBox, gbc);

        // Crear una instancia de GestionFechas
        GestionFechas gestionFechas = new GestionFechas();

        // Agregar un ActionListener al JComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiar el JTextArea
                textArea.setText("");

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
                    case "Agregar fecha":
                        String fecha = JOptionPane.showInputDialog("Introduce una fecha en el formato dd/MM/yyyy:");
                        gestionFechas.agregarFecha(fecha);
                        break;
                    case "Listar fechas":
                        List<String> fechasOrdenadas = gestionFechas.obtenerFechasOrdenadas();
                        for (String fechaOrdenada : fechasOrdenadas) {
                            textArea.append(fechaOrdenada + "\n");
                        }
                        break;
                    case "Sumar naturales":
                        String numero = JOptionPane.showInputDialog("Introduce un número natural:");
                        try {
                            int n = Integer.parseInt(numero);
                            int suma = SumaNaturales.sumaRecursiva(n);
                            textArea.append("La suma de los primeros " + n + " números naturales es: " + suma + "\n");
                        } catch (NumberFormatException ex) {
                            textArea.append("Por favor, introduce un número natural válido.\n");
                        }
                        break;
                    case "Contar dígitos":
                        String numeroDigitos = JOptionPane.showInputDialog("Introduce un número entero:");
                        try {
                            int n = Integer.parseInt(numeroDigitos);
                            int cantidadDigitos = ContadorDigitos.contarDigitos(n);
                            textArea.append("El número " + n + " tiene " + cantidadDigitos + " dígitos.\n");
                        } catch (NumberFormatException ex) {
                            textArea.append("Por favor, introduce un número entero válido.\n");
                        }
                        break;
                    case "Calcular potencia":
                        String base = JOptionPane.showInputDialog("Introduce la base:");
                        String exponente = JOptionPane.showInputDialog("Introduce el exponente:");
                        try {
                            int x = Integer.parseInt(base);
                            int y = Integer.parseInt(exponente);
                            int resultado = Potencia.calcularPotencia(x, y);
                            textArea.append("El resultado de " + x + " elevado a " + y + " es: " + resultado + ".\n");
                        } catch (NumberFormatException ex) {
                            textArea.append("Por favor, introduce números enteros válidos.\n");
                        }
                        break;
                    case "Calcular máximo":
                        String numeros = JOptionPane.showInputDialog("Introduce los números separados por comas:");
                        try {
                            String[] numerosSeparados = numeros.split(",");
                            int[] vector = new int[numerosSeparados.length];
                            for (int i = 0; i < numerosSeparados.length; i++) {
                                vector[i] = Integer.parseInt(numerosSeparados[i]);
                            }
                            int maximo = MaximoVector.calcularMaximo(vector, 0, vector.length - 1);
                            textArea.append("El valor máximo en el vector es: " + maximo + ".\n");
                        } catch (NumberFormatException ex) {
                            textArea.append("Por favor, introduce números enteros válidos separados por comas.\n");
                        }
                        break;
                    case "Convertir hexadecimal a decimal":
                        String hexadecimal = HexadecimalADecimal.generarHexadecimal(5); // Genera un número hexadecimal aleatorio de 5 dígitos
                        int decimal = HexadecimalADecimal.convertir(hexadecimal);
                        textArea.append("Número hexadecimal generado aleatoriamente: " + hexadecimal + "\n");
                        textArea.append("El valor decimal del número hexadecimal " + hexadecimal + " es: " + decimal + ".\n");
                        break;
                    case "Calcular C":
                        String nString = JOptionPane.showInputDialog("Introduce el valor de n:");
                        String kString = JOptionPane.showInputDialog("Introduce el valor de k:");
                        try {
                            int n = Integer.parseInt(nString);
                            int k = Integer.parseInt(kString);
                            int resultado = calcularC.calcularCombinatoria(n, k);
                            textArea.append("El resultado de C(" + n + ", " + k + ") es: " + resultado + ".\n");
                        } catch (NumberFormatException ex) {
                            textArea.append("Por favor, introduce números enteros válidos.\n");
                        }
                        break;
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}