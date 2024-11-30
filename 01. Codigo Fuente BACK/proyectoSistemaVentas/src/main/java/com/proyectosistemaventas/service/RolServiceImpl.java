package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.RolCreateDTO;
import com.proyectosistemaventas.dtos.RolDTO;
import com.proyectosistemaventas.dtos.RolUpdateDTO;
import com.proyectosistemaventas.mapper.RolMapper;
import com.proyectosistemaventas.model.Rol;
import com.proyectosistemaventas.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;
    @Override
    public List<RolDTO> listarRoles() {
        return RolMapper.instancia.listaRolAListaRolDTO( rolRepository.findAll());
    }

    @Override
    public RolDTO obtenerRolPorId(long id) {
        Optional<Rol> rol= rolRepository.findById(id);
        RolDTO rolDTO =null;
        if(rol.isPresent()){
            rolDTO = RolMapper.instancia.rolARolDTO(rol.get());
        }
        return  rolDTO;
    }

    @Override
    public RolDTO registrarRol(RolCreateDTO rolCreateDTO) {
        Rol rol=RolMapper.instancia.rolCreateDTOARol(rolCreateDTO);
        Rol respuestaEntity=rolRepository.save(rol);
        RolDTO respuestaDTO= RolMapper.instancia.rolARolDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public RolDTO actualizarRol(RolUpdateDTO rolUpdateDTO) {
        Rol rol=RolMapper.instancia.rolUpdateDTOARol(rolUpdateDTO);
        Rol respuestaEntity=rolRepository.save(rol);
        RolDTO respuestaDTO= RolMapper.instancia.rolARolDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public RolDTO eliminarRol(long id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        if (rolOptional.isPresent()) {
            RolDTO rolDTO = RolMapper.instancia.rolARolDTO(rolOptional.get());
            rolRepository.delete(rolOptional.get());
            return rolDTO;
        } else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }
}
