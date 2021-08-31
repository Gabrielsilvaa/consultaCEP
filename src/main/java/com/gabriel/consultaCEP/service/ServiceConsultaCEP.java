package com.gabriel.consultaCEP.service;

import com.gabriel.consultaCEP.client.ConsultaCepClient;
import com.gabriel.consultaCEP.model.ModelConsultaCEP;
import com.gabriel.consultaCEP.model.dto.DTOConsultaCepRequest;
import com.gabriel.consultaCEP.repository.ConsultaCEPRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceConsultaCEP {

    @Autowired
    private ConsultaCEPRepository repository;

    @Autowired
    private ConsultaCepClient consultaCepClient;

    @Autowired
    private ModelMapper mapper;

    public ModelConsultaCEP savalConsulta(DTOConsultaCepRequest consultaCEP){
        ModelConsultaCEP map = mapper.map(consultaCEP, ModelConsultaCEP.class);
        return repository.save(map);
    }

    public ResponseEntity<DTOConsultaCepRequest> colsultaCep(String cep){
        DTOConsultaCepRequest endereco = consultaCepClient.buscaEnderecoPorCep(cep);
        savalConsulta(endereco);
        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }



}
