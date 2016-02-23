import com.MightyChubz.core.*;
import com.MightyChubz.core.gfx.Behavior;
import com.MightyChubz.core.gfx.Color;
import com.MightyChubz.core.gfx.ResourceLoader;
import com.MightyChubz.core.interfaces.MainGameMethods;
import com.MightyChubz.core.mathf.Vector2f;

public class TestingClass extends Behavior implements MainGameMethods {
    GameObject player = new GameObject();
    GameObject colTest = new GameObject();

    public void load() {
        player.transform.scale = new Vector2f(1, 1);
        player.renderer.initQuadImage(ResourceLoader.LoadImageResource("Spritesheet.png"), 16, 16);
        player.renderer.setTextureFromQuad(0, player.transform.scale, 128);

//        colTest.transform.scale = new Vector2f(1, 1);
//        colTest.transform.position = new Vector2f(500, 300);
//        colTest.renderer.initQuadImage(ResourceLoader.LoadImageResource("Spritesheet.png"), 16, 16);
//        colTest.renderer.setTextureFromQuad(0, colTest.transform.scale, 128);
    }

    public void update() {
        if (Input.isKeyDown(Input.THUNDER_W))
            player.transform.position.y -= 3;

        if (Input.isKeyDown(Input.THUNDER_S))
            player.transform.position.y += 3;

        if (Input.isKeyDown(Input.THUNDER_A))
            player.transform.position.x -= 3;

        if (Input.isKeyDown(Input.THUNDER_D))
            player.transform.position.x += 3;

//        player.transform.position.x = (float) mouseX - player.renderer.centerRWidth;
//        player.transform.position.y = (float) mouseY - player.renderer.centerRHeight;

//        if (player.trigger.boundingBoxCollisionRight(box, colTest))
//            System.out.println("Collision! 1");
//            colTest.transform.position.x += 3;
//
//        if (player.trigger.boundingBoxCollisionLeft(box, colTest))
//            System.out.println("Collision! 2");
//            colTest.transform.position.x -= 3;
//
//        // This isn't used because collision doesn't as it should.
//        if (player.trigger.boundingBoxCollisionTop(box, colTest))
//            System.out.println("Collision! 3");
//            colTest.transform.position.y += 3;
//
//        if (player.trigger.boundingBoxCollisionBottom(box, colTest))
//            System.out.println("Collision! 4");
//            colTest.transform.position.y -= 3;

        player.trigger.keepWithinScreen(player.transform.position, player.renderer, 3);
    }

    public void render() {
        setScreenColor(Color.WHITE);

        player.renderTexture();
    }

    public void windowClose() {
    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
