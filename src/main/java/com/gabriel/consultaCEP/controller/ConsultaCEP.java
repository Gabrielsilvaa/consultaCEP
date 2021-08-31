package com.gabriel.consultaCEP.controller;

import com.gabriel.consultaCEP.model.ModelConsultaCEP;
import com.gabriel.consultaCEP.model.dto.DTOConsultaCepRequest;
import com.gabriel.consultaCEP.repository.ConsultaCEPRepository;
import com.gabriel.consultaCEP.service.ServiceConsultaCEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cep")
public class ConsultaCEP {


    @Autowired
    private ServiceConsultaCEP service;

    @Autowired
    private ConsultaCEPRepository repository;

    @GetMapping("/{cep}")
    public ResponseEntity<DTOConsultaCepRequest> getCep(@PathVariable String cep) {
          return service.colsultaCep(cep);
    }

    @GetMapping("/consultas")
    public List<ModelConsultaCEP> listCep(){
        return repository.findAll();
    }

}
