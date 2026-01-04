package biblioteca_dio_lab.dio.controller;

import biblioteca_dio_lab.dio.dto.LivroDTO;
import biblioteca_dio_lab.dio.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping("/buscarTodosLivros")
    public ResponseEntity<List<LivroDTO>> buscarLivros(){
        return ResponseEntity.ok(livroService.buscarLivros());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<LivroDTO> buscarPorid(@PathVariable Long id){
        return ResponseEntity.ok(livroService.buscarPorid(id));
    }

    @PostMapping("/criar")
    public ResponseEntity<LivroDTO> adicionarLivro(@RequestBody LivroDTO livroDTO){
        livroService.adicionarLivro(livroDTO);
        return ResponseEntity.ok(livroDTO);
    }

    @PutMapping("/editarLivro/{id}")
    public ResponseEntity<LivroDTO> editarLivro(@PathVariable Long id, @RequestBody LivroDTO livroDTO){
        livroService.atualizarLivro(id, livroDTO);
        return ResponseEntity.ok(livroDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        livroService.apagarLivro(id);
        return ResponseEntity.ok().build();
    }

}
