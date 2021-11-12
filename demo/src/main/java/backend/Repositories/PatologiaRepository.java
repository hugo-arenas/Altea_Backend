package main.java.backend.Repositories;

import java.util.List;
import backend.Models.Patologia;

public interface PatologiaRepository {
    public int countPatologia();
    public List<Patologia> getAllPatologia();
    public Patologia createPatologia(Patologia patologia);
    public boolean deletePatologia(long id);
    public Patologia getPatologia(long id);
    public boolean updatePatologia(Patologia nuevoPatologia);
}