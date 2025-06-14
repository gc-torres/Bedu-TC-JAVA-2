package Sesion_1.Reto_1;

import java.util.List;

public abstract class OrdenProduccion {
    String codigo;
    int cantidad; 

    public OrdenProduccion(String codigo, int cantidad){
        this.codigo = codigo; 
        this.cantidad = cantidad; 
    }

    public void mostrarResumen(){
        System.out.println("Ordenes registradas");
    }

    public void mostrarOrdenes (List<? extends OrdenProduccion> lista){}

    public void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional){}

}
