package velocidadgestores.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.LocalDateTime;
import javax.swing.SwingUtilities;
import java.util.concurrent.atomic.AtomicInteger;
import database.query.QueryExecutor;

public class SchedulerUtil {

    public static void ejecutarConSchedulerYInserciones(QueryExecutor executor, Runnable task, int intervalSeconds, Runnable onFinish, AtomicInteger contador) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable imprimirMensaje = new Runnable() {
            private int count = 0;

            @Override
            public void run() {
                System.out.println("Han pasado " + (count * intervalSeconds) + " segundos desde la ejecución del botón.");
                count++;
                if (count * intervalSeconds >= 60) { // Si han pasado 60 segundos
                    scheduler.shutdown();
                    // Ejecuta la acción de finalización en el hilo de la interfaz de usuario
                    SwingUtilities.invokeLater(onFinish);
                }
            }
        };

        scheduler.scheduleAtFixedRate(imprimirMensaje, 0, intervalSeconds, TimeUnit.SECONDS);

        LocalDateTime endTime = LocalDateTime.now().plusMinutes(1);

        while (LocalDateTime.now().isBefore(endTime)) {
            task.run();
            contador.incrementAndGet();
        }

        System.out.println("Ha pasado un minuto.");
        System.out.println("Se insertaron " + contador.get() + " registros en un minuto.");
    }
}
