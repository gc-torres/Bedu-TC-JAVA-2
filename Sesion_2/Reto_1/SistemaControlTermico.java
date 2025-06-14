package Sesion_2.Reto_1;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String>{
    public String call() throws Exception{
        Thread.sleep(1000); 
        return "Controlando temperatura"; 
    }
}
