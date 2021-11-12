package main.java.backend.Repositories;

import java.util.List;
import backend.Models.RespUs;

public interface RespUsRepository {
    public int countRespUs();
    public List<RespUs> getAllRespUs();
    public RespUs createRespUs(RespUs RespUs);
    public boolean deleteRespUs(long id);
    public RespUs getRespUs(long id);
    public boolean updateRespUs(RespUs nuevoRespUs);
}