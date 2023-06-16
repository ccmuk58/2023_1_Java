public class GameManager {

    private static GameManager instance = null;
    Player player;
    MazeGenerator mazeGenerator;
    MazeLoader mazeLoader;
    Maze maze;
    private int x, y;
    private int stage;

    private GameManager(){}
    public static GameManager getInstance() {
        if(instance == null) {
            instance = new GameManager();
        }
        return instance;
    }


}
