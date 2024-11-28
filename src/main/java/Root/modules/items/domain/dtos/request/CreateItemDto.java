package Root.modules.items.domain.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class CreateItemDto {

    @NotNull
    @NotBlank(message = "Name must not be empty or null...")
    private String name;

    @NotNull
    private Double price;

    @NotNull
    @NotBlank(message = "Description must no be empty or null...")
    private String description;

    private String url;


}
