package antoine.cda.cinemacda4.eleve;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CarnetDeNote {
    @Id
    @GeneratedValue
    private Integer id;
    private String appreciation;
    private double moyenne;
}
