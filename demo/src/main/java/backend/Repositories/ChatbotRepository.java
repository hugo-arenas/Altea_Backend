package main.java.backend.Repositories;

import java.util.List;
import backend.Models.Chatbot;

public interface ChatbotRepository {
    public int countChatbot();
    public List<Chatbot> getAllChatbot();
    public Chatbot createChatbot(Chatbot chatbot);
    public boolean deleteChatbot(long id);
    public Chatbot getChatbot(long id);
    public boolean updateChatbot(Chatbot nuevoChatbot);
}