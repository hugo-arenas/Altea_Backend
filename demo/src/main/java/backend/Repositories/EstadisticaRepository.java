package main.java.backend.Repositories;

import java.util.List;
import backend.Models.Estadistica;

public interface EstadisticaRepository {
    public int countEstadistica();
    public List<Estadistica> getAllEstadistica();
    public Estadistica createEstadistica(Estadistica noticia);
    public boolean deleteEstadistica(long id);
    public Estadistica getEstadistica(long id);
    public boolean updateEstadistica(Estadistica nuevoEstadistica);
}