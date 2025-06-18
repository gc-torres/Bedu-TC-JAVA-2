package org.Bedu.reactivo.Sesion_6.Reto_1;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByPrecioGreaterThan(double precio); 
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByPrecioBetween(double min, double max);
    List<Producto> findByNombreStartingWithIgnoreCase(String prefijo);   
    
} 