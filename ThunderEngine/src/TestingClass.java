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
        if (Input.isKeyDown(Input.W))
            player.transform.position.y -= 5;

        if (Input.isKeyDown(Input.S))
            player.transform.position.y += 5;

        if (Input.isKeyDown(Input.A))
            player.transform.position.x -= 5;

        if (Input.isKeyDown(Input.D))
            player.transform.position.x += 5;

        if (player.transform.position.x < 0)
            player.transform.position.x += 5;

        if (player.transform.position.y < 0)
            player.transform.position.y += 5;

        if (player.transform.position.x + player.renderer.width > Screen.width)
            player.transform.position.x -= 5;

        if (player.transform.position.y + player.renderer.height > Screen.height)
            player.transform.position.y -= 5;
    }

    public void render() {
        setScreenColor(Color.WHITE);

        renderTexture(player.renderer.texture, player.transform.position);
    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
