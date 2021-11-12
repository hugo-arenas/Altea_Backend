package main.java.backend.Models;

public class RespChat {
    private Long id;
    private String Descripcion;

    public RespChat(Long id, String Descripcion){
        this.id = id;
        this.Descripcion = Descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}