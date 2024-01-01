package course.algafood.repository;

import course.algafood.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> todos();

    Restaurante adicionar(Restaurante restaurante);

    void remover(Restaurante restaurante);

    Restaurante porId(Long id);
}
