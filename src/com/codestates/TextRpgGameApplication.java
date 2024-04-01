package com.codestates;

import java.util.Scanner;

public class TextRpgGameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[안내] TRPG 스타크래프트 시작합니다.");

        Unit playerUnit = createPlayer(scanner, "자신");
        Unit enemyUnit = createPlayer(scanner, "상대");

        System.out.println("----------------------------------------");

        playGame(playerUnit, enemyUnit);
    }

    // 유닛 생성
    public static Unit createPlayer(Scanner scanner, String playerName) {
        System.out.println("[안내] " + playerName + "의 유닛 정보를 입력해 주세요.");
        String name = promptUserForInput("[시스템] 유닛 [이름]을 입력해 주세요:", scanner);
        int attackPower = Integer.parseInt(promptUserForInput("[시스템] 유닛 [공격력]을 입력해 주세요 : ", scanner));
        int defense = Integer.parseInt(promptUserForInput("[시스템] 유닛 [방어력]을 입력해 주세요 : ", scanner));
        int health = Integer.parseInt(promptUserForInput("[시스템] 유닛 [체력]을 입력해 주세요 : ", scanner));
        System.out.println();

        Unit unit = new Unit(name, attackPower, defense, health);
        displayPlayerInfo(playerName, unit);
        return unit;
    }

    // 유닛 정보 확인
    public static void displayPlayerInfo(String playerName, Unit unit) {
        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.println("[안내] " + unit.getName() + " 유닛이 게임에 참여하였습니다.");
        System.out.println("[공격력] : " + unit.getAttackPower());
        System.out.println("[방어력] : " + unit.getDefense());
        System.out.println("[체력] : " + unit.getHealth());
        System.out.println("========================================");
    }

    // 게임 시작
    public static void playGame(Unit playerUnit, Unit enemyUnit) {
        while (enemyUnit.getHealth() > 0) {
            System.out.println("[안내] [" + playerUnit.getName() + "]유닛이 [공격] 하였습니다.");
            int damage = playerUnit.getAttackPower();
            enemyUnit.takeDamage(damage);
            System.out.println("[안내] 상대 유닛의 남은 [체력]은 " + enemyUnit.getHealth() + " 입니다.");
            System.out.println("----------------------------------------");
        }

        System.out.println("[안내] 더 이상 공격할 수 없습니다.");
        System.out.println();
        System.out.println("[안내] 상대 유닛이 제거되었습니다.");
    }

    public static String promptUserForInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}

class Unit {
    private String name;
    private int attackPower;
    private int defense;
    private int health;

    public Unit(String name, int attackPower, int defense, int health) {
        this.name = name;
        this.attackPower = attackPower;
        this.defense = defense;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
            health -= damage / defense;
        }
    }
