package pe.com.nttdata.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import pe.com.nttdata.dto.RequestProductDto;

import java.util.List;
import java.util.regex.Pattern;

@Component
@ConfigurationProperties(prefix = "admin-paths")
public class RouteValidator {
    private List<RequestProductDto> paths;

    public List<RequestProductDto> getPaths() {
        return paths;
    }

    public void setPaths(List<RequestProductDto> paths) {
        this.paths = paths;
    }

    public boolean isAdminPath(RequestProductDto dtoproduct) {
        return paths.stream().anyMatch(p ->
                Pattern.matches(p.getUri(), dtoproduct.getUri()) && p.getMethod().equals(dtoproduct.getMethod()));
    }
}
