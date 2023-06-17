import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private ArrayList<ArrayList<RoomObject>> maze = new ArrayList<>();

    public Maze() {
        ArrayList<ArrayList<RoomObject>> tempMaze = new ArrayList<>();
        tempMaze.add(new ArrayList<>(Arrays.asList(new Player(), new Enemy_Slime(), new Item_Sword())));
        tempMaze.add(new ArrayList<>(Arrays.asList(new Enemy_Slime(), new Wall(), new Wall())));
        tempMaze.add(new ArrayList<>(Arrays.asList(new EmptyObject(), new Enemy_Slime(), new EmptyObject())));
        maze = tempMaze;
    }

    public void print() {
        for (ArrayList<RoomObject> row : maze) {
            for (RoomObject obj : row) {
                System.out.print(obj.toString());
            }
            System.out.println();
        }
        GameManager.getInstance().PrintLine();
    }

    public RoomObject GetObject(Position pos)
    {
        return maze.get(pos.y).get(pos.x);
    }
    public void SetObject(Position pos, RoomObject room)
    {
        maze.get(pos.y).set(pos.x, room);
    }
    public int GetSize()
    {
        return maze.get(0).size();
    }

}
