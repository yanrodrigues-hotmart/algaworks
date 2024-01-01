package course.algafood.implementation;

import course.algafood.model.Restaurante;
import course.algafood.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Restaurante> todos() {
        return entityManager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    @Override
    @Transactional
    public Restaurante adicionar(Restaurante restaurante) {
        return entityManager.merge(restaurante);
    }

    @Override
    @Transactional
    public void remover(Restaurante restaurante) {
        restaurante = porId(restaurante.getId());
        entityManager.remove(restaurante);
    }

    @Override
    public Restaurante porId(Long id) {
        return entityManager.find(Restaurante.class, id);
    }
}
