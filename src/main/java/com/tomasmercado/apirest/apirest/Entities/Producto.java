package com.tomasmercado.apirest.apirest.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;


// especificamos la entidad
@Entity
public class Producto {
    // agregamos el id de la base
    @Id
    // esto genera un id incremental unico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //creamos el metodo
    private int id;
    private String nombre;
    private double precio;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
