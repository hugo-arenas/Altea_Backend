package main.java.backend.Controllers;

import backend.Models.Sintoma;
import backend.Repositories.SintomaRepository;

import java.util.List;
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
public class SintomaController {
    @Autowired
    SintomaRepository sintomaRepository;

    @GetMapping("/sintomas")
    public List<Sintoma> getAllSintomas(){
        return sintomaRepository.findAll();
    }

    @GetMapping("/sintomas/{id}")
    public Sintoma getSintoma(@PathVariable(value="id") Long id){
        return sintomaRepository.findSintomaById(id);
    }

    @PostMapping("/sintomas")
    public Sintoma createSintoma(@RequestBody Sintoma sintoma){
        return sintomaRepository.save(sintoma);
    }

    @DeleteMapping("/sintoma/{id}")
    public ResponseEntity<Sintoma> deleteSintoma(@PathVariable (value = "id") Long id){
        sintomaRepository.delete(sintomaRepository.findSintomaById(id));
        return ResponseEntity.ok().build();
    }
}