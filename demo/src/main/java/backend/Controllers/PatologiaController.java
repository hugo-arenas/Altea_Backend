package main.java.backend.Controllers;

import backend.Models.Patologia;
import backend.Repositories.PatologiaRepository;

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
public class PatologiaController {
    @Autowired
    PatologiaRepository patologiaRepository;

    @GetMapping("/patologias")
    public List<Patologia> getAllPatologias(){
        return patologiaRepository.findAll();
    }

    @GetMapping("/patologias/{id}")
    public Patologia getPatologia(@PathVariable(value="id") Long id){
        return patologiaRepository.findPatologiaById(id);
    }

    @PostMapping("/patologias")
    public Patologia createPatologia(@RequestBody Patologia patologia){
        return patologiaRepository.save(patologia);
    }

    @DeleteMapping("/patologia/{id}")
    public ResponseEntity<Patologia> deletePatologia(@PathVariable (value = "id") Long id){
        patologiaRepository.delete(patologiaRepository.findPatologiaById(id));
        return ResponseEntity.ok().build();
    }
}