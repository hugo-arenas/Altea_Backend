package main.java.backend.Controllers;

import backend.Models.Superusuario;
import backend.Repositories.SuperusuarioRepository;

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
public class SuperusuarioController {
    @Autowired
    SuperusuarioRepository superusuarioRepository;

    @GetMapping("/superusuarios")
    public List<Superusuario> getAllSuperusuarios(){
        return superusuarioRepository.findAll();
    }

    @GetMapping("/superusuarios/{id}")
    public Superusuario getSuperusuario(@PathVariable(value="id") Long id){
        return superusuarioRepository.findSuperusuarioById(id);
    }

    @PostMapping("/superusuarios")
    public Superusuario createSuperusuario(@RequestBody Superusuario superusuario){
        return superusuarioRepository.save(superusuario);
    }

    @DeleteMapping("/superusuario/{id}")
    public ResponseEntity<Superusuario> deleteSuperusuario(@PathVariable (value = "id") Long id){
        superusuarioRepository.delete(superusuarioRepository.findSuperusuarioById(id));
        return ResponseEntity.ok().build();
    }
}