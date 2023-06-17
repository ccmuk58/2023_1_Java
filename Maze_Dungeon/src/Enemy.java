public abstract class Enemy extends Combat implements IRoomObject {
    @Override
    public boolean Active() {
        if(curHp<=0){
            System.out.println(name + "을(를) 해치웠다!!");
            GameManager.getInstance().PrintLine();
            return true;
        }
        return false;
    }

    @Override
    public void Hit(int dmg) {
        System.out.println(name + "을(를) 공격했다.");
        GameManager.getInstance().PrintLine();
        super.Hit(dmg);
    }

    @Override
    public String toString() {
        return "E";
    }
    public String GetName(){
        return name;
    }
}
