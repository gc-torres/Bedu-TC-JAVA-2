package Sesion_2.Reto_1;

import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String>{
    public String call() throws Exception {
        Thread.sleep(600);
        return "Comunicaciones enlazadas"; 
    }
}
