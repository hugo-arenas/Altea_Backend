package main.java.backend.Repositories;

import backend.Models.Empresa;
import backend.Repositories.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class EmpresaRepositoryImp implements EmpresaReposaaaitory {
    
    @Autowired
    private Sql2o sql2o;
    
    @Override
    public int countEmpresa() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM Empresa").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Empresa> getAllEmpresa() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("ID AS ID, Nombre AS Nombre, Correo AS Correo, Contrasenia AS Contrasenia").executeAndFetch(Empresa.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Empresa createEmpresa(Empresa empresa) {
        try(Connection conn = sql2o.open()){
            Empresa v1 = conn.createQuery("select * from Empresa where Correo=:Correo").addParameter("Corr",SuperUsuario.getCorreo()).executeAndFetchFirst(SuperUsuario.class);
            if (v1 == null){
                int insertedId = countEmpresa()+1;
                conn.createQuery("insert into Empresa (ID, Nombre, Correo, Contrasenia, loginToken)"+
                        " values (:id, :EmpresaNombre, :correo, :pass)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("EmpresaNombre", Empresa.getNombre())
                        .addParameter("correo", Empresa.getCorreo())
                        .addParameter("pass", Empresa.getContrasenia())
                        .addParameter("loginToken", 0)
                        .executeUpdate().getKey();
                Empresa.setId(insertedId);
                return Empresa;  
            }else{
                return null;
            }

      
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public boolean deleteEmpresa(long id){
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM Empresa WHERE ID = :id")
            .addParameter("id", id)
            .executeUpdate();
            return true; 
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Empresa getEmpresa(long id){
		String sql = "select ID AS ID, Nombre AS Nombre, Correo AS Correo, Contrasenia AS Contrasenia, loginToken AS LoginToken from Empresa where ID=:id";
		try (Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id", id)
				.executeAndFetchFirst(Empresa.class);
		}catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

    @Override
    public boolean updateEmpresa(Empresa nuevoEmpresa){
        String updateSql = "update Empresa set Nombre = : Nombre, Correo = : Correo, Contrasenia = : Contrasenia, loginToken = :loginToken where id = :id";
        try (Connection con = sql2o.open()) {   
            con.createQuery(updateSql)
                .addParameter("Nombre",nuevoEmpresa.getNombre())
                .addParameter("id", nuevoEmpresa.getId())
                .addParameter("Correo", nuevoEmpresa.getCorreo())
                .addParameter("Contrasenia", nuevoEmpresa.getContrasenia())
                .addParameter("loginToken", nuevoEmpresa.getLoginToken())
                .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Empresa getUserByToken(String token){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM Empresa WHERE loginToken = :v_token")
                    .addParameter("v_token", token)
                    .executeAndFetchFirst(Empresa.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Empresa logIn(Empresa user) {
        System.out.println("HOLA BUENOS DÍAS/BUENAS TARDE/BUENAS NOCHES");
        try(Connection conn = sql2o.open()){
            System.out.println("HOLA BUENOS DÍAS/BUENAS TARDE/BUENAS NOCHES");
            List<Empresa> findUsers = conn.createQuery("select * from Empresa where Correo=:Correo and Contrasenia=:Contrasenia")
                .addParameter("Correo", user.getCorreo())
                .addParameter("Constraenia", user.getContrasenia())
                .executeAndFetch(Empresa.class);
            if(findUsers.size() == 1){
                System.out.println("Empresa ingresado con exito");
                user.setLoginToken(1);
                updateEmpresa(user);
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
    public String logOut(Empresa user){
        try(Connection conn = sql2o.open()){
            List<Empresa> findUsers = conn.createQuery("select * from Empresa where id=:id")
                    .addParameter("id", user.getId())
                    .executeAndFetch(Empresa.class);
            if(findUsers.size() == 1){
                try(Connection con = sql2o.open()){
                    user.setLoginToken(0);
                    updateEmpresa(user);
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
