package backend.Controllers;

import backend.Models.Consejo;
import backend.Repositories.ConsejoRepository;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class ConsejoController {
    @Autowired
    ConsejoRepository consejoRepository;

    @GetMapping("/consejos")
    public List<Consejo> getAllConsejos(){
        return consejoRepository.findAll();
    }

    @GetMapping("/consejos/{id}")
    public Consejo getConsejo(@PathVariable(value="id") Long id){
        return consejoRepository.findConsejoById(id);
    }

    @PostMapping("/consejos")
    public Consejo createConsejo(@RequestBody Consejo consejo){
        return consejoRepository.save(consejo);
    }

    @DeleteMapping("/consejo/{id}")
    public ResponseEntity<Consejo> deleteConsejo(@PathVariable (value = "id") Long id){
        consejoRepository.delete(consejoRepository.findConsejoById(id));
        return ResponseEntity.ok().build();
    }
}
