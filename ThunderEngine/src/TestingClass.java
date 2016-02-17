import com.MightyChubz.core.*;
import com.MightyChubz.core.interfaces.MainGameMethods;

import java.awt.image.BufferedImage;

public class TestingClass extends Screen implements MainGameMethods {
    GameObject player = new GameObject();

    public void load() {
        BufferedImage big = ResourceLoader.LoadImageResource("Spritesheet.png");

        player.renderer.initQuadImage(big, 16, 16);
        player.renderer.setTextureFromQuad(0);
    }

    public void update() {
        if (Input.isKeyDown(Input.W))
            player.transform.position.y -= 1;

        if (Input.isKeyDown(Input.S))
            player.transform.position.y += 1;

        if (Input.isKeyDown(Input.A))
            player.transform.position.x -= 1;

        if (Input.isKeyDown(Input.D))
            player.transform.position.x += 1;
    }

    public void render() {
        renderTexture(player.renderer.texture, player.transform.position);
    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
