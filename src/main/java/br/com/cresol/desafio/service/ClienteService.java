package br.com.cresol.desafio.service;

import br.com.cresol.desafio.exception.GenericException;
import br.com.cresol.desafio.repository.ClienteRepository;
import br.com.cresol.desafio.dto.ClientePayload;
import br.com.cresol.desafio.model.Cliente;
import br.com.cresol.desafio.model.ClienteMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;
    @Inject
    Validator validator;


    public List<Cliente> listAll() {
        return clienteRepository.listAll();
    }

    public Cliente getClienteById(Long id){
        Optional<Cliente> optional = clienteRepository.findByIdOptional(id);
        return optional.orElseThrow(() -> new GenericException("Usuário inexistente"));
    }
    public Cliente getClienteByCpf(String cpf){
        Optional<Cliente> optional = clienteRepository.findByCpfOptional(cpf);
        return optional.orElseThrow(() -> new GenericException("Usuário inexistente"));
    }

    @Transactional
    public void deleteCliente(Long id){
        if(! clienteRepository.deleteById(id)){
            throw new GenericException("Usuário inexistente");
        }
    }

    @Transactional
    public Cliente persistCliente(ClientePayload payload) throws GenericException {
       return persistCliente(payload, null);
    }
    @Transactional
    public Cliente persistCliente(ClientePayload payload, Long id) {
        Set<ConstraintViolation<ClientePayload>> validacoes = validator.validate(payload);
        List<String> errorMsgs = validacoes.stream().map(cv -> cv.getMessage()).collect(Collectors.toList());

        if(id == null && clienteRepository.isCpfUsado(payload.getCpf())){
            errorMsgs.add("Já existe um usuário cadastrado com esse CPF");
        }

        if(errorMsgs.size() > 0){
            throw new GenericException(errorMsgs.toString());
        }

        Cliente c;
        if(id != null){
            c = clienteRepository.findById(id);
            c.setNome(payload.getNome());
            c.setCpf(payload.getCpf());
            c.setEmail(payload.getEmail());
        }else{
            c = ClienteMapper.convertToModel(payload);
        }

        clienteRepository.persist(c);
        return c;
    }

    public Cliente persistSeNaoExiste(ClientePayload payload){
        try{
            return this.getClienteByCpf(payload.getCpf());
        }catch (GenericException e){
            return persistCliente(payload);
        }
    }

}
