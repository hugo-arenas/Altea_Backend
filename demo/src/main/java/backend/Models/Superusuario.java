package main.java.backend.Models;

public class Superusuario {
    private Long id;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Contrasenia;
    private int loginToken;

    public Superusuario(Long id, String Nombre, String Apellido, String Correo, String Contrasenia, int loginToken){
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Contrasenia = Contrasenia;
        this.loginToken = loginToken;
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

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
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

    public int getLoginToken() {
		return this.loginToken;
	}

	public void setLoginToken(int loginToken) {
		this.loginToken = loginToken;
	}
}