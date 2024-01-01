package course.algafood.implementation;

import course.algafood.model.Estado;
import course.algafood.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Estado adicionar(Estado estado) {
        return entityManager.merge(estado);
    }

    @Override
    @Transactional
    public void remover(Estado estado) {
        estado = porId(estado.getId());
        entityManager.remove(estado);
    }

    @Override
    public List<Estado> todas() {
        return entityManager.createQuery("from Estado", Estado.class).getResultList();
    }

    @Override
    public Estado porId(Long id) {
        return entityManager.find(Estado.class, id);
    }
}
