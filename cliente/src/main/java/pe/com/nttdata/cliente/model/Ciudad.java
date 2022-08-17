package pe.com.nttdata.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ciudad {
    @Id
    @SequenceGenerator(
            name = "id_ciudad_sequence",
            sequenceName ="id_ciudad_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="id_ciudad_sequence"
    )
    @Column(name = "id_ciudad")
    private Integer idCiudad;

    @Column(name = "provincia")
    @NotEmpty(message = "{NotEmpty.ciudad.provincia}")
    private String provincia;

    @Column(name = "departamento")
    @NotEmpty  (message = "{NotEmpty.ciudad.departamento}")
    //@Pattern(regexp="[a-zA-Z]{2,20}", message = "{Pattern.cliente.departamento}")

    private String departamento;

    @Column(name = "fecha_Creacion")
    private LocalDate fecha_Creacion;


}
