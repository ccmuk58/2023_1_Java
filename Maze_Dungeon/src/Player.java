import java.util.ArrayList;

public class Player extends Combat implements IRoomObject {
    ArrayList<Item> items = new ArrayList<>();

    public Player()
    {
        name = "player";
        curHp = hp = 10;
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
        GameManager.GetInstance().PrintLine();
    }
    public void AddItem(Item item)
    {
        items.add(item);
    }
    @Override
    public String toString() {
        return "P";
    }

    public String GetName(){
        return name;
    }

}
