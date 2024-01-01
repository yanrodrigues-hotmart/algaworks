package course.algafood.implementation;

import course.algafood.model.FormaPagamento;
import course.algafood.repository.FormaPagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class FormaDePagamentoImpl implements FormaPagamentoRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public FormaPagamento adicionar(FormaPagamento formaPagamento) {
        return entityManager.merge(formaPagamento);
    }

    @Override
    @Transactional
    public void remover(FormaPagamento formaPagamento) {
        formaPagamento = porId(formaPagamento.getId());
        entityManager.remove(formaPagamento);
    }

    @Override
    public FormaPagamento porId(Long id) {
        return entityManager.find(FormaPagamento.class, id);
    }

    @Override
    public List<FormaPagamento> todos() {
        return entityManager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }
}
