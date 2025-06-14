package Sesion_1.Reto_2;

public class Ejercicio extends MaterialCurso{
    boolean revisado; 
    
    public Ejercicio (String autor, String titulo, boolean revisado){
        super(titulo, autor);
        this.revisado = revisado;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("📝 Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }
}
