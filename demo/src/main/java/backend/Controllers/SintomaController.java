package main.java.backend.Controllers;

import backend.Models.SintomaModel;
import backend.Repositories.SintomaRepository;

import java.util.List;

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