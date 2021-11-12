package main.java.backend.Controllers;

import backend.Models.RespChat;
import backend.Repositories.RespChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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