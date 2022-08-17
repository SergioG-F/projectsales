package pe.com.nttdata.producto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {

    @Id
    @SequenceGenerator(
            name = "producto_id_sequence",
            sequenceName = "producto_id_sequence"
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,

            generator = "producto_id_sequence"
    )
    @Column(name = "producto_id")
    private Integer idProducto;

    @Column(name = "descripcion")
    @NotEmpty(message = "{NotEmpty.producto.descripcion}")
    private String descripcion;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "estado")
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria",nullable = false)
    @NotNull(message = "{NotNull,producto.id_categoria}")
    private CategoriaProducto categoriaProducto;

}
