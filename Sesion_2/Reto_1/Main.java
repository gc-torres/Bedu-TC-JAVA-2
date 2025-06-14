package Sesion_2.Reto_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
            new Pedido("Ana", "domicilio", "555-1234"),
            new Pedido("Luis", "local", "555-5678"),
            new Pedido("Carlos", "domicilio", null),
            new Pedido("María", "domicilio", "555-9999")
        );

    pedidos.stream()
        .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
        .map(Pedido::getTelefono)
        .flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty))
        .map(tel -> "📞 Confirmación enviada al número: " + tel)
        .forEach(System.out::println); 
    }
}
