public class HpPotion extends Item implements IHpItem{
    public HpPotion()
    {
        name = "HealthPotion";
        power = 3;
    }
    @Override
    public void PrintInfo() {
        super.PrintInfo();
        System.out.println("효과 : 플레이어의 생명력을 " + power + "회복 시킵니다.");
        GameManager.GetInstance().PrintLine();
    }

    @Override
    public int TakeHp() {
        return power;
    }
}
