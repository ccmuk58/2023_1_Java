import java.util.ArrayList;

public class Player implements RoomObject{
    private int hp;
    private int curHp;
    private int power;
    ArrayList<Item> items = new ArrayList<>();

    public void AddHp(int addHp){
        curHp += addHp;
        if(curHp>hp) curHp=hp;
    }

    @Override
    public void Active() {

    }

    @Override
    public String toString() {
        return "P";
    }
}
