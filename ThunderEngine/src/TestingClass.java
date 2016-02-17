import com.MightyChubz.core.Main;
import com.MightyChubz.core.interfaces.MainGameMethods;

public class TestingClass implements MainGameMethods {
    public void load() {

    }

    public void update() {

    }

    public void render() {

    }

    public static void main(String[] args) {
        new Main(new TestingClass()).start();
    }
}
