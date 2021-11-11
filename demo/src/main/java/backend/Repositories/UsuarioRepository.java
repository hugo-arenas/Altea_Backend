package backend.Repositories;

import java.util.List;
import backend.Models.UsuarioModel;

public interface UsuarioRepository {
    public int countUsuario();
    public List<UsuarioModel> getAllUsuario();
    public UsuarioModel createUsuario(UsuarioModel usuario);
    public boolean deleteUsuario(long id);
    public UsuarioModel getUsuario(long id);
    public boolean updateUsuario(UsuarioModel nuevoUsuario);
    public UsuarioModel getUserByToken(String token);
    public UsuarioModel logIn(UsuarioModel user);
    public String logOut(UsuarioModel user);
}
