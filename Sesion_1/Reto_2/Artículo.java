package Sesion_1.Reto_2;

public class Artículo extends MaterialCurso{
    int palabras;

    public Artículo (String autor, String titulo, int palabras){
        super(titulo, autor);
        this.palabras = palabras;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("📄 Artículo: " + titulo + " - Autor: " + autor + " - Palabras: " + palabras);
    }
}
