import java.util.Scanner;

public class GameManager {

    private static GameManager instance = null;
    private Player player;
    private Position playerPos;
    private Maze maze;

    private GameManager() {
    }

    public void Init()
    {
        this.player = new Player();
        this.playerPos = new Position();
        maze.SetObject(playerPos, player);
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
            PrintLine();
            return;
        }

        IRoomObject nextObj = maze.GetObject(nextPos);
        if(nextObj instanceof Combat)
        {
            ((Combat) nextObj).Hit(player.GetPower());
            player.Hit(((Combat) nextObj).GetPower());
        }
        else if(nextObj instanceof IPowerItem)
        {
            nextObj.PrintInfo();
            player.AddPower(((IPowerItem) nextObj).TakePower());
            player.PrintInfo();

        }
        else if(nextObj instanceof IHpItem)
        {
            nextObj.PrintInfo();
            player.AddHp(((IHpItem) nextObj).TakeHp());
            player.PrintInfo();
        }

        if(nextObj.Active())
        {
            maze.SetObject(playerPos, new Empty());
            maze.SetObject(nextPos, player);
            playerPos = nextPos;
        }
    }
    private Position InputMove() {
        int x = 0, y = 0;
        Scanner scn = new Scanner(System.in);
        switch (scn.next().charAt(0)) {
            case 'a','ㅁ' -> {
                x = -1;
                y = 0;
            }
            case 'd','ㅇ' -> {
                x = 1;
                y = 0;
            }
            case 'w','ㅈ' -> {
                x = 0;
                y = -1;
            }
            case 's','ㄴ' -> {
                x = 0;
                y = 1;
            }
            default -> {
                System.out.println("잘못된 입력입니다.");
            }
        }
        PrintLine();
        return new Position(x, y);
    }

    public boolean GameClear()
    {
        if(playerPos.x == maze.GetSize()-1 && playerPos.y == maze.GetSize()-1) {
            System.out.println("게임을 클리어 했습니다!");
            PrintLine();
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
            PrintLine();
            return true;
        }
        else
            return false;
    }
    public void PrintLine()
    {
        System.out.println("---------");
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void SetMaze(Maze maze)
    {
        this.maze = maze;
    }
}
