package main.java.backend.Controllers;

import backend.Models.EmpresaModel;
import backend.Repositories.EmpresaRepository;

@CrossOrigin(origins="*")
@RestController
public class EmpresaController {
    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping("/empresas")
    public List<Empresa> getAllEmpresas(){
        return empresaRepository.findAll();
    }

    @GetMapping("/empresas/{id}")
    public Empresa getEmpresa(@PathVariable(value="id") Long id){
        return empresaRepository.findEmpresaById(id);
    }

    @PostMapping("/empresas")
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaRepository.save(empresa);
    }

    @DeleteMapping("/empresa/{id}")
    public ResponseEntity<Empresa> deleteEmpresa(@PathVariable (value = "id") Long id){
        empresaRepository.delete(empresaRepository.findEmpresaById(id));
        return ResponseEntity.ok().build();
    }
}