package br.com.app.clientes.api;

import br.com.app.clientes.infraestrutura.Cliente;
import br.com.app.clientes.negocio.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteAPI {

    @Autowired
    private ClienteService service;

    @PostMapping("/clientes")
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    @GetMapping("/clientes")
    public List<Cliente> buscar() {
        return service.buscar();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity buscar(@PathVariable("id") Long id) {
        Optional<Cliente> cliente = service.buscar(id);

        return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/clientes/{id}")
    public Cliente editar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        return service.atualizar(id, cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public Boolean deletar(@PathVariable("id") Long id) {
        return service.deletar(id);
    }

}
