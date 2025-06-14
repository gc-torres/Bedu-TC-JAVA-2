package Sesion_3.Reto_2;

import java.util.Arrays;
import java.util.List; 
import java.util.stream.*; 

public class Main {
    public static void main(String[] args) {
        Encuesta e1 = new Encuesta("María", "El tiempo de espera fue largo", 1); 
        Encuesta e2 = new Encuesta("Fernando", null, 5); 
        Encuesta e3 = new Encuesta("Ana María", "La atención es buena, pero la limpieza puede mejorar", 3); 
        Encuesta e4 = new Encuesta("Leonardo", null, 4); 
        
        Sucursal sureste = new Sucursal("Centro sureste", Arrays.asList(e1,e2));
        Sucursal noreste = new Sucursal("Centro noreste", Arrays.asList(e3,e4));

        List<Sucursal> conjunto_sucursales = Arrays.asList(sureste,noreste); 

        conjunto_sucursales.stream()
            .flatMap(sucursal ->
                sucursal.getEncuestas().stream()
                    .filter(e -> e.getCalificacion() <= 3)
                    .flatMap(e -> e.getComentario()
                        .map(c -> Stream.of("Sucursal " + sucursal.getNombre()
                                            + ": Segumiento a paciente: " + c))
                        .orElseGet(Stream::empty)
                        )
                    
               )
                .forEach(System.out::println); 
        
    }
}
