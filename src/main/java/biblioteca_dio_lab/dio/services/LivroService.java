package biblioteca_dio_lab.dio.services;

import biblioteca_dio_lab.dio.model.LivroEntity;

public interface LivroService {
    Iterable<LivroEntity> buscarLivros();
    LivroEntity buscarPorid(Long id);
    void adicionarLivro(LivroEntity livroEntity);
    void atualizarLivro(Long id, LivroEntity livroEntity);
    void apagarLivro(Long id);
}
