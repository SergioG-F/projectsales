package pe.com.nttdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ValidarProductoCheck {
    @Id
    @SequenceGenerator(
            name = "productocheck_id_sequence",
            sequenceName = "productocheck_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "productocheck_id_sequence"
    )
    private Integer idValidarProductoCheck;
    private Integer productoId;
    private Boolean esEstafador;
    private Date fechaCreacion;
}
