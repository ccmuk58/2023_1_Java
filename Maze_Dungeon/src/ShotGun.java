public class ShotGun extends Item implements IPowerItem{
    public ShotGun()
    {
        name = "ShotGun";
        power = 3;
    }
    @Override
    public void PrintInfo() {
        super.PrintInfo();
        System.out.println("효과 : 플레이어의 공격력을 " + power + "증가 시킵니다.");
        GameManager.GetInstance().PrintLine();
    }

    @Override
    public int TakePower() {
        return power;
    }
}
