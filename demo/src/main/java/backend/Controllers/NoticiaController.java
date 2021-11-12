package main.java.backend.Controllers;

import backend.Models.Noticia;
import backend.Repositories.NoticiaRepository;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class NoticiaController {
    @Autowired
    NoticiaRepository noticiaRepository;

    @GetMapping("/noticias")
    public List<Noticia> getAllNoticias(){
        return noticiaRepository.findAll();
    }

    @GetMapping("/noticias/{id}")
    public Noticia getNoticia(@PathVariable(value="id") Long id){
        return noticiaRepository.findNoticiaById(id);
    }

    @PostMapping("/noticias")
    public Noticia createNoticia(@RequestBody Noticia noticia){
        return noticiaRepository.save(noticia);
    }

    @DeleteMapping("/noticia/{id}")
    public ResponseEntity<Noticia> deleteNoticia(@PathVariable (value = "id") Long id){
        noticiaRepository.delete(noticiaRepository.findNoticiaById(id));
        return ResponseEntity.ok().build();
    }
}