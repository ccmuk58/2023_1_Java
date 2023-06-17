public class Enemy extends Combat implements RoomObject{

    @Override
    public void Hit(int dmg) {
        super.Hit(dmg);
    }

    @Override
    public void PrintInfo() {
        System.out.println("이름 : " + name);
        System.out.println("공격력 : " + power);
        System.out.println("체력 : " + hp);
        GameManager.getInstance().PrintLine();
    }
    @Override
    public boolean Active() {
        PrintInfo();
        Hit(5);
        if(hp<=0){
            System.out.println(name + "을(를) 해치웠다!!");
            GameManager.getInstance().PrintLine();
            return true;
        }
        System.out.println(name + "을(를) 공격했다.");
        GameManager.getInstance().PrintLine();
        PrintInfo();
        return false;
    }

    @Override
    public String toString() {
        return "E";
    }
}
