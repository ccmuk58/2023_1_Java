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
        if(nextPos.x < 0 || nextPos.y < 0 || nextPos.x >= maze.GetSize() || nextPos.y >= maze.GetSize())
        {
            System.out.println("이동할 수 없는 위치입니다.");
            maze.print();
            return;
        }
        if(maze.GetObject(nextPos).Active())
        {
            if(maze.GetObject(nextPos) instanceof Combat)
            {
                ((Combat) maze.GetObject(nextPos)).Hit(player.GetPower());
                player.Hit(((Combat) maze.GetObject(nextPos)).GetPower());
            }
            maze.SetObject(playerPos, new EmptyObject());
            maze.SetObject(nextPos, player);
            playerPos = nextPos;
        }
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

    public boolean GameClear()
    {
        if(playerPos.x == maze.GetSize()-1 && playerPos.y == maze.GetSize()-1) {
            System.out.println("게임을 클리어 했습니다!");
            return true;
        }
        else
            return false;
    }
    public boolean GameOver()
    {
        if(player.GetHp() <= 0)
        {
            System.out.println("게임 오버 ,,,");
            return true;
        }
        else
            return false;
    }
    public void PrintLine()
    {
        System.out.println("---------");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
