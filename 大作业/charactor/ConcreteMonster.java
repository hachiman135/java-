package 大作业.charactor;

public class ConcreteMonster extends Monster {
    public ConcreteMonster(int x, int y, int id) {
        super(x, y, id);
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public void attack() {
        super.attack();
    }

    public void move(String direction) {
        super.move();
    }
}