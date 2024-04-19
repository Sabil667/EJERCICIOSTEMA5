import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GestionFechas {
    private List<Date> fechas;
    private SimpleDateFormat formatoFecha;

    public GestionFechas() {
        fechas = new ArrayList<>();
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void agregarFecha(String fecha) {
        try {
            Date fechaConvertida = formatoFecha.parse(fecha);
            fechas.add(fechaConvertida);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha. Asegúrate de que esté en el formato dd/MM/yyyy.");
            e.printStackTrace();
        }
    }

    public List<String> obtenerFechasOrdenadas() {
        Collections.sort(fechas);
        List<String> fechasOrdenadas = new ArrayList<>();
        for (Date fecha : fechas) {
            fechasOrdenadas.add(formatoFecha.format(fecha));
        }
        return fechasOrdenadas;
    }
}