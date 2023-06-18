public class Empty implements IRoomObject {
    private String name = "Empty";
    @Override
    public boolean Active() {
        PrintInfo();
        return true;
    }

    @Override
    public void PrintInfo() {
        System.out.println("빈 방이다.");
        GameManager.GetInstance().PrintLine();
    }

    @Override
    public String toString() {
        return "O";
    }

    public String GetName(){
        return name;
    }
}
