package Sesion_1.Reto_2;

public class Video extends MaterialCurso{
    int duracion;

    public Video (String autor, String titulo, int duracion){
        super(titulo, autor);
        this.duracion = duracion;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("🎥 Video: " + titulo + " - Autor: " + autor + " - Duracion: " + duracion);
    }
}
