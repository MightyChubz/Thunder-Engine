import com.MightyChubz.core.*;
import com.MightyChubz.core.gfx.Behavior;
import com.MightyChubz.core.gfx.Color;
import com.MightyChubz.core.interfaces.MainGameMethods;
import com.MightyChubz.core.mathf.Vector2f;

public class TestingClass extends Behavior implements MainGameMethods {
    GameObject player = new GameObject();
    GameObject colTest = new GameObject();
    CollisionBox box = new CollisionBox();

    public void load() {
        player.transform.scale = new Vector2f(1, 1);
        player.renderer.initQuadImage(ResourceLoader.LoadImageResource("Spritesheet.png"), 16, 16);
        player.renderer.setTextureFromQuad(0, player.transform.scale, 128);

        colTest.transform.scale = new Vector2f(1, 1);
        colTest.transform.position = new Vector2f(500, 300);
        colTest.renderer.initQuadImage(ResourceLoader.LoadImageResource("Spritesheet.png"), 16, 16);
        colTest.renderer.setTextureFromQuad(0, colTest.transform.scale, 128);

        box.size.width = player.renderer.renderWidth;
        box.size.height = player.renderer.renderHeight;
        box.imageSize.width = player.renderer.width;
        box.imageSize.height = player.renderer.height;
        box.initAlignMode();
        box.multiplier = 1;
    }

    public void update() {
        box.position.x = player.transform.position.x;
        box.position.y = player.transform.position.y;

        if (Input.isKeyDown(Input.THUNDER_W))
            player.transform.position.y -= 2;

        if (Input.isKeyDown(Input.THUNDER_S))
            player.transform.position.y += 2;

        if (Input.isKeyDown(Input.THUNDER_A))
            player.transform.position.x -= 2;

        if (Input.isKeyDown(Input.THUNDER_D))
            player.transform.position.x += 2;

//        player.transform.position.x = (float) deltaMouseX - player.renderer.centerRWidth;
//        player.transform.position.y = (float) deltaMouseY - player.renderer.centerRHeight;

        if (player.trigger.boundingBoxCollisionRight(box, colTest))
            colTest.transform.position.x += 2;

        if (player.trigger.boundingBoxCollisionLeft(box, colTest))
            colTest.transform.position.x -= 2;

//        if (player.trigger.boundingBoxCollisionTop(box, colTest))
//            System.out.println("Collision! 3");

        player.trigger.keepWithinScreen(player.transform.position, player.renderer);
    }

    public void render() {
        setScreenColor(Color.WHITE);

        colTest.renderTexture();
        player.renderTexture();
    }

    public void windowClose() {
    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
