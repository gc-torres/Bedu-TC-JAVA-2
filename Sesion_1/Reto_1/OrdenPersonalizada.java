package Sesion_1.Reto_1;

public class OrdenPersonalizada extends OrdenProduccion{
    String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente){
        super(codigo, cantidad); 
        this.cliente = cliente;
    }
    @Override
    public void mostrarResumen(){
        System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente);
    }
}
