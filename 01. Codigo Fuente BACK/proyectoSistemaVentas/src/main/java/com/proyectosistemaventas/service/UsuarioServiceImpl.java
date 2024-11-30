package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.UsuarioCreateDTO;
import com.proyectosistemaventas.dtos.UsuarioDTO;
import com.proyectosistemaventas.dtos.UsuarioUpdateDTO;
import com.proyectosistemaventas.mapper.UsuarioMapper;
import com.proyectosistemaventas.model.Usuario;
import com.proyectosistemaventas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return UsuarioMapper.instancia.listaUsuarioAListaUsuarioDTO( usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorID(long id) {
        Optional<Usuario> usuario= usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO =null;
        if(usuario.isPresent()){
            usuarioDTO = UsuarioMapper.instancia.usuarioAUsuarioDTO(usuario.get());
        }
        return  usuarioDTO;
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario=UsuarioMapper.instancia.usuarioCreateDTOAUsuario(usuarioCreateDTO);
        Usuario respuestaEntity=usuarioRepository.save(usuario);
        UsuarioDTO respuestaDTO= UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuario=UsuarioMapper.instancia.usuarioUpdateDTOAUsuario(usuarioUpdateDTO);
        Usuario respuestaEntity=usuarioRepository.save(usuario);
        UsuarioDTO respuestaDTO= UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public UsuarioDTO eliminarUsuario(long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            UsuarioDTO usuarioDTO = UsuarioMapper.instancia.usuarioAUsuarioDTO(usuarioOptional.get());
            usuarioRepository.delete(usuarioOptional.get());
            return usuarioDTO;
        } else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }
}
