public abstract class Item implements IRoomObject {

    protected String name;
    protected int hp;
    protected int power;

    @Override
    public boolean Active() {
        return true;
    }

    @Override
    public void PrintInfo() {
        System.out.println("아이템명 : " + name);
    }

    @Override
    public String toString() {
        return "I";
    }

    public String GetName(){
        return name;
    }
}
