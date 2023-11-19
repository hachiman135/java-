package 大作业.charactor;

public class ConcretePeople extends People {
    public ConcretePeople(int x, int y) {
        super(x, y);
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }

    public void attack() {
        super.attack();
    }

    public void move(String direction) {
        super.move(direction);
    }

}