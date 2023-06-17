public class Wall implements RoomObject{
    @Override
    public boolean Active() {
        PrintInfo();
        return false;
    }

    @Override
    public void PrintInfo() {
        System.out.println("벽은 지나갈 수 없어!!");
    }

    @Override
    public String toString()
    {
        return "W";
    }
}
