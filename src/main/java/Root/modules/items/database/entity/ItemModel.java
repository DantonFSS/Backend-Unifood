package Root.modules.items.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Table(name = "items")
@Entity(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_item", unique = true)
    private UUID id;

    @Column(name = "image_item")
    private String url;

    @Column(nullable = false, name = "name_item")
    private String name;

    @Column(nullable = false, name = "price_item")
    private Double price;

    @Column(nullable = false, name = "description_item")
    private String description;

    @Column(name = "quantity_item")
    private Integer quantity;

    @ManyToMany @JoinTable(
            name = "category_item",  // join table
            joinColumns = @JoinColumn(name = "item_id"),  // fk na tabela de items
            inverseJoinColumns = @JoinColumn(name = "category_id")  // fk na tabala categoria
    )
    private List<Category> category;

    public ItemModel (String name, Double price, String description, String url) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.url = url;
    }

    public ItemModel (String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

}

