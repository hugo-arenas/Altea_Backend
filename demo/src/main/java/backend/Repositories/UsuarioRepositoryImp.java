package main.java.com.example.demo.Altea.Repositories;

import main.java.com.example.demo.Repositories.UserRepository;


@Repository
public class UsuarioRepository {
    
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
    public List<Usuario> getAllUsuario() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("ID AS ID, Nombre AS Nombre, Apellido AS Apellido, edad AS Edad, Correo AS E-mail, Contrasenia AS Contraseña").executeAndFetch(Usuario.class);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario createUsuario(Usuario Usuario) {
        try(Connection conn = sql2o.open()){
            Usuario v1 = conn.createQuery("select * from Usuario where Email=:Email").addParameter("Email",Usuario.getEmail()).executeAndFetchFirst(Usuario.class);
            if (v1 == null){
                int insertedId = countUsuario()+1;
                String point = "public.ST_GeomFromText(POINT("+Usuario.getLongitud()+" "+Usuario.getLatitud()+"),4326)";
                conn.createQuery("insert into Usuario (ID, Nombre, Apellido, correo, pass, loginToken, ubicacion)"+
                        " values (:id, :UsuarioNombre, :UsuarioFnacimiento, :email, :pass, :loginToken, :ubicacion)") 
                        .addParameter("id",  insertedId)                
                        .addParameter("UsuarioNombre", Usuario.getNombre())
                        .addParameter("UsuarioFnacimiento", Usuario.getFnacimiento())
                        .addParameter("email", Usuario.getEmail())
                        .addParameter("pass", Usuario.getPass())
                        .addParameter("loginToken", 0)
                        .addParameter("ubicacion", point)
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
}
