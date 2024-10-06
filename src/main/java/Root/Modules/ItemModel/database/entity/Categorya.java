package Root.modules.ItemModel.database.entity;

import lombok.Getter;

@Getter
public enum Categorya {

    BEVERAGE("Bebidas"),
    JUNK_FOOD("Lanches Pesados"),
    LAUNCH("Refeições"),
    TREATS("Guloseimas"),
    SNACKS("Lanches"),
    SWEETS("Doces");

    private String category;

    Categorya(String category) {

    }
}
