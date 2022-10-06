package umrodrigues.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umrodrigues.clientes.model.entity.ClientesService;

public interface ServicoRepository extends JpaRepository<ClientesService, Integer> {
}
