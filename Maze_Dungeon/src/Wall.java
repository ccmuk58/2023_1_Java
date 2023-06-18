public class Wall implements IRoomObject {
    private String name ="Wall";
    @Override
    public boolean Active() {
        PrintInfo();
        return false;
    }

    @Override
    public void PrintInfo() {
        System.out.println("벽은 지나갈 수 없어!!");
        GameManager.GetInstance().PrintLine();
    }

    @Override
    public String toString()
    {
        return "W";
    }

    public String GetName(){
        return name;
    }
}
