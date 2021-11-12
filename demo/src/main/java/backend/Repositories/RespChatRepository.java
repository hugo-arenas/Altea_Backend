package main.java.backend.Repositories;

import java.util.List;
import backend.Models.RespChat;

public interface RespChatRepository {
    public int countRespChat();
    public List<RespChat> getAllRespChat();
    public RespChat createRespChat(RespChat respchat);
    public boolean deleteRespChat(long id);
    public RespChat getRespChat(long id);
    public boolean updateRespChat(RespChat nuevoRespChat);
}