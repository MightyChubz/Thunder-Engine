import com.MightyChubz.core.*;
import com.MightyChubz.core.gfx.Behavior;
import com.MightyChubz.core.gfx.Color;
import com.MightyChubz.core.interfaces.MainGameMethods;
import com.MightyChubz.core.mathf.Vector2f;

public class TestingClass extends Behavior implements MainGameMethods {
    GameObject player = new GameObject();

    public void load() {
        player.transform.scale = new Vector2f(1, 1);
        player.renderer.initQuadImage(ResourceLoader.LoadImageResource("Spritesheet.png"), 16, 16);
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

        SpriteRenderer render = (SpriteRenderer) player.GetComponent("SpriteRenderer");
        player.rayCastUp();
        player.rayCastRight();
        player.rayCastLeft();
        player.rayCastDown();
        player.renderTexture();
    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
