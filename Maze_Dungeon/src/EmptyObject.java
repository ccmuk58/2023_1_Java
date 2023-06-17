public class EmptyObject implements RoomObject{
    @Override
    public void Active() {
        System.out.println("고요,,");
    }

    @Override
    public String toString() {
        return "O";
    }
}
