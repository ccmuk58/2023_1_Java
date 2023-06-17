import java.util.ArrayList;

public class Player extends Combat implements IRoomObject {
    ArrayList<Item> items = new ArrayList<>();

    public Player()
    {
        name = "player";
        curHp = hp = 5;
        power = 2;
    }
    @Override
    public boolean Active() {
        return true;
    }

    public void PrintInfoDeep() {
        super.PrintInfo();
        System.out.println("아이템 수 : " + items.size());
        for (Item item: items) {
            item.PrintInfo();
        }
        GameManager.getInstance().PrintLine();
    }
    public void AddItem(Item item)
    {
        items.add(item);
    }
    @Override
    public String toString() {
        return "P";
    }

}
