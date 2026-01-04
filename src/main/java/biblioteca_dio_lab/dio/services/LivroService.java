package biblioteca_dio_lab.dio.services;

import biblioteca_dio_lab.dio.dto.LivroDTO;

import java.util.List;

public interface LivroService {
    List<LivroDTO> buscarLivros();
    LivroDTO buscarPorid(Long id);
    void adicionarLivro(LivroDTO livroDTO);
    void atualizarLivro(Long id, LivroDTO livroDTO);
    void apagarLivro(Long id);
}
