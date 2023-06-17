public class Milk extends Item implements IHpItem{
    public Milk()
    {
        name = "Milk";
        power = 2;
    }
    @Override
    public void PrintInfo() {
        super.PrintInfo();
        System.out.println("효과 : 플레이어의 생명력을 " + power + "회복 시킵니다.");
        GameManager.getInstance().PrintLine();
    }

    @Override
    public int TakeHp() {
        return power;
    }
}
