package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.ClienteCreateDTO;
import com.proyectosistemaventas.dtos.ClienteDTO;
import com.proyectosistemaventas.dtos.ClienteUpdateDTO;
import com.proyectosistemaventas.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {

    ClienteMapper instancia= Mappers.getMapper(ClienteMapper.class);
    ClienteDTO clienteAClienteDTO(Cliente cliente);

    Cliente clienteDTOACliente(ClienteDTO clienteDTO);
    Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO);
    Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO);
    List<ClienteDTO>listClienteAListaClienteDTO(List<Cliente>listaCliente);

}
