package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.TipoDocumentoCreateDTO;
import com.proyectosistemaventas.dtos.TipoDocumentoDTO;
import com.proyectosistemaventas.dtos.TipoDocumentoUpdateDTO;
import com.proyectosistemaventas.mapper.TipoDocumentoMapper;
import com.proyectosistemaventas.model.TipoDocumento;
import com.proyectosistemaventas.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Override
    public List<TipoDocumentoDTO> listarTipoDocumentos() {
        return TipoDocumentoMapper.instancia.listaTipoDocumentoAListaTipoDocumentoDTO(tipoDocumentoRepository.findAll());
    }

    @Override
    public TipoDocumentoDTO obtenerTipoDocumentoPorID(long id) {
        Optional<TipoDocumento> tipoDocumento= tipoDocumentoRepository.findById(id);
        TipoDocumentoDTO tipoDocumentoDTO =null;
        if(tipoDocumento.isPresent()){
            tipoDocumentoDTO = TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(tipoDocumento.get());
        }
        return  tipoDocumentoDTO;
    }

    @Override
    public TipoDocumentoDTO registrarTipoDocumento(TipoDocumentoCreateDTO tipoDocumentoCreateDTO) {
        TipoDocumento tipoDocumento = TipoDocumentoMapper.instancia.tipoDocumentoCreateDTOATipoDocumento(tipoDocumentoCreateDTO);
        TipoDocumento respuestaEntity= tipoDocumentoRepository.save(tipoDocumento);
        TipoDocumentoDTO respuestaDTO = TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public TipoDocumentoDTO actualizarTipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO) {
        TipoDocumento tipoDocumento = TipoDocumentoMapper.instancia.tipoDocumentoUpdateDTOATipoDocumento(tipoDocumentoUpdateDTO);
        TipoDocumento respuestaEntity= tipoDocumentoRepository.save(tipoDocumento);
        TipoDocumentoDTO respuestaDTO = TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public TipoDocumentoDTO eliminarTipoDocumento(long id) {
        Optional<TipoDocumento> tipoDocumentoOptional = tipoDocumentoRepository.findById(id);
        if (tipoDocumentoOptional.isPresent()) {
            TipoDocumentoDTO colorDTO = TipoDocumentoMapper.instancia.tipoDocumentoATipoDocumentoDTO(tipoDocumentoOptional.get());
            tipoDocumentoRepository.delete(tipoDocumentoOptional.get());
            return colorDTO;
        } else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }
}
