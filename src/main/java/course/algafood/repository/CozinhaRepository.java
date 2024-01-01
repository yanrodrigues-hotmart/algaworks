package course.algafood.repository;

import course.algafood.model.Cozinha;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CozinhaRepository {

    Cozinha adicionar(Cozinha cozinha);
    void remover(Cozinha cozinha);
    List<Cozinha> todas();
    Cozinha porId(Long id);
}
