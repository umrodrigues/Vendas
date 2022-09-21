package umrodrigues.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umrodrigues.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {



}
