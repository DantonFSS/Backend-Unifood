package Root.modules.ItemModel.database.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_category")
    private UUID id;

    @Column(name = "name_category")
    private String name;

}
