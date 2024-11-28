package Root.modules.items.domain.dtos.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateItemResponseDto {

    private String name;
    private Double price;
    private String description;
    private String url;
}
