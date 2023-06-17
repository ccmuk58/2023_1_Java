import java.util.ArrayList;

public class Player extends Combat implements RoomObject{
    ArrayList<Item> items = new ArrayList<>();

    public Player()
    {
        curHp = hp = 5;
        power = 2;
    }
    @Override
    public boolean Active() {
        return true;
    }

    @Override
    public void PrintInfo() {
        System.out.println("이름 : " + name);
        System.out.println("체력 : " + curHp + "/" + hp);
        System.out.println("공격력 : " + power);
        for (Item item: items) {
            item.PrintInfo();
        }
        System.out.println("이름 : " + name);
    }
    @Override
    public String toString() {
        return "P";
    }

}
