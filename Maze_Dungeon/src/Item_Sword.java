public class Item_Sword extends Item implements IPowerItem{
    public Item_Sword()
    {
        name = "Sword";
        power = 1;
    }
    @Override
    public void PrintInfo() {
        super.PrintInfo();
        System.out.println("효과 : 플레이어의 공격력을 " + power + "증가 시킵니다.");
        GameManager.getInstance().PrintLine();
    }

    @Override
    public int TakePower() {
        return power;
    }
}
