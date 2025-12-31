package biblioteca_dio_lab.dio.services.servicesImpl;

import biblioteca_dio_lab.dio.model.LivroEntity;
import biblioteca_dio_lab.dio.model.LivroRepository;
import biblioteca_dio_lab.dio.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public Iterable<LivroEntity> buscarLivros() {
        return livroRepository.findAll();
    }

    @Override
    public LivroEntity buscarPorid(Long id) {
        Optional<LivroEntity> livro = livroRepository.findById(id);
        return livro.get();
    }

    @Override
    public void adicionarLivro(LivroEntity livroEntity) {
        livroRepository.save(livroEntity);
    }

    @Override
    public void atualizarLivro(Long id, LivroEntity livroEntity) {
        Optional<LivroEntity> livroExistente = livroRepository.findById(id);
        if (livroExistente.isPresent()) {
            LivroEntity livroParaAtualizar = livroExistente.get();
            livroParaAtualizar.setNome(livroEntity.getNome());
            livroParaAtualizar.setAutor(livroEntity.getAutor());
            livroParaAtualizar.setAnoPublicacao(livroEntity.getAnoPublicacao());
            livroRepository.save(livroParaAtualizar);
        } else {
            ResponseEntity.notFound();
        }
    }

    @Override
    public void apagarLivro(Long id) {
        livroRepository.delete(buscarPorid(id));
    }
}
