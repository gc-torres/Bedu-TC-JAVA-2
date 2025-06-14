package Sesion_1.Reto_2;

public abstract class MaterialCurso {
    String titulo;
    String autor;

    public MaterialCurso (String titulo, String autor){
        this.autor = autor;
        this.titulo = titulo; 
    }
    public void mostrarDetalles(){
        System.out.println("Materiales de curso: ");
    }
}
