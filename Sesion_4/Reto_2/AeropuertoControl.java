package Sesion_4.Reto_2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {
    private static CompletableFuture<Boolean> checar(String nombre, int delaySeg, double probabilidad){
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, delaySeg + 1));
                boolean exito = Math.random() < probabilidad;
                System.out.println(nombre + " " + exito);
                return exito;
            } catch (InterruptedException e){
                throw new RuntimeException("Error al verificar " + nombre);
            }
        }); 
    }

    public static CompletableFuture<Boolean> verificarPista(){
        return checar("Pista abierta", 3, 0.80);
    }

    public static CompletableFuture<Boolean> verificarClima(){
        return checar("Despejado ", 3, 0.85);
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo(){
        return checar("Sin noticias", 3, 0.90);
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra(){
        return checar("Personal dispuesto ", 3, 0.95); 
    }

    public static void evaluarAterrizaje(){
        System.out.println("Verificando condiciones para aterrizar: ");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra(); 

        CompletableFuture.allOf(pista, clima, trafico, personal)
            .thenApply(v -> {
                try {
                    return pista.get() && clima.get() && trafico.get() && personal.get();
                } catch (Exception e){
                    throw new RuntimeException("Error al calcular");
                }
            })
            .thenAccept(resultado -> {
                if (resultado){
                    System.out.println("Aterrizaje favorecido");
                } else {
                    System.out.println("Aterrizaje denegado, posibles condiciones no favorables");
                }
            })
            .exceptionally(ex -> {
                System.out.println("Error al verificar" + ex.getMessage());
                return null; 
            }); 
    }

    public static void main(String[] args) throws InterruptedException {
        evaluarAterrizaje();
        Thread.sleep(5000); 
    }
}
