package api.src.main.java.com.wine.api.repository;

import api.src.main.java.com.wine.api.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CepRepository<Long, ID> extends JpaRepository<Cep, ID> {

    @Query(value = "SELECT * FROM wine.cep WHERE ?1 between range_start and range_end and ?1 between range_start and range_end", nativeQuery = true)
    Optional<Cep> findBetweenRangeStartAndRangeEnd(Long rangeStart, Long rangeEnd);
    Cep findByStoreCode(String storeCode);

}