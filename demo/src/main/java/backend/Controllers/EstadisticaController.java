package main.java.backend.Controllers;

import backend.Models.EstadisticaModel;
import backend.Repositories.EstadisticaRepository;

import java.util.List;

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