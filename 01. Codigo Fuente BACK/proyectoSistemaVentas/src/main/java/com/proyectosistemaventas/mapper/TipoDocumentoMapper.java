package com.proyectosistemaventas.mapper;

import com.proyectosistemaventas.dtos.TipoDocumentoCreateDTO;
import com.proyectosistemaventas.dtos.TipoDocumentoDTO;
import com.proyectosistemaventas.dtos.TipoDocumentoUpdateDTO;
import com.proyectosistemaventas.model.TipoDocumento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoDocumentoMapper {

    TipoDocumentoMapper instancia = Mappers.getMapper(TipoDocumentoMapper.class);

    TipoDocumentoDTO tipoDocumentoATipoDocumentoDTO(TipoDocumento tipoDocumento);
    TipoDocumento tipoDocumentoDTOATipoDocumento(TipoDocumentoDTO tipoDocumentoDTO);
    TipoDocumento  tipoDocumentoCreateDTOATipoDocumento(TipoDocumentoCreateDTO tipoDocumentoCreateDTO);
    TipoDocumento tipoDocumentoUpdateDTOATipoDocumento(TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO);
    List<TipoDocumentoDTO> listaTipoDocumentoAListaTipoDocumentoDTO (List<TipoDocumento> listaTipoDocumento);


}
