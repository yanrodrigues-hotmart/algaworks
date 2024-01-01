package course.algafood.implementation;

import course.algafood.model.Cozinha;
import course.algafood.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Cozinha adicionar(Cozinha cozinha) {
        return entityManager.merge(cozinha);
    }

    @Override
    @Transactional
    public void remover(Cozinha cozinha) {
        cozinha = porId(cozinha.getId());
        entityManager.remove(cozinha);
    }

    @Override
    public List<Cozinha> todas() {
        return entityManager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Override
    public Cozinha porId(Long id) {
        return entityManager.find(Cozinha.class, id);
    }
}
