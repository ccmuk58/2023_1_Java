import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GameManager gm = GameManager.getInstance();

        gm.GetMaze().print();

        while(!gm.GameClear() && !gm.GameOver())
        {
            GameManager.getInstance().Move();
        }

    }
}
