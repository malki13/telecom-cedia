package com.telecom.gestionservice.gateway.service;

import com.telecom.gestionservice.gateway.data.dto.GatewayDTO;
import com.telecom.gestionservice.gateway.data.entity.Gateway;
import com.telecom.gestionservice.gateway.data.info.GatewayInfo;
import com.telecom.gestionservice.gateway.data.read.GatewayRead;
import com.telecom.gestionservice.gateway.mapper.GatewayMapper;
import com.telecom.gestionservice.gateway.repository.GatewayCrudRepository;
//import org.apache.coyote.BadRequestException;
import com.telecom.gestionservice.response.error.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GatewayServiceImpl implements GatewayService{
    @Autowired
    private GatewayCrudRepository gatewayCrudRepository;
    @Autowired
    private GatewayMapper mapper;
    @Override
    public Page<GatewayInfo> findAll(Pageable pageable) {
        return gatewayCrudRepository.findAll(pageable).map(gateway -> mapper.toGatewayInfo(gateway));
    }

    @Override
    public Optional<GatewayRead> getOne(Integer id) {
        Optional<Gateway> gatewayDB = gatewayCrudRepository.findById(id);
        if (gatewayDB.isPresent()) {
//            Empresa empresa = getEmpresa(gatewayDB.get().getIdEmpresa());
//            System.out.println("Se encuentra");
//            System.out.println(empresa.getIden());
//            System.out.println(empresa.getNumGateways());
//            System.out.println(empresa.getNumDevices());
            return gatewayCrudRepository.findById(id).map(gateway -> mapper.toGatewayRead(gateway));
//            return gatewayDB.map(this::getGatewayData);
        }
        throw new BadRequestException("Gateway con id " + id + " no encontrado");
    }

    @Override
    public GatewayRead save(Integer empresaId, GatewayDTO gatewayDTO) {
        Optional<Gateway> gatewayDB = gatewayCrudRepository.findByIdGateway(gatewayDTO.getIdGateway());
        if (!gatewayDB.isPresent()) {
            Integer numGateways = gatewayCrudRepository.countByIdEmpresa(empresaId);
            System.out.println(numGateways);
            if (numGateways < 20) {
                Gateway gateway = mapper.toGateway(gatewayDTO);
                gateway.setIdEmpresa(empresaId);
                return mapper.toGatewayRead(gatewayCrudRepository.save(gateway));
            }
            throw new BadRequestException("Empresa excede los gateways permitidos");
        }
        throw new BadRequestException("Gateway con id " + gatewayDTO.getIdGateway() + " ya esta registrado");
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public GatewayRead update(Integer empresaId, GatewayDTO gatewayDTO, Integer id) {
        return null;
    }
}
