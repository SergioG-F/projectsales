package pe.com.nttdata.kafkaproduct.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class NotificacionProducto {
    @Id
    @SequenceGenerator(
            name = "notificacionproducto_id_sequence",
            sequenceName = "notificacionproducto_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notificacion_id_sequence"
    )
    private Integer notificacionId;
    private Integer productoId;
    private String productoEmail;
    private String remitente;
    private String mensaje;
    private Date horaEnvio;

}
