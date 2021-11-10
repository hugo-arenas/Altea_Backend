package main.java.com.example.demo.Altea.Controllers;

import main.java.Models.UsuarioModel;
import main.java.Repositories.UsuarioRepository;

@CrossOrigin(origins="*")
@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuario(@PathVariable(value="id") Long id){
        return usuarioRepository.findUsuarioById(id);
    }

    @PostMapping("/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable (value = "id") Long id){
        usuarioRepository.delete(usuarioRepository.findUsuarioById(id));
        return ResponseEntity.ok().build();
    }
}