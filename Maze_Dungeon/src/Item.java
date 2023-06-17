public abstract class Item implements RoomObject{
    public abstract void Take();

    @Override
    public boolean Active() {
        Take();
        return true;
    }


    @Override
    public String toString() {
        return "I";
    }
}
