package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.ClienteCreateDTO;
import com.proyectosistemaventas.dtos.ClienteDTO;
import com.proyectosistemaventas.dtos.ClienteUpdateDTO;
import com.proyectosistemaventas.mapper.ClienteMapper;
import com.proyectosistemaventas.model.Cliente;
import com.proyectosistemaventas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

   @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarCliente() {
        return ClienteMapper.instancia.listClienteAListaClienteDTO
                (clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        Optional<Cliente> cliente=clienteRepository.findById(id);
        ClienteDTO clienteDTO= null;
        if (cliente.isPresent()){
            clienteDTO=ClienteMapper.instancia.
                    clienteAClienteDTO(cliente.get());

        }
        return clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente=ClienteMapper.instancia.
                clienteCreateDTOACliente(clienteCreateDTO);
        Cliente respuestEntety= clienteRepository.save(cliente);
        ClienteDTO respuestaDTO=ClienteMapper.
                instancia.clienteAClienteDTO(respuestEntety);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente=ClienteMapper.instancia.
                clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntety=clienteRepository.save(cliente);
        ClienteDTO respuestDTO= ClienteMapper.instancia.
                clienteAClienteDTO(respuestaEntety);
        return respuestDTO;
    }

    @Override
    public ClienteDTO eliminarCliente(long id) {
        Optional<Cliente>clienteOptional=clienteRepository.findById(id);
        if (clienteOptional.isPresent()){
            ClienteDTO clienteDTO=ClienteMapper.instancia.
                    clienteAClienteDTO(clienteOptional.get());
            clienteRepository.delete(clienteOptional.get());
            return clienteDTO;
        }
        else {
            throw new NoSuchElementException("No se pudo realizar la eliminacion para el ID poprocionado");
        }
    }
}
