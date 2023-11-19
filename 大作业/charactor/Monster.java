package 大作业.charactor;

import java.util.Random;

public abstract class Monster extends Charactor {
    int x;
    int y;
    int health = 100;
    People people;
    String direction;
    int id;
    Random r = new Random();

    public Monster(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public boolean willHitPeople(People people) {
        int newX = x;
        int newY = y;
        int rand = r.nextInt(4);
        if (rand == 0) {
            direction = "up"; // this.x != 0
        } else if (rand == 1) {
            direction = "down"; // this.x != 2
        } else if (rand == 2) {
            direction = "left"; // this.y != 0
        } else if (rand == 3) {
            direction = "right"; // this.y != 2
        }
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
        return people.getX() == newX && people.getY() == newY;
    }

    public String getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

    public boolean willHitOtherMonster(String direction, Monster[] monsters) {
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
        for (Monster otherMonster : monsters) {
            if (otherMonster != this && otherMonster.getX() == newX && otherMonster.getY() == newY) {
                return true;
            }
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

    public void move() {
        if (direction.equals("left")) {
            System.out.println("Monster" + id + " move left");
            if (this.y == 0) {
                System.out.println("You can't go left, you lose to move");
            } else {
                this.y--;
            }
        }
        if (direction.equals("right")) {
            System.out.println("Monster" + id + " move right");
            if (this.y == 2) {
                System.out.println("You can't go right, you lose to move");
            } else {
                this.y++;
            }
        }
        if (direction.equals("down")) {
            System.out.println("Monster" + id + " move down");
            if (this.x == 2) {
                System.out.println("You can't go down, you lose to move");
            } else {
                this.x++;
            }
        }
        if (direction.equals("up")) {
            System.out.println("Monster" + id + " move up");
            if (this.x == 0) {
                System.out.println("You can't go up, you lose to move");
            } else {
                this.x--;
            }
        }
    }

    public void attack() {
        Random random = new Random();
        int ran = random.nextInt(2);
        if (willHitPeople(people)) {
            if (ran == 0 && people.health >= 20) {
                people.health = people.health - 20;
                System.out.println("You are attacked by monster, you health is " + people.health);
            } else if (ran == 0 && people.health < 20) {
                people.health = 0;
                System.out.println("You are attacked by monster, you health is " + people.health);
            } else {
                System.out.println("You successfully defended the attack");
            }
        }
    }

}
