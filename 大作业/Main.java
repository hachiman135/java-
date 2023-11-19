package 大作业;

import 大作业.map.Map;
import 大作业.charactor.Monster;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        Scanner scanner = new Scanner(System.in);
        boolean isLose = false;
        boolean isWin = false;
        while (!isWin && !isLose) {
            map.DrawMap();
            String direction = scanner.nextLine();
            boolean willHitAnyMonster = false;
            for (Monster monster : map.getMonsters()) {
                if (map.people.willHitMonster(direction, monster)) {
                    willHitAnyMonster = true;
                    break;
                }
            }
            map.people.attack();
            if (!willHitAnyMonster) {
                map.people.move(direction);
            }
            for (Monster monster : map.getMonsters()) {
                if (monster.getHealth() > 0) {
                    monster.attack();
                    if (!monster.willHitPeople(map.people)
                            && !monster.willHitOtherMonster(monster.getDirection(), map.getMonsters())) {
                        monster.move();
                    } else if (monster.willHitOtherMonster(monster.getDirection(), map.getMonsters())) {
                        System.out.println("Monster" + monster.getId() + " can't move " + monster.getDirection()
                                + "because of other monster");
                    }
                }
            }
            isWin = true;
            for (Monster monster : map.getMonsters()) {

                if (monster.getHealth() > 0) {
                    isWin = false;
                }
            }
            if (map.people.getHealth() <= 0) {
                isLose = true;

            }
            System.out.println("");
            System.out.println("People's health: " + map.people.getHealth()); // 打印人物的生命值
            for (Monster monster : map.getMonsters()) {
                System.out.println("Monster" + monster.getId() + "'s health: " + monster.getHealth()); // 打印怪物的生命值
            }

        }
        if (isWin) {
            map.DrawMap();
            System.out.println("You win!");
        } else {
            map.DrawMap();
            System.out.println("You lose!");
        }
        scanner.close();

    }
}
