package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.ClienteCreateDTO;
import com.proyectosistemaventas.dtos.ClienteDTO;
import com.proyectosistemaventas.dtos.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> listarCliente();
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
    ClienteDTO eliminarCliente(long id);

}
