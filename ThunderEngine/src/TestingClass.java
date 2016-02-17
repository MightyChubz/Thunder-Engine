import com.MightyChubz.core.Main;
import com.MightyChubz.core.ResourceLoader;
import com.MightyChubz.core.Screen;
import com.MightyChubz.core.gfx.QuadImage;
import com.MightyChubz.core.gfx.Texture;
import com.MightyChubz.core.interfaces.MainGameMethods;

import java.awt.image.BufferedImage;
import java.io.File;

public class TestingClass extends Screen implements MainGameMethods {
    int PlayerID;

    public void load() {
        BufferedImage big = ResourceLoader.LoadImageResource("Spritesheet.png");

        QuadImage images = new QuadImage(15, 15, big);
        images.initQuad(16, 16);
        PlayerID = Texture.LoadTexturePNG(images.sprites[0]);
    }

    public void update() {

    }

    public void render() {
        renderTexture(PlayerID, 100, 100);
    }

    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath", new File("native").getAbsolutePath());
        new Main(new TestingClass()).start();
    }
}
