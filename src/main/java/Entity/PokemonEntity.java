package Entity;

import java.util.Map;

public class PokemonEntity {
    private int id;
    private String name;
    private double height;
    private double weight;
    private SpritesEntity sprites;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public SpritesEntity getSprites() {
        return sprites;
    }
}
