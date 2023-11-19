package 大作业.map;

import 大作业.charactor.People;
import 大作业.charactor.ConcreteMonster;
import 大作业.charactor.ConcretePeople;
import 大作业.charactor.Monster;

public class Map {
    public People people;
    public Monster[] monsters;

    public Map() {
        this.people = new ConcretePeople(2, 2);
        this.monsters = new Monster[3];
        this.monsters[0] = new ConcreteMonster(0, 0, 1);
        this.monsters[1] = new ConcreteMonster(0, 2, 2);
        this.monsters[2] = new ConcreteMonster(2, 0, 3);
        setPeopleAndMonsters();
    }

    private void setPeopleAndMonsters() {
        this.people.setMonsters(monsters);
        for (Monster monster : monsters) {
            monster.setPeople(people);
        }
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void DrawMap() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean monsterFound = false;
                boolean peopleFound = false;
                if (i == people.getX() && j == people.getY()) {
                    System.out.print("*");
                    peopleFound = true;
                } else {
                    for (Monster monster : monsters) {
                        if (i == monster.getX() && j == monster.getY() && monster.getHealth() <= 0) {
                            System.out.print("X");
                            monsterFound = true;
                            break;
                        }

                        if (i == monster.getX() && j == monster.getY() && monster.getHealth() > 0) {
                            System.out.print("%");
                            monsterFound = true;
                            break;
                        }
                    }
                }
                if (!monsterFound && !peopleFound) {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
