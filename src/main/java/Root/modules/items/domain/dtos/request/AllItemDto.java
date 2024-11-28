package Root.modules.items.domain.dtos.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AllItemDto {

    @NotNull
    @NotBlank(message = "Name must not be empty or null...")
    private String name;

    @NotNull
    private Double price;

    @NotNull
    @NotBlank(message = "Description must no be empty or null...")
    private String description;

}
