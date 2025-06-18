package org.Bedu.reactivo.Sesion_5;

import java.time.Duration;
import java.util.Random;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;;
public class PacienteMonitor {
    public static void main(String[] args) throws InterruptedException {
        Flux<String> paciente1 = simularPaciente(1).delayElements(Duration.ofSeconds(1)); 
        Flux<String> paciente2 = simularPaciente(2).delayElements(Duration.ofSeconds(1)); 
        Flux<String> paciente3 = simularPaciente(3).delayElements(Duration.ofSeconds(1)); 

        Flux.merge(paciente1, paciente2, paciente3)
            .subscribe(alerta -> System.out.println(alerta)); 

        Thread.sleep(2000); 
         
    }

    public static Flux<String> simularPaciente(int id){
        Random random = new Random(); 

        return Flux.interval(Duration.ofMillis(300))
                   .flatMap(i -> {
                        int fc = random.nextInt(100) + 30;
                        int paSistolica = random.nextInt(80) + 80;
                        int paDiastolica = random.nextInt(50) + 40;
                        int spo2 = random.nextInt(15) + 85;

                        if (fc < 50 || fc > 120) {
                            return Flux.just("Paciente " + id + " - FC crítica: " + fc + " bpm");
                        } else if (paSistolica < 90 || paSistolica > 140 || paDiastolica < 60 || paDiastolica > 90) {
                            return Flux.just("Paciente " + id + " - PA crítica: " + paSistolica + "/" + paDiastolica + " mmHg");
                        } else if (spo2 < 90) {
                            return Flux.just("Paciente " + id + " - SpO2 baja: " + spo2 + "%");
                        } else {
                            return Flux.empty(); 
                        }
                    }) 
                    .publishOn(Schedulers.parallel()); 
    }
}
