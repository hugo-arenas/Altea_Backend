package main.java.backend.Controllers;

import backend.Models.RespChatModel;
import backend.Repositories.RespChatRepository;

@CrossOrigin(origins="*")
@RestController
public class RespChatController {
    @Autowired
    RespChatRepository respChatRepository;

    @GetMapping("/respChats")
    public List<RespChat> getAllRespChats(){
        return respChatRepository.findAll();
    }

    @GetMapping("/respChats/{id}")
    public RespChat getRespChat(@PathVariable(value="id") Long id){
        return respChatRepository.findRespChatById(id);
    }

    @PostMapping("/respChats")
    public RespChat createRespChat(@RequestBody RespChat respChat){
        return respChatRepository.save(respChat);
    }

    @DeleteMapping("/respChat/{id}")
    public ResponseEntity<RespChat> deleteRespChat(@PathVariable (value = "id") Long id){
        respChatRepository.delete(respChatRepository.findRespChatById(id));
        return ResponseEntity.ok().build();
    }
}