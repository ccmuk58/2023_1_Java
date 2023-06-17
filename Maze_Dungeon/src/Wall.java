public class Wall implements RoomObject{
    @Override
    public void Active() {
        System.out.println("Wall!!");
    }
    @Override
    public String toString()
    {
        return "W";
    }
}
