package Sesion_3.Reto_1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    public static CompletableFuture<String> calcularRuta(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Calulando...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2,4));
                return " Ruta sureste -> noreste";
            } catch (InterruptedException e){
                throw new RuntimeException("Error en ruta");
            }
        }); 
    }

    public static CompletableFuture<Double> estimarTarifa(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Esperando tarifa...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
                return 75.50; 
            } catch (InterruptedException e){
                throw new RuntimeException("Error al calcular la tarifa");
            }
        }); 
    }

    public static void solicitar_viaje(){
        CompletableFuture<String> rutaFutura = calcularRuta(); 
        CompletableFuture<Double> tarifaFutura = estimarTarifa(); 

        rutaFutura
            .thenCombine(tarifaFutura, (ruta, tarifa)->
                "✅ 🚗" + ruta + " tarifa estimada: $ " + tarifa
            ) 
            .exceptionally(ex -> "Ocurrio algo: " + ex.getMessage())
            .thenAccept(System.out::println); 
        }

    public static void main(String[] args) throws InterruptedException {
        solicitar_viaje();

        System.out.println("Esperando por otras solicitudes...");
        Thread.sleep(5000);
    }
}
