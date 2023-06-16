import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private ArrayList<ArrayList<Room>> maze = new ArrayList<>();

    public Maze() {
        ArrayList<ArrayList<Room>> tempMaze = new ArrayList<>();
        tempMaze.add(new ArrayList<>(Arrays.asList(new Room_Empty(), new Room_Enemy(), new Room_Empty())));
        tempMaze.add(new ArrayList<>(Arrays.asList(new Room_Empty(), new Room_Empty(), new Room_Item())));
        tempMaze.add(new ArrayList<>(Arrays.asList(new Room_Enemy(), new Room_Empty(), new Room_Empty())));
        maze = tempMaze;
    }

    public void print() {
        for (ArrayList<Room> row : maze) {
            for (Room room : row) {
                room.visit();
            }
            System.out.println();
        }
    }
}
