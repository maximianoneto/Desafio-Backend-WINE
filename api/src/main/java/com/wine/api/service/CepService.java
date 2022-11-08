package api.src.main.java.com.wine.api.service;

import api.src.main.java.com.wine.api.model.Cep;
import api.src.main.java.com.wine.api.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CepService {

    @Autowired
    CepRepository cepRepository;

    public ResponseEntity<?> updateCep(Long id, Cep cep) {
        if (cepRepository.findById(id).isPresent()) {
            Optional<Cep> cepOptional = cepRepository.findBetweenRangeStartAndRangeEnd(cep.getRangeStart(), cep.getRangeEnd());
            if (!cepOptional.isPresent()) {
                cepRepository.save(Cep.builder()
                        .id(id)
                        .rangeStart(cep.getRangeStart())
                        .rangeEnd(cep.getRangeEnd())
                        .storeCode(cep.getStoreCode())
                        .build());
                return ResponseEntity.ok(cep);
            }else {
                return ResponseEntity.badRequest().body("Faixa de cep já cadastrada!");
            }
        }else{
            return ResponseEntity.badRequest().body("Cep não encontrado!");
        }
    }

}
