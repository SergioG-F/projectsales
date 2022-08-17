package pe.com.nttdata.producto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetallePedido {
    @Id
    @SequenceGenerator(
            name = "id_detalle_pedido_sequence",
            sequenceName = "id_detalle_pedido_sequence"
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,

            generator = "id_detalle_pedido_sequence"
    )
    @Column(name = "id_detalle_pedido")
    private Integer idDetallePedido;



    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "total")
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "id_pedido",nullable = false)
    @NotNull(message = "{NotNull,detallepedido_id_pedido}")
    private Pedido pedido;


    @ManyToOne
    @JoinColumn(name = "producto_id",nullable = false)
    @NotNull(message = "{NotNull,detallepedido_producto_id}")
    private Producto producto;



}
