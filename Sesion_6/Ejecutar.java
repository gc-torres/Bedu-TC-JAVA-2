package org.Bedu.reactivo.Sesion_6;

import org.Bedu.reactivo.Sesion_6.Reto_2.Marca;
import org.Bedu.reactivo.Sesion_6.Reto_2.MarcaRepository;
import org.Bedu.reactivo.Sesion_6.Reto_2.Producto;
import org.Bedu.reactivo.Sesion_6.Reto_2.ProductoRepositoryReto2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejecutar {
    public static void main(String[] args) {
        SpringApplication.run(Ejecutar.class, args); 
    }

    @Bean
    CommandLineRunner runner(MarcaRepository marcaRepo, ProductoRepositoryReto2 productoRepo){
        return args -> {
            Marca apple = new Marca("Apple"); 
            Marca samsung = new Marca("Samsung"); 

            marcaRepo.save(apple);
            marcaRepo.save(samsung); 

            productoRepo.save(new Producto("Iphone 15", apple)); 
            productoRepo.save(new Producto("iPad Pro", apple));
            productoRepo.save(new Producto("Galaxy S23", samsung));
            productoRepo.save(new Producto("Smart TV", samsung));

            System.out.println("Productos por marca: ");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("Marca: " + marca.getNombre() + ": ");
                productoRepo.findAll().stream()
                            .filter(p -> p.getMarca().getId().equals(marca.getId()))
                            .forEach(p-> System.out.println("- " + p.getNombre()));
            });

        }; 
    }
}
