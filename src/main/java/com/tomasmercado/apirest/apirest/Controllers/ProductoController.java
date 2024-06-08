package com.tomasmercado.apirest.apirest.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tomasmercado.apirest.apirest.Entities.Producto;
import com.tomasmercado.apirest.apirest.Repositories.ProductoRepositorie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;




// especificamos que será una ApiRest
@RestController
// endpoint a consumir por cliente(lo probamos desde postman)
@RequestMapping("/productos")
public class ProductoController {
    // creamos el CRUD

    // autowired para conectar con
    // repositorio
    @Autowired
    private ProductoRepositorie productoRepositorie;

    // get para devolver todos los productos
    // del repositorio Productos(Entities)
    @GetMapping
    public List<Producto> getAllProducts(){
        return productoRepositorie.findAll();
    }

    // get individual
    // busca por id
    // y maneja el error si no lo encuentra
    @GetMapping("/{id}")
    public Producto getProductByIde(@PathVariable Integer id) {
        return productoRepositorie.findById(id)
        .orElseThrow( () -> new RuntimeException("No se encontro el id: "+ id));
    }
    

    // metodo post para guardar nuevos registros
    @PostMapping
    // especificamos un body de resquest
    // del mismo tipo de la clase Producto
    // de la carpeta entities
    public Producto createProducto(@RequestBody Producto producto) {
        //TODO: process POST request
        return productoRepositorie.save(producto);
    }
    
    // actualización
    // actualizamos nombre y precio
    // buscando los getters y setters
    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable int id, @RequestBody Producto detallesProducto) {
        Producto producto = productoRepositorie.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el id: "+ id));
        
        //llamo a los get/set
        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        return productoRepositorie.save(producto);
    }

    // delete
    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable int id){
        // instanciamos un objeto y almacenamos sus datos
        Producto producto = productoRepositorie.findById(id)
        .orElseThrow(() -> new RuntimeException("El id: "+id+", no se encontró!"));
        // elimina el producto que encuentra
        productoRepositorie.delete(producto);
        // devolvemos un msj con el id eliminado
        return "El producto con el id: "+id+", fue eliminado con exito!";        
    }

}
