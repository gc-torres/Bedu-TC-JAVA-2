package Sesion_2.Reto_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MisionEspacial {
    public static void main(String[] args) throws Exception{
        System.out.println("Simulación de misión espacial");

        ExecutorService ejecutador = Executors.newFixedThreadPool(4);

        Future<String> navegacion = ejecutador.submit(new SistemaNavegacion());
        Future<String> soporte = ejecutador.submit(new SistemaSoporteVital());
        Future<String> termico = ejecutador.submit(new SistemaControlTermico());
        Future<String> comunicaciones = ejecutador.submit(new SistemaComunicaciones());

        System.out.println(comunicaciones.get());
        System.out.println(soporte.get());
        System.out.println(termico.get());
        System.out.println(navegacion.get());

        ejecutador.shutdown();
        System.out.println("Todos los sistemas se encuentran operativos");
    }
}
