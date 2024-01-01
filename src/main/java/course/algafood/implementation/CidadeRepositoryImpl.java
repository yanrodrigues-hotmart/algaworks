package course.algafood.implementation;

import course.algafood.model.Cidade;
import course.algafood.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class CidadeRepositoryImpl implements CidadeRepository {
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Cidade adicionar(Cidade cidade) {
        return entityManager.merge(cidade);
    }

    @Override
    public void remover(Cidade cidade) {
        cidade = porId(cidade.getId());
        entityManager.remove(cidade);
    }

    @Override
    @Transactional
    public List<Cidade> todas() {
        return entityManager.createQuery("from Cidade", Cidade.class).getResultList();
    }

    @Override
    @Transactional
    public Cidade porId(Long id) {
        return entityManager.find(Cidade.class, id);
    }
}
