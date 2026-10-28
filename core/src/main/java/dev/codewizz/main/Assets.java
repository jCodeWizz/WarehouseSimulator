package dev.codewizz.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;

public class Assets {

    private static HashMap<String, Texture> textures = new HashMap<>();

    public static void load() {

        TextureAtlas atlas = new TextureAtlas("packs/textures.atlas");

        for (TextureAtlas.AtlasRegion t : atlas.getRegions()) {
            textures.put(t.name, t.getTexture());
        }

    }

    public static Texture getTexture(String name) {
        if (textures.containsKey(name)) {
            return textures.get(name);
        }

        System.err.println("Error trying to get texture: " + name);

        return null;
    }
}
