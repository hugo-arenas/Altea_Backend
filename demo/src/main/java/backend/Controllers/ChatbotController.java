package backend.Controllers;

import backend.Models.ChatbotController;
import backend.Repositories.ChatbotRepository;

@CrossOrigin(origins="*")
@RestController
public class ChatbotController {
    @Autowired
    ChatbotRepository chatbotRepository;

    @GetMapping("/chatbots")
    public List<Chatbot> getAllChatbots(){
        return chatbotRepository.findAll();
    }

    @GetMapping("/chatbots/{id}")
    public Chatbot getChatbot(@PathVariable(value="id") Long id){
        return chatbotRepository.findChatbotById(id);
    }

    @PostMapping("/chatbots")
    public Chatbot createChatbot(@RequestBody Chatbot chatbot){
        return chatbotRepository.save(chatbot);
    }

    @DeleteMapping("/chatbot/{id}")
    public ResponseEntity<Chatbot> deleteChatbot(@PathVariable (value = "id") Long id){
        chatbotRepository.delete(chatbotRepository.findChatbotById(id));
        return ResponseEntity.ok().build();
    }
}