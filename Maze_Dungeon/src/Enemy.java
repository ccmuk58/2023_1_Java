public abstract class Enemy implements RoomObject{

    protected int hp;
    protected int power;

    public abstract void Fight();

    @Override
    public void Active() {
        Fight();
    }

    @Override
    public String toString() {
        return "E";
    }
}
