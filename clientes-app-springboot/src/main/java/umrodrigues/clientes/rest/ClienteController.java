package umrodrigues.clientes.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import umrodrigues.clientes.model.entity.Cliente;
import umrodrigues.clientes.repository.ClienteRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private ClienteRepository repository;

    @Autowired

    public ClienteController(ClienteRepository repository) {

        this.repository = repository;
    }


    //Cadastra um cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
   public Cliente salvar(@RequestBody @Valid Cliente cliente){

        return repository.save(cliente);
   }

    //Consulta cliente

    @GetMapping("{id}")
   public Cliente localizarPorId( @PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
   }

    //Deleta cliente

    @DeleteMapping("{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){

       repository
               .findById(id)
               .map(cliente -> {
                   repository.delete(cliente);
                   return Void.TYPE;
               })
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    //Atualiza cliente

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id , @RequestBody @Valid Cliente clienteatualizado){
        repository
                .findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteatualizado.getNome());
                    cliente.setCpf(clienteatualizado.getCpf());
                    return repository.save(clienteatualizado);

                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

}
