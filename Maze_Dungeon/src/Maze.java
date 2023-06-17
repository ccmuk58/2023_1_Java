import java.util.ArrayList;
import java.util.Arrays;

public class Maze implements Cloneable{

    private ArrayList<ArrayList<IRoomObject>> maze = new ArrayList<>();

    private String mazeName;
    private int size;

    public Maze(String mazeName, String sizeStr, String names) {
        this.mazeName = mazeName;
        this.size = Integer.parseInt(sizeStr);
        ConvertNamesToMaze(names);
    }
    public Maze(Maze origin)
    {
         maze = origin.maze;
         mazeName = origin.mazeName;
         size = origin.size;
    }
    private void ConvertNamesToMaze(String namesStr) {
        String[] names = namesStr.split(" ");
        for(int i=0; i<size; i++)
        {
            ArrayList<IRoomObject> tempMaze = new ArrayList<>();
            for(int j=0; j<size; j++)
            {
                try{
                    Class<?> tempClass = Class.forName(names[i*size+j]);
                    Object tempRoom = tempClass.newInstance();
                    tempMaze.add((IRoomObject) tempRoom);

                }catch (Exception e)
                {
                    System.out.println("미로 변환 중 오류 발생");
                }
            }
            maze.add(tempMaze);
        }
    }

    public void Print() {
        for (ArrayList<IRoomObject> row : maze) {
            for (IRoomObject obj : row) {
                System.out.print(obj.toString());
            }
            System.out.println();
        }
        GameManager.getInstance().PrintLine();
    }

    public IRoomObject GetObject(Position pos)
    {
        return maze.get(pos.y).get(pos.x);
    }
    public void SetObject(Position pos, IRoomObject room)
    {
        maze.get(pos.y).set(pos.x, room);
    }
    public int GetSize()
    {
        return size;
    }

    public String GetName() {
        return mazeName;
    }
    public String GetObjectNames()
    {
        String names = "";
        int rowCnt=0;
        for (ArrayList<IRoomObject> row : maze)
        {
            for(IRoomObject room : row)
            {
                names = names + room.GetName() + " ";
            }
        }
        return names;
    }



}
