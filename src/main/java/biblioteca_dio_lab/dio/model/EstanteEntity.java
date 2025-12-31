package biblioteca_dio_lab.dio.model;

import jakarta.persistence.*;


@Entity
public class EstanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int qntLivros;
    @ManyToOne
    private LivroEntity livroEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQntLivros() {
        return qntLivros;
    }

    public void setQntLivros(int qntLivros) {
        this.qntLivros = qntLivros;
    }

    public LivroEntity getLivroEntity() {
        return livroEntity;
    }

    public void setLivroEntity(LivroEntity livroEntity) {
        this.livroEntity = livroEntity;
    }
}
