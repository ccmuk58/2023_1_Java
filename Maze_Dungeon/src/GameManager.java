import java.util.Scanner;

public class GameManager {

    private static GameManager instance = null;
    private Player player = new Player();
    private Position playerPos = new Position();
    private Maze maze = new Maze();

    private GameManager() {
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
    public Maze GetMaze()
    {
        return maze;
    }
    public void Move() {
        Position nextPos = Position.Sum(playerPos, InputMove()) ;
        Wall wall = new Wall();
        if(nextPos.x < 0 || nextPos.y < 0 || nextPos.x >= maze.GetSize() || nextPos.y >= maze.GetSize() || maze.GetObject(nextPos) instanceof Wall)
        {
            System.out.println("이동할 수 없는 위치입니다.");
            maze.print();
            return;
        }
        maze.SetObject(playerPos, new EmptyObject());
        playerPos = nextPos;
        maze.GetObject(playerPos).Active();
        maze.SetObject(playerPos, new Player());
        maze.print();
    }
    private Position InputMove() {
        int x = 0, y = 0;
        Scanner scn = new Scanner(System.in);
        switch (scn.next().charAt(0)) {
            case 'a' -> {
                x = -1;
                y = 0;
            }
            case 'd' -> {
                x = 1;
                y = 0;
            }
            case 'w' -> {
                x = 0;
                y = -1;
            }
            case 's' -> {
                x = 0;
                y = 1;
            }
            default -> {
                System.out.println("잘못된 입력입니다.");
            }
        }
        return new Position(x, y);
    }


}
