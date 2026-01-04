package biblioteca_dio_lab.dio.services.servicesImpl;

import biblioteca_dio_lab.dio.dto.LivroDTO;
import biblioteca_dio_lab.dio.model.LivroEntity;
import biblioteca_dio_lab.dio.model.LivroRepository;
import biblioteca_dio_lab.dio.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public List<LivroDTO> buscarLivros() {
        return StreamSupport.stream(livroRepository.findAll().spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LivroDTO buscarPorid(Long id) {
        Optional<LivroEntity> livro = livroRepository.findById(id);
        return livro.map(this::convertToDTO).orElse(null);
    }

    @Override
    public void adicionarLivro(LivroDTO livroDTO) {
        LivroEntity livroEntity = convertToEntity(livroDTO);
        livroRepository.save(livroEntity);
    }

    @Override
    public void atualizarLivro(Long id, LivroDTO livroDTO) {
        Optional<LivroEntity> livroExistente = livroRepository.findById(id);
        if (livroExistente.isPresent()) {
            LivroEntity livroParaAtualizar = livroExistente.get();
            livroParaAtualizar.setNome(livroDTO.nome());
            livroParaAtualizar.setAutor(livroDTO.autor());
            livroParaAtualizar.setAnoPublicacao(livroDTO.anoPublicacao());
            livroRepository.save(livroParaAtualizar);
        } else {
            ResponseEntity.notFound();
        }
    }

    @Override
    public void apagarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    private LivroDTO convertToDTO(LivroEntity livroEntity) {
        return new LivroDTO(
                livroEntity.getId(),
                livroEntity.getNome(),
                livroEntity.getAutor(),
                livroEntity.getAnoPublicacao()
        );
    }

    private LivroEntity convertToEntity(LivroDTO livroDTO) {
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setId(livroDTO.id());
        livroEntity.setNome(livroDTO.nome());
        livroEntity.setAutor(livroDTO.autor());
        livroEntity.setAnoPublicacao(livroDTO.anoPublicacao());
        return livroEntity;
    }
}
