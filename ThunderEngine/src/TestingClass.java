import com.MightyChubz.core.*;
import com.MightyChubz.core.gfx.Behavior;
import com.MightyChubz.core.gfx.Color;
import com.MightyChubz.core.interfaces.MainGameMethods;
import com.MightyChubz.core.mathf.Vector2f;

public class TestingClass extends Behavior implements MainGameMethods {
    GameObject player = new GameObject();
    GameObject colTest = new GameObject();
    Audio audioPlayer = new Audio();

    public void load() {
        player.transform.scale = new Vector2f(1, 1);
        player.renderer.initQuadImage(ResourceLoader.LoadImageResource("Spritesheet.png"), 16, 16);
        player.renderer.setTextureFromQuad(0, player.transform.scale, 128);

        colTest.transform.scale = new Vector2f(1, 1);
        colTest.renderer.initQuadImage(ResourceLoader.LoadImageResource("Spritesheet.png"), 16, 16);
        colTest.renderer.setTextureFromQuad(0, colTest.transform.scale, 128);

//        audioPlayer.initContext();
//        audioPlayer.loadAudioFile(ResourceLoader.LoadResource("/Sad_Dreams.ogg"), true);
//        audioPlayer.play();
    }

    public void update() {
//        if (Input.isKeyDown(Input.THUNDER_W))
//            player.transform.position.y -= 5;
//
//        if (Input.isKeyDown(Input.THUNDER_S))
//            player.transform.position.y += 5;
//
//        if (Input.isKeyDown(Input.THUNDER_A))
//            player.transform.position.x -= 5;
//
//        if (Input.isKeyDown(Input.THUNDER_D))
//            player.transform.position.x += 5;

        player.transform.position.x = (float) deltaMouseX - player.renderer.centerRWidth;
        player.transform.position.y = (float) deltaMouseY - player.renderer.centerRHeight;

        colTest.transform.position = new Vector2f(500, 200);

        if (player.collider.colBoxLeft(player, colTest))
            System.out.println("Collision! 1");

        if (player.collider.colBoxRight(player, colTest))
            System.out.println("Collision! 2");

        if (player.collider.colBoxUp(player, colTest))
            System.out.println("Collision! 3");

        if (player.collider.colBoxDown(player, colTest))
            System.out.println("Collision! 4");


        player.collider.keepWithinScreen(player.transform.position, player.renderer);
    }

    public void render() {
        setScreenColor(Color.WHITE);

//        player.rayCastUp();
//        player.rayCastRight();
//        player.rayCastLeft();
//        player.rayCastDown();

//        if (Mouse.isKeyReleased(Mouse.THUNDER_MOUSE_LEFT)) {
//            player.renderTexture();
//        }

        player.renderTexture();

        colTest.renderTexture();
    }

    public void windowClose() {
//        audioPlayer.close();
    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
