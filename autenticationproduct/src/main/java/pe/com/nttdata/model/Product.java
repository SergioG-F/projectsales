package pe.com.nttdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Product {
    @Id
    @SequenceGenerator(
            name = "productusuario_id_sequence",
            sequenceName = "productusuario_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "productusuario_id_sequence"
    )
    private Integer id;
    private String productusuario;
    private String passwords;
    private String roles;
}
