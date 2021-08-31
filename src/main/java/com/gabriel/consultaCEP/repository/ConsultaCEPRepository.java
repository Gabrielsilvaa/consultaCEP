package com.gabriel.consultaCEP.repository;

import com.gabriel.consultaCEP.model.ModelConsultaCEP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaCEPRepository extends JpaRepository<ModelConsultaCEP, Long> {

}
