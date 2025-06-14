package Sesion_1.Ejemplo_1;

public class Almacen<T> {

    private T producto;

    public void guardarProducto(T producto){
        this.producto = producto;
        System.out.println("Producto guardado: " + producto);
    }

    public T obtenerProducto(){
        return producto;
    }
    
    public boolean estaVacio(){
        return producto == null;
    }

    public void mostrarTipoProducto(){
        if (producto != null){
            System.out.println("El producto es: " + producto.getClass());
        } else {
            System.out.println("El almacén esta vacio");
        }
    }
}