package org.Bedu.reactivo.Sesion_6.Reto_2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String nombre; 

    public Marca(){}

    public Marca(String nombre){
        this.nombre = nombre;
    }

    public Long getId(){
        return id; 
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
