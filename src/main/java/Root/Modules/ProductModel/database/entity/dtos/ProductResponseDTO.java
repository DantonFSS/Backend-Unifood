package Root.Modules.ProductModel.database.entity.dtos;

import Root.Modules.ProductModel.database.entity.ProductModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String name, Double price) {
    public ProductResponseDTO(ProductModel product) {
        this(product.getId(), product.getName(), product.getPrice());
    }
}


