package api.src.main.java.com.wine.api.controller;

import api.src.main.java.com.wine.api.Exception.CustomException;
import api.src.main.java.com.wine.api.model.Cep;
import api.src.main.java.com.wine.api.repository.CepRepository;
import api.src.main.java.com.wine.api.service.CepService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cep")
@CrossOrigin(origins = "http://localhost:3307")
public class CepController {

    @Autowired
    CepRepository cepRepository;

    @Autowired
    CepService cepService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCeps() {
        return ResponseEntity.ok(cepRepository.findAll());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCep(@RequestBody Cep cep) throws CustomException {
        if (cep.getRangeStart() >= cep.getRangeEnd()) {
            return new ResponseEntity<Object>("Faixa de cep inválida!", HttpStatus.BAD_REQUEST);
        }
        Optional<List<Cep>> listCep = cepRepository.findBetweenRangeStartAndRangeEnd(cep.getRangeStart(), cep.getRangeEnd());

        if (listCep.isPresent()) {
                return new ResponseEntity<Object>("Faixa de cep já cadastrada!", HttpStatus.BAD_REQUEST);
        }
        cepRepository.save(cep.builder()
                .rangeStart(cep.getRangeStart())
                .rangeEnd(cep.getRangeEnd())
                .storeCode(cep.getStoreCode())
                .build());
        return ResponseEntity.ok(cep);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getCepById(@PathVariable Long id) {
        Optional<Cep> cep = cepRepository.findById(id);
        return cep.isPresent() ? ResponseEntity.ok(cep) : ResponseEntity.notFound().build();
    }

    @GetMapping("/getByStoreCode/{storeCode}")
    public ResponseEntity<?> getCepByStoreCode(@PathVariable String storeCode) {
        Cep cep = cepRepository.findByStoreCode(storeCode);
        return cep.getStoreCode() != null ? ResponseEntity.ok(cep) : ResponseEntity.notFound().build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCepById(@PathVariable Long id, @RequestBody Cep cep) {
        try {
            if(cepService.updateCep(id, cep).getStatusCode().is2xxSuccessful()){
                return ResponseEntity.ok(cep);
            }else{
                return ResponseEntity.badRequest().body("Cep ja cadastrado!");
            }
        }catch (Exception e) {
            return new ResponseEntity<Object>("Não foi possível cadastrar este cep!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCepById(@PathVariable Long id) {
     try{
         cepRepository.deleteById(id);
     }catch (Exception e) {
         return new ResponseEntity<Object>("Não foi possível deletar este cep!", HttpStatus.BAD_REQUEST);
     }
        return ResponseEntity.ok().build();
    }

}
