package main.java.backend.Repositories;

import java.util.List;
import backend.Models.Consejo;

public interface ConsejoRepository {
    public int countConsejo();
    public List<Consejo> getAllConsejo();
    public Consejo createConsejo(Consejo noticia);
    public boolean deleteConsejo(long id);
    public Consejo getConsejo(long id);
    public boolean updateConsejo(Consejo nuevoConsejo);
}