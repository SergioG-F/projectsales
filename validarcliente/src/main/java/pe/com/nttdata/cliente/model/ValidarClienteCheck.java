package pe.com.nttdata.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ValidarClienteCheck {
    @Id
    @SequenceGenerator(
            name = "clientecheck_id_sequence",
            sequenceName = "clientecheck_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clientecheck_id_sequence"
    )
    private Integer idValidarClienteCheck;
    private Integer clienteId;
    private Boolean esEstafador;
    private Date fechaCreacion;
}
