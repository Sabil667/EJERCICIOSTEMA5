import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BusquedaTexto {
    private List<String> palabras;

    public BusquedaTexto(String rutaArchivo) {
        palabras = new ArrayList<>();
        try {
            File archivo = new File(rutaArchivo);
            Scanner lector = new Scanner(archivo);
            while (lector.hasNext()) {
                palabras.add(lector.next());
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }

        Collections.sort(palabras);
    }

    public boolean busquedaLineal(String palabraBusqueda) {
        for (String palabra : palabras) {
            if (palabra.equals(palabraBusqueda)) {
                return true;
            }
        }
        return false;
    }

    public boolean busquedaBinaria(String palabraBusqueda) {
        int izquierda = 0;
        int derecha = palabras.size() - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            int res = palabraBusqueda.compareTo(palabras.get(medio));

            if (res == 0) {
                return true;
            }

            if (res > 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return false;
    }
}
