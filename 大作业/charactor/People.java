package 大作业.charactor;

import java.util.Random;

public class People extends Charactor {
    int x;
    int y;
    int health = 100;
    Monster[] monsters;
    String direction;

    public People(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }

    public boolean willHitMonster(String direction, Monster monster) {
        int newX = x;
        int newY = y;
        this.direction = direction;
        switch (direction) {
            case "up":
                newX--;
                break;
            case "down":
                newX++;
                break;
            case "left":
                newY--;
                break;
            case "right":
                newY++;
                break;
        }
        if (monster.getX() == newX && monster.getY() == newY) {
            return true;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public void move(String direction) {
        this.direction = direction;
        if (direction.equals("left")) {
            if (this.y == 0) {
                System.out.println("You can't go left, you lose to move");
            } else {
                this.y--;
            }
        }
        if (direction.equals("right")) {
            if (this.y == 2) {
                System.out.println("You can't go right, you lose to move");
            } else {
                this.y++;
            }
        }
        if (direction.equals("down")) {
            if (this.x == 2) {
                System.out.println("You can't go down, you lose to move");
            } else {
                this.x++;
            }
        }
        if (direction.equals("up")) {
            if (this.x == 0) {
                System.out.println("You can't go up, you lose to move");
            } else {
                this.x--;
            }
        }
    }

    public void attack() {
        Random random = new Random();
        for (Monster monster : monsters) {
            if (willHitMonster(direction, monster)) {
                if (monster.health <= 0) {
                    System.out.println("Character already dead.");
                } else {
                    if (random.nextInt(2) == 0) {
                        monster.health = monster.health - 50;
                        System.out.println("You attack the monster, the monster's health is " + monster.health);
                    } else {
                        System.out.println("The monster defends your attack");
                    }
                }
            }
        }
    }
}
