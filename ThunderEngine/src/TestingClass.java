import com.MightyChubz.core.*;
import com.MightyChubz.core.gfx.Behavior;
import com.MightyChubz.core.gfx.Color;
import com.MightyChubz.core.gfx.ResourceLoader;
import com.MightyChubz.core.interfaces.MainGameMethods;
import com.MightyChubz.core.mathf.Vector2f;

public class TestingClass extends Behavior implements MainGameMethods {
    GameObject player = new GameObject();
    GameObject colTest = new GameObject();

    CollisionBox boxLeft = new CollisionBox();

    public void load() {
        player.transform.scale = new Vector2f(1, 1);
        player.renderer.initQuadImage(ResourceLoader.LoadImageResource("Spritesheet.png"), 16, 16);
        player.renderer.setTextureFromQuad(0, player.transform.scale, 128);

        colTest.transform.scale = new Vector2f(1, 1);
        colTest.transform.position = new Vector2f(500, 300);
        colTest.renderer.initQuadImage(ResourceLoader.LoadImageResource("Spritesheet.png"), 16, 16);
        colTest.renderer.setTextureFromQuad(0, colTest.transform.scale, 128);

        boxLeft.size.width = player.renderer.renderWidth;
        boxLeft.size.height = player.renderer.renderHeight;
        boxLeft.imageSize.width = player.renderer.width;
        boxLeft.imageSize.height = player.renderer.height;
        boxLeft.initAlignMode();
    }

    public void update() {
        boxLeft.position.x = player.transform.position.x;
        boxLeft.position.y = player.transform.position.y;

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

        boxLeft.multiplier = new Vector2f(3, 2);
        boxLeft.offset = new Vector2f(0, 0);
        colTest.renderer.offset = new Vector2f(colTest.renderer.centerRWidth, 0);
        if (player.trigger.boundingBoxTrigger(boxLeft, colTest))
            colTest.transform.position.x -= 3;

        boxLeft.multiplier = new Vector2f(3, 2);
        boxLeft.offset = new Vector2f(boxLeft.alignMode.x - (boxLeft.imageSize.width * boxLeft.multiplier.x + 15), 0);
        colTest.renderer.offset = new Vector2f(-colTest.renderer.centerRWidth, 0);
        if (player.trigger.boundingBoxTrigger(boxLeft, colTest))
            colTest.transform.position.x += 3;

        boxLeft.multiplier = new Vector2f(3, 1);
        boxLeft.offset = new Vector2f(0, -(boxLeft.imageSize.height + 16));
        colTest.renderer.offset = new Vector2f(0, -colTest.renderer.centerRHeight);
        if (player.trigger.boundingBoxTrigger(boxLeft, colTest))
            colTest.transform.position.y += 3;

        boxLeft.multiplier = new Vector2f(3, 1);
        boxLeft.offset = new Vector2f(0, boxLeft.alignMode.y - (boxLeft.imageSize.height * boxLeft.multiplier.y + 16));
        colTest.renderer.offset = new Vector2f(0, colTest.renderer.centerRHeight);
        if (player.trigger.boundingBoxTrigger(boxLeft, colTest))
            colTest.transform.position.y -= 3;
    }

    public void render() {
        setScreenColor(Color.WHITE);

        player.renderTexture();
        colTest.renderTexture();
    }

    public void windowClose() {
    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
