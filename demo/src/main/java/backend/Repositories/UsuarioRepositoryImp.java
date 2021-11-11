package backend.Repositories;

import backend.Models.UsuarioModel;
import backend.Repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countUsuario() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Usuario").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<UsuarioModel> getAllUsuario() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("ID AS ID, Nombre AS Nombre, Apellido AS Apellido, edad AS Edad, Correo AS E-mail, Contrasenia AS Contraseña").executeAndFetch(UsuarioModel.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UsuarioModel createUsuario(UsuarioModel Usuario) {
        try(Connection conn = sql2o.open()){
            UsuarioModel v1 = conn.createQuery("select * from Usuario where Email=:Email").addParameter("Email",Usuario.getCorreo()).executeAndFetchFirst(UsuarioModel.class);
            if (v1 == null){
                int insertedId = countUsuario()+1;
                conn.createQuery("insert into Usuario (ID, Nombre, Apellido, edad, Correo, Contrasenia, loginToken)"+
                        " values (:id, :UsuarioNombre, :UsuarioApellido, :edad, :email, :pass)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("UsuarioNombre", Usuario.getNombre())
                        .addParameter("UsuarioApellido", Usuario.getApellido())
                        .addParameter("edad", Usuario.getEdad())
                        .addParameter("email", Usuario.getCorreo())
                        .addParameter("pass", Usuario.getContrasenia())
                        .addParameter("loginToken", 0)
                        .executeUpdate().getKey();
                Usuario.setId(insertedId);
                return Usuario;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deleteUsuario(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Usuario WHERE ID = :id")
            .addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public UsuarioModel getUsuario(long id){
		String sql = "select ID AS ID, Nombre AS Nombre, Apellido AS Apellido, edad AS Edad, Correo AS E-mail, Contrasenia AS Contraseña, loginToken AS LoginToken from Usuario where ID=:id";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(UsuarioModel.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateUsuario(UsuarioModel nuevoUsuario){
        String updateSql = "update Usuario set Nombre = : Nombre, Apellido = : Apellido, edad = : Edad, Correo = : E-mail, Contrasenia = : Contraseña, loginToken = :loginToken where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Apellido", nuevoUsuario.getApellido())
                .addParameter("Nombre",nuevoUsuario.getNombre())
                .addParameter("id", nuevoUsuario.getId())
                .addParameter("Edad", nuevoUsuario.getEdad())
                .addParameter("email", nuevoUsuario.getCorreo())
                .addParameter("pass", nuevoUsuario.getContrasenia())
                .addParameter("loginToken", nuevoUsuario.getLoginToken())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public UsuarioModel getUserByToken(String token){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Usuario WHERE loginToken = :v_token")
                    .addParameter("v_token", token)
                    .executeAndFetchFirst(UsuarioModel.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UsuarioModel logIn(UsuarioModel user) {
        System.out.println("HOLA BUENOS DÍAS/BUENAS TARDE/BUENAS NOCHES");
        try(Connection conn = sql2o.open()){
            System.out.println("HOLA BUENOS DÍAS/BUENAS TARDE/BUENAS NOCHES");
            List<UsuarioModel> findUsers = conn.createQuery("select * from Usuario where Correo=:email and Contrasenia=:pass")
                .addParameter("email", user.getCorreo())
                .addParameter("pass", user.getContrasenia())
                .executeAndFetch(UsuarioModel.class);
            if(findUsers.size() == 1){
                System.out.println("Usuario ingresado con exito");
                user.setLoginToken(1);
                updateUsuario(user);
                return user;
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }   
    @Override
    public String logOut(UsuarioModel user){
        try(Connection conn = sql2o.open()){
            List<UsuarioModel> findUsers = conn.createQuery("select * from Usuario where id=:id")
                    .addParameter("id", user.getId())
                    .executeAndFetch(UsuarioModel.class);
            if(findUsers.size() == 1){
                try(Connection con = sql2o.open()){
                    user.setLoginToken(0);
                    updateUsuario(user);
                    return "LogOut Successfully";
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    return  "LogOut Fail";
                }
            }else{
                return "LogOut Fail";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return " Deslogeado Fail";
        }
    }
}
