package com.tomasmercado.apirest.apirest.Repositories;
import com.tomasmercado.apirest.apirest.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
// persisntencia de datos
// especificamos nombre de entidad y tipo de datos de su identificador
// extiende de interfaz JPA, la cual nos permite conectar con datos
public interface ProductoRepositorie extends JpaRepository<Producto, Integer> {

}
