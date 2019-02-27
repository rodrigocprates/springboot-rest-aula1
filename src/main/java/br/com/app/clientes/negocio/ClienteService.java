package br.com.app.clientes.negocio;

import br.com.app.clientes.infraestrutura.Cliente;
import br.com.app.clientes.infraestrutura.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {

        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> buscar() {
        List<Cliente> clientes = new ArrayList<>();
        repository.findAll().forEach(c -> clientes.add(c));
        return clientes;
    }

    public Optional<Cliente> buscar(Long id) {
        return repository.findById(id);
    }

    public Boolean deletar(Long id) {
        repository.deleteById(id);
        return Boolean.TRUE;
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        cliente.setId(id);
        return repository.save(cliente);
    }

}
