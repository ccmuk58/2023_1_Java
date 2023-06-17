public class Position {
    public int x, y;
    public Position()
    {
        x = 0;
        y = 0;
    }
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public static Position Sum(Position a, Position b)
    {
        return new Position(a.x+b.x, a.y+b.y);
    }
}
