package main.java.backend.Controllers;

import backend.Models.Noticia;
import backend.Repositories.NoticiaRepository;

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