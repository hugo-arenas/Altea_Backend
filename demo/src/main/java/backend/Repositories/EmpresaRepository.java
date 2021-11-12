package main.java.backend.Repositories;

import java.util.List;
import backend.Models.Empresa;

public interface EmpresaRepository {
    public int countEmpresa();
    public List<Empresa> getAllEmpresa();
    public Empresa createEmpresa(Empresa empresa);
    public boolean deleteEmpresa(long id);
    public Empresa getEmpresa(long id);
    public boolean updateEmpresa(Empresa nuevoEmpresa);
    public Empresa getUserByToken(String token);
    public Empresa logIn(Empresa user);
    public String logOut(SupEmpresa user);
}
