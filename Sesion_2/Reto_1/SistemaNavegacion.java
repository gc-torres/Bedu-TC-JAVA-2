package Sesion_2.Reto_1;

import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1200);
        return "Navegación: corriegiendo"; 
    }
}
