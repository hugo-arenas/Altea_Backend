package main.java.backend.Controllers;

import backend.Models.RespUsModel;
import backend.Repositories.RespUsRepository;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class RespUsController {
    @Autowired
    RespUsRepository respUsRepository;

    @GetMapping("/respUss")
    public List<RespUs> getAllRespUss(){
        return respUsRepository.findAll();
    }

    @GetMapping("/respUss/{id}")
    public RespUs getRespUs(@PathVariable(value="id") Long id){
        return respUsRepository.findRespUsById(id);
    }

    @PostMapping("/respUss")
    public RespUs createRespUs(@RequestBody RespUs respUs){
        return respUsRepository.save(respUs);
    }

    @DeleteMapping("/respUs/{id}")
    public ResponseEntity<RespUs> deleteRespUs(@PathVariable (value = "id") Long id){
        respUsRepository.delete(respUsRepository.findRespUsById(id));
        return ResponseEntity.ok().build();
    }
}