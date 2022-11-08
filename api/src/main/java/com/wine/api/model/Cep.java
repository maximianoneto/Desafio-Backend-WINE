package api.src.main.java.com.wine.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cep")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cep {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "store_code")
    private String storeCode;

    @Column(name = "range_start")
    private Long rangeStart;

    @Column(name = "range_end")
    private Long rangeEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
