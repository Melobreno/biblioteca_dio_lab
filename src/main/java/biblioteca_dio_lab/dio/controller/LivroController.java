package biblioteca_dio_lab.dio.controller;

import biblioteca_dio_lab.dio.model.LivroEntity;
import biblioteca_dio_lab.dio.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/biblioteca")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping("/buscarTodosLivros")
    public ResponseEntity<Iterable<LivroEntity>> buscarLivros(){
        return ResponseEntity.ok(livroService.buscarLivros());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<LivroEntity> buscarPorid(@PathVariable Long id){
        return ResponseEntity.ok(livroService.buscarPorid(id));
    }

    @PostMapping("/criar")
    public ResponseEntity<LivroEntity> adicionarLivro(@RequestBody LivroEntity livroEntity){
        livroService.adicionarLivro(livroEntity);
        return ResponseEntity.ok(livroEntity);
    }

    @PutMapping("/editarLivro/{id}")
    public ResponseEntity<LivroEntity> editarLivro(@PathVariable Long id, @RequestBody LivroEntity livroEntity){
        livroService.atualizarLivro(id, livroEntity);
        return ResponseEntity.ok(livroEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        livroService.apagarLivro(id);
        return ResponseEntity.ok().build();
    }

}
