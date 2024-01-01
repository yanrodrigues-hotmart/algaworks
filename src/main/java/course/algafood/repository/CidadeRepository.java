package course.algafood.repository;

import course.algafood.model.Cidade;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CidadeRepository {

    Cidade adicionar(Cidade cidade);
    void remover(Cidade cidade);
    List<Cidade> todas();
    Cidade porId(Long id);
}
