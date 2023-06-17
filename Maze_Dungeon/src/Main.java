import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        GameManager.getInstance().GetMaze().print();

        while(true)
        {
            GameManager.getInstance().Move();
        }

    }
}
