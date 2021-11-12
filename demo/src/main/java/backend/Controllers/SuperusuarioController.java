package main.java.backend.Controllers;

import backend.Models.Superusuario;
import backend.Repositories.SuperusuarioRepository;

import java.util.List;

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