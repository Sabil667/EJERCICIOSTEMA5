package Ejercicios;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OrganizacionDocumentos {
    public static void ordenarDocumentos(String rutaArchivo) {
        List<String> palabras = new ArrayList<>();
        try {
            File archivo = new File(rutaArchivo);
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String[] palabrasLinea = lector.nextLine().split("\\s+");
                palabras.addAll(Arrays.asList(palabrasLinea));
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }

        Collections.sort(palabras);

        // Crear una nueva ventana y un JTextArea
        JFrame frame = new JFrame("Texto Ordenado");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // La ventana se cierra sin terminar el programa
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea); // Agregar un scroll pane al JTextArea
        frame.add(scrollPane);

        // Agregar las palabras ordenadas al JTextArea
        for (String palabra : palabras) {
            textArea.append(palabra + "\n");
        }

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
