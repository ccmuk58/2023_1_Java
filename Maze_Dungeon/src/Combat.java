public abstract class Combat {
    public String name = "unknown";
    protected int hp = 99;
    protected int curHp = 99;
    protected int power = 99;

    public void Hit(int dmg) {
        hp -= dmg;
    }

    public int GetHp() {
        return curHp;
    }

    public int GetPower() {
        return power;
    }

    public void AddHp(int addHp){
        curHp += addHp;
        if(curHp>hp) curHp=hp;
    }
}
