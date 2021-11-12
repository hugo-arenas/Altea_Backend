package main.java.backend.Models;

public class Estadistica {
    private Long id;
    private String Nombre;
    private String Descripcion;

    public Estadistica(Long id, String Nombre, String Descripcion){
        this.id = id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}