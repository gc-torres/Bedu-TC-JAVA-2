package Sesion_1.Ejemplo_1;

public class Main {
    public static void main(String[] args) {
        Almacen<String> almacenropa = new Almacen<>();
        System.out.println("Vacio?" + almacenropa.estaVacio());
        almacenropa.guardarProducto("Camiseta");
        almacenropa.mostrarTipoProducto();
        
        Almacen<Integer> numeros = new Almacen<>();
        numeros.guardarProducto(34);
        numeros.mostrarTipoProducto();

        Almacen<String> alimentos = new Almacen<>();
        alimentos.guardarProducto("platano");
        alimentos.mostrarTipoProducto();

        System.out.println("productos");
        System.out.println("ropa: " + almacenropa.obtenerProducto());
        System.out.println("numeros: " + numeros.obtenerProducto());
        System.out.println("alimentos: " + alimentos.obtenerProducto());
    }
}
