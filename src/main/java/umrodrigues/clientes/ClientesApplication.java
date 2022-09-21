package umrodrigues.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import umrodrigues.clientes.model.entity.Cliente;
import umrodrigues.clientes.repository.ClienteRepository;


@SpringBootApplication

	public class ClientesApplication{

	public static void main(String[] args) {

		SpringApplication.run(ClientesApplication.class, args);
	}



}
