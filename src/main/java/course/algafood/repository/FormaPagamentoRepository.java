package course.algafood.repository;

import course.algafood.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {

    FormaPagamento adicionar(FormaPagamento formaPagamento);

    void remover(FormaPagamento formaPagamento);

    FormaPagamento porId(Long id);

    List<FormaPagamento> todos();

}
