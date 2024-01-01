package course.algafood.repository;

import course.algafood.model.FormaPagamento;
import course.algafood.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    Permissao adicionar(Permissao formaPagamento);

    void remover(Permissao formaPagamento);

    Permissao porId(Long id);

    List<Permissao> todos();

}
