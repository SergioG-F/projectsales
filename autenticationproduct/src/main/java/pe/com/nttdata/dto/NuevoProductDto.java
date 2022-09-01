package pe.com.nttdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NuevoProductDto {
    private String productusuario;
    private String password;
    private String rol;
}
