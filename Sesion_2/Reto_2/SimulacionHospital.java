package Sesion_2.Reto_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía"); 

        Runnable drSanchez = () -> salaCirugia.usar("Dra. Sánchez");
        Runnable drGomez = () -> salaCirugia.usar("Dr. Gomez");
        Runnable enf_lopez = () -> salaCirugia.usar("Enfermero López");
        Runnable drMartinez= () -> salaCirugia.usar("Dr. Martinez");
        
        ExecutorService ejecutador = Executors.newFixedThreadPool(4);
        ejecutador.submit(drSanchez);
        ejecutador.submit(drGomez);
        ejecutador.submit(enf_lopez);
        ejecutador.submit(drMartinez);

        ejecutador.shutdown();
    }
}
