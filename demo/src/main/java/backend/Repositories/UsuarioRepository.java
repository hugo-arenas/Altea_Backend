package main.java.com.example.demo.Altea.Repositories;
import java.util.List;
import cl.tbd.ejemplo1.models.UsuarioModel;

public interface UsuarioRepository {
    public int countUsuario();
    public List<Usuario> getAllUsuario();
    public Usuario createUsuario(Usuario usuario);
    public boolean deleteUsuario(int id);
    public Usuario getUsuario(int id);
    public boolean updateUsuario(Usuario nuevoUsuario);
    public Usuario getUserByToken(String token);
    public Usuario logIn(Usuario user);
    public String logOut(Usuario user);
    public List<Vol_habilidad> miHabilidad(int id);
}
