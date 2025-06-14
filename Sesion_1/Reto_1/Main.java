package Sesion_1.Reto_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista){
        boolean mostradasMasas = false;
        boolean mostradasPrototipos = false;
        boolean mostradasPersonalizadas = false;
        for (OrdenProduccion orden: lista){
            if (orden instanceof OrdenMasa && !mostradasMasas) {
                System.out.println("📋 Órdenes registradas:");
                mostradasMasas = true;
            } else if (orden instanceof OrdenPrototipo && !mostradasPrototipos){
                System.out.println();
                System.out.println("📋 Órdenes registradas:");
                mostradasPrototipos = true; 
            } else if (orden instanceof OrdenPersonalizada && !mostradasPersonalizadas){
                System.out.println();
                System.out.println("📋 Órdenes registradas:");
                mostradasPersonalizadas = true;
            }
            orden.mostrarResumen();
            
        }
    } 
    
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional){
        for (Object obj: lista){
            if(obj instanceof OrdenPersonalizada){
                OrdenPersonalizada op = (OrdenPersonalizada) obj; 
                System.out.println("✅ Orden: "+ op.codigo +
                                   " con costo adicional aplicado: $" + costoAdicional);
            }
        }
    }
    public static void main(String[] args) {
    OrdenMasa orden_1 = new OrdenMasa("A123", 500);
    OrdenMasa orden_2 = new OrdenMasa("A124", 750); 
    OrdenPersonalizada orden_3 = new OrdenPersonalizada("P456", 100, "Cliente X");
    OrdenPersonalizada orden_4 = new OrdenPersonalizada("P789", 5, "Cliente Y");
    OrdenPrototipo orden_5 = new OrdenPrototipo("T789", 10, "Diseño");
    OrdenPrototipo orden_6 = new OrdenPrototipo("T790", 5, "Pruebas");
        
        List<OrdenProduccion> listaOrdenes = new ArrayList<>(); 
        listaOrdenes.add(orden_1);
        listaOrdenes.add(orden_2);
        listaOrdenes.add(orden_3);
        listaOrdenes.add(orden_4);
        listaOrdenes.add(orden_5);
        listaOrdenes.add(orden_6);

        mostrarOrdenes(listaOrdenes);
        System.out.println();
        System.out.println("💰 Procesando órdenes personalizadas");
        procesarPersonalizadas(listaOrdenes, 200);
    }
}
