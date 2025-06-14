package Sesion_1.Reto_2;

import java.util.ArrayList;
import java.util.List;


public class Main {
        public static void mostrarMateriales(List<? extends MaterialCurso> lista){
            for (Object obj: lista){
            if(obj instanceof MaterialCurso){
                MaterialCurso op = (MaterialCurso) obj; 
                op.mostrarDetalles();
            }
        }
    }
    public static void contarDuracionVideos(List<? extends Video> lista){
            int total = 0; 
            for (Object obj: lista){
                Video op = (Video) obj;
                total += op.duracion; 
            }
            System.out.println();
            System.out.println("🎥 Duración total de videos: " + total);
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
            for (Object obj: lista){
            if(obj instanceof Ejercicio){
                Ejercicio op = (Ejercicio) obj; 
                op.revisado = true;
                System.out.println();
                System.out.println("✅ Ejercicio " + op.titulo + " marcado como " + op.revisado);
            }
        }
} 

public static void main(String[] args) {
    List<MaterialCurso> materiales = new ArrayList<>();
    Video video_1 = new Video("Mario", "Introducción a Java", 15);
    Video video_2 = new Video("Carlos", "POO en Java", 20);
    Artículo articulo_1 = new Artículo("Ana", "Historia de Java", 1200); 
    Artículo artículo_2 = new Artículo("Luis", "Tipos de datos", 800);
    Ejercicio ejercicio_1 = new Ejercicio("Luis", "Variables y tipos", false);
    Ejercicio ejercicio_2 = new Ejercicio("Mario", "Condicionales", false); 

    materiales.add(video_1);
    materiales.add(video_2);
    materiales.add(articulo_1);
    materiales.add(artículo_2);
    materiales.add(ejercicio_1);
    materiales.add(ejercicio_2);
    mostrarMateriales(materiales);
    List <Video> videos = new ArrayList<>();
    videos.add(video_1); 
    videos.add(video_2);
    contarDuracionVideos(videos);
    marcarEjerciciosRevisados(materiales);
}
}
