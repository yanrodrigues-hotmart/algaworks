package course.algafood.implementation;

import course.algafood.model.Permissao;
import course.algafood.repository.PermissaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Permissao adicionar(Permissao permissao) {
        return entityManager.merge(permissao);
    }

    @Override
    @Transactional
    public void remover(Permissao permissao) {
        permissao = porId(permissao.getId());
        entityManager.remove(permissao);
    }

    @Override
    public Permissao porId(Long id) {
        return entityManager.find(Permissao.class, id);
    }

    @Override
    public List<Permissao> todos() {
        return entityManager.createQuery("from Permissao", Permissao.class).getResultList();
    }
}
