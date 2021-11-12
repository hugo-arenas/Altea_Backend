package main.java.backend.Controllers;

import backend.Models.Estadistica;
import backend.Repositories.EstadisticaRepository;

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
public class EstadisticaController {
    @Autowired
    EstadisticaRepository estadisticaRepository;

    @GetMapping("/estadisticas")
    public List<Estadistica> getAllEstadisticas(){
        return estadisticaRepository.findAll();
    }

    @GetMapping("/estadisticas/{id}")
    public Estadistica getEstadistica(@PathVariable(value="id") Long id){
        return estadisticaRepository.findEstadisticaById(id);
    }

    @PostMapping("/estadisticas")
    public Estadistica createEstadistica(@RequestBody Estadistica estadistica){
        return estadisticaRepository.save(estadistica);
    }

    @DeleteMapping("/estadistica/{id}")
    public ResponseEntity<Estadistica> deleteEstadistica(@PathVariable (value = "id") Long id){
        estadisticaRepository.delete(estadisticaRepository.findEstadisticaById(id));
        return ResponseEntity.ok().build();
    }
}