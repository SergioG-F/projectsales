package pe.com.nttdata.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

/*
        @Id
    @SequenceGenerator(
            name = "cliente_id_sequence",
            sequenceName = "cliente_id_sequence"
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,

            generator = "cliente_id_sequence"
    )
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer idCliente;

    @Column(name = "cliente_ruc")
    @NotEmpty(message = "{NotEmpty.cliente.ruc}")
    private String ruc;

    @Column(name = "cliente_email")
    @NotEmpty  (message = "{NotEmpty.cliente.email}")
    @Email(message = "{Email.cliente.email}")
    private String email;

    @Column(name = "cliente_razonsocial")
    @NotEmpty(message = "{NotEmpty.cliente.razonsocial}")

    private String razonSocial;

    @Column(name = "cliente_direccion")
    @NotEmpty(message = "{NotEmpty.cliente.direccion}")
    private String direccion;

    @Column(name = "cliente_telefono")
    @NotEmpty(message = "{NotEmpty.cliente.telefono}")
    private String telefono;

    @Column(name = "cliente_nombres")
    @NotEmpty  (message = "{NotEmpty.cliente.nombres}")
    @Pattern(regexp="[a-zA-Z]{2,20}", message = "{Pattern.cliente.nombres}")
    private String nombres;

    @Column(name = "cliente_apellidos")
    @NotEmpty (message = "{NotEmpty.cliente.apellidos}")
    @Pattern(regexp="[a-zA-Z]{2,20}", message = "{Pattern.cliente.apellidos}")
    private String apellidos;

    @Column(name = "cliente_descuento")
    private Integer descuento;

    @Column(name = "cliente_fecha_creacion")
      private LocalDate fechaCreacion;

    @Column(name = "cliente_estado")
    //@NotEmpty(message = "{NotEmpty.cliente.estado}")
    private Integer estado;
    @ManyToOne
    @JoinColumn(name = "id_ciudad",nullable = false)
    //@Column(name = "cliente_idciudad")
    @NotNull(message = "{NotNull,cliente.ciudad}")
    //private Integer idCiudad;
    private Ciudad ciudad;
}
