public abstract class Combat {
    public String name = "unknown";
    protected int hp = 99;
    protected int curHp = 99;
    protected int power = 99;

    public void Hit(int dmg) {
        curHp -= dmg;
        if(curHp<0)curHp=0;
        PrintInfo();
    }
    public void PrintInfo(){
        System.out.println("이름 : " + name);
        System.out.println("체력 : " + curHp + "/" + hp);
        System.out.println("공격력 : " + power);
        GameManager.GetInstance().PrintLine();
    }
    public int GetHp() {
        return curHp;
    }

    public int GetPower() {
        return power;
    }

    public void AddHp(int point){
        curHp += point;
        if(curHp>hp) curHp=hp;
    }
    public void AddPower(int point){
        power += point;
    }


}
