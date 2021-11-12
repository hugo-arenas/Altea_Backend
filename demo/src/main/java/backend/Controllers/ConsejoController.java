package backend.Controllers;

import backend.Models.Consejo;
import backend.Repositories.ConsejoRepository;

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
