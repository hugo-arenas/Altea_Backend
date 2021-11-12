package main.java.backend.Models;

public class RespChat {
    private Long id;
    private String Descripcion;
    private Long id_chatbot;

    public RespChat(Long id, String Descripcion, Long id_chatbot){
        this.id = id;
        this.Descripcion = Descripcion;
        this.id_chatbot = id_chatbot;
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

    public Long getId_chatbot() {
        return this.id_chatbot;
    }

    public void setId_chatbot(Long id_chatbot) {
        this.id_chatbot = id_chatbot;
    }
    
}