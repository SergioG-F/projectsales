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
public class CategoriaProducto {
    @Id
    @SequenceGenerator(
            name = "id_categoria_sequence",
            sequenceName = "id_categoria_sequence"
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,

            generator = "id_categoria_sequence"
    )
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "descripcion")
    @NotEmpty(message = "{NotEmpty.categoria.descripcion}")
    private String descripcion;

    @Column(name = "foto_categoria_producto")
    @NotEmpty  (message = "{NotEmpty.categoria.fotoproducto}")
    private String fotoCategoriaProducto;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

}
