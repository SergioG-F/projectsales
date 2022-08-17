package pe.com.nttdata.producto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {
    @Id
    @SequenceGenerator(
            name = "id_pedido_sequence",
            sequenceName = "id_pedido_sequence"
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,

            generator = "id_pedido_sequence"
    )
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "n_documento")
    private String nDocumento;


    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id",nullable = false)
    @NotNull(message = "{NotNull,pedido_cliente_id}")
    private Cliente cliente;


}
