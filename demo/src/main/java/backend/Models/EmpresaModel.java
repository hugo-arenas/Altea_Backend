package main.java.backend.Models;

public class EmpresaModel {
    private Long id;
    private String Nombre;
    private String Correo;
    private String Contrasenia;

    public EmpresaModel(Long id, String Nombre, String Correo, String Contrasenia){
        this.id = id;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Contrasenia = Contrasenia;
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }
}

