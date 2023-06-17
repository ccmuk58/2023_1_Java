public abstract class Item implements RoomObject{
    public abstract void Take();

    @Override
    public void Active() {
        Take();
    }


    @Override
    public String toString() {
        return "I";
    }
}
