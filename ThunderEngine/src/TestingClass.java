import com.MightyChubz.core.*;
import com.MightyChubz.core.gfx.Color;
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
        if (Input.isKeyDown(Input.THUNDER_W))
            player.transform.position.y -= 5;

        if (Input.isKeyDown(Input.THUNDER_S))
            player.transform.position.y += 5;

        if (Input.isKeyDown(Input.THUNDER_A))
            player.transform.position.x -= 5;

        if (Input.isKeyDown(Input.THUNDER_D))
            player.transform.position.x += 5;

        player.collider.keepWithinScreen(player.transform.position, player.renderer);
    }

    public void render() {
        setScreenColor(Color.WHITE);

        renderTexture(player.renderer.texture, player.transform.position, player.transform.scale);
    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
