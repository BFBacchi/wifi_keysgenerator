import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
    // Define el rango de combinaciones de números
    private static final long START_RANGE = 10_000_000L;
    private static final long END_RANGE = 40_000_000L;

    public static void main(String[] args) {
        // Nombre del archivo donde se escribirán las claves Wi-Fi generadas
        String fileName = "wifi_keys.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Genera claves dentro del rango especificado
            for (long i = START_RANGE; i <= END_RANGE; i++) {
                // Convierte el número actual en una cadena de 8 caracteres
                String key = String.format("%08d", i);

                // Escribe la clave generada en el archivo
                writer.write(key);
                writer.newLine();

                // Muestra el progreso cada 100,000 claves generadas
                if (i % 100_000 == 0) {
                    System.out.printf("\rProgreso: %.2f%%", (double) (i - START_RANGE) / (END_RANGE - START_RANGE) * 100);
                    System.out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        System.out.println("\nGeneración de claves completada.");
    }
}
