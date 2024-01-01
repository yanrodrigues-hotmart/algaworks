package course.algafood.repository;

import course.algafood.model.Estado;

import java.util.List;

public interface EstadoRepository {

    Estado adicionar(Estado Estado);
    void remover(Estado Estado);
    List<Estado> todas();
    Estado porId(Long id);
    
}
