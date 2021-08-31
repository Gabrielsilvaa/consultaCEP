package com.gabriel.consultaCEP.client;

import com.gabriel.consultaCEP.model.dto.DTOConsultaCepRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface ConsultaCepClient {

    @GetMapping("{cep}/json")
    DTOConsultaCepRequest buscaEnderecoPorCep(@PathVariable("cep") String cep);

}
