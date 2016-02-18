import com.MightyChubz.core.*;
import com.MightyChubz.core.gfx.Color;
import com.MightyChubz.core.interfaces.MainGameMethods;
import com.MightyChubz.core.mathf.Vector2f;

import java.awt.image.BufferedImage;

public class TestingClass extends Screen implements MainGameMethods {
    GameObject player = new GameObject();

    public void load() {
        BufferedImage big = ResourceLoader.LoadImageResource("Spritesheet.png");

        player.transform.scale = new Vector2f(1, 1);
        player.renderer.initQuadImage(big, 16, 16);
        player.renderer.setTextureFromQuad(0, player.transform.scale, 128);
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

        player.collider.rayCastX(player.transform.position, 150, player.renderer.renderWidth / 2, player.renderer.renderHeight / 2);
        renderTexture(player.renderer.texture, player.transform.position, player.renderer.renderWidth, player.renderer.renderHeight);
    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
