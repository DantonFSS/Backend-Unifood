package Root.modules.items.domain.dtos.response;

import lombok.*;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class ItemResponseDto {

    private UUID id;
    private String name;
    private Double price;
    private String description;
    private String url;
}
