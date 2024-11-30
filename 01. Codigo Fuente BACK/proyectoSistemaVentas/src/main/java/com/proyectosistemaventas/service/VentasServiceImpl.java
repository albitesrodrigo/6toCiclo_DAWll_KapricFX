package com.proyectosistemaventas.service;

import com.proyectosistemaventas.dtos.DetalleVentaCreateDTO;
import com.proyectosistemaventas.dtos.VentasCreateDTO;
import com.proyectosistemaventas.dtos.VentasDTO;
import com.proyectosistemaventas.mapper.DetalleVentaMapper;
import com.proyectosistemaventas.mapper.VentasMapper;
import com.proyectosistemaventas.model.DetalleVenta;
import com.proyectosistemaventas.model.Ventas;
import com.proyectosistemaventas.repository.DetalleVentaRepository;
import com.proyectosistemaventas.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<VentasDTO> listarVentas() {
        List<VentasDTO> lista= VentasMapper.instancia.listaVentasAVentasDTO(ventasRepository.findAll());
        return lista;
    }

    @Override
    public VentasDTO obtenerVentasPorID(long id) {
        Optional<Ventas> ventas=ventasRepository.findById(id);
        VentasDTO ventasDTO=null;
        if (ventas.isPresent()){
            ventasDTO= VentasMapper.instancia.ventasAVentasDTO(ventas.get());
        }
        return ventasDTO;
    }

    @Override
    @Transactional
    public VentasDTO registrarVentas(VentasCreateDTO ventasCreateDTO) {
        Ventas ventas= VentasMapper.instancia.ventasCreateDTOAVentas(ventasCreateDTO);
        Ventas respuestaEntity=ventasRepository.save(ventas);
        for (DetalleVentaCreateDTO detalleVentaCreateDTO: ventasCreateDTO.getDetalleVentaCreateDTO()){
            DetalleVenta detalleVenta=DetalleVentaMapper.instancia.detalleVentaCreateDTOADetalleVenta(detalleVentaCreateDTO);
            detalleVenta.setVenta(respuestaEntity);
            detalleVentaRepository.save(detalleVenta);
        }

        VentasDTO respuestaDTO = VentasMapper.instancia.ventasAVentasDTO(  ventasRepository.findById( respuestaEntity.getIdVenta() ).orElse(null) );
        return respuestaDTO;
    }
}
