public class EmptyObject implements RoomObject{
    @Override
    public boolean Active() {
        PrintInfo();
        return true;
    }

    @Override
    public void PrintInfo() {
        System.out.println("빈 방이다.");
        GameManager.getInstance().PrintLine();
    }

    @Override
    public String toString() {
        return "O";
    }
}
