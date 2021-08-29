package model;

import bodypart.AbstractBodyPart;
import bodypart.BodyPart;
import bodypart.BodyPartType;
import robot.AbstractRobot;
import robot.Robot;

public class RobotFight {
    public static void main(String[] args) {
        Robot bender = new Robot("Bender", new BodyPart(BodyPartType.LEG),
                new BodyPart(BodyPartType.LEG), new BodyPart(BodyPartType.ARM),
                new BodyPart(BodyPartType.ARM), new BodyPart(BodyPartType.CHEST),
                new BodyPart(BodyPartType.HEAD));
        Robot spiderPrime = new Robot("Spider Prime", new BodyPart(BodyPartType.LEG),
                new BodyPart(BodyPartType.LEG), new BodyPart(BodyPartType.LEG),
                new BodyPart(BodyPartType.LEG), new BodyPart(BodyPartType.LEG),
                new BodyPart(BodyPartType.HEAD));

        RobotFight.startGame(bender, spiderPrime);
    }

    private static void startGame(AbstractRobot firstRobot, AbstractRobot secondRobot) {
        int breakCounter = 0;
        int firstHpCounter = 0;
        int secondHpCounter = 0;

        AbstractBodyPart attacked;
        AbstractBodyPart defended;

        while (firstRobot.getHitPoints() > 0 | secondRobot.getHitPoints() > 0) {
            if (breakCounter > 3) {
                break;
            }

            attacked = firstRobot.attack();
            defended = secondRobot.defence();

            printBattle(attacked, defended, firstRobot, secondRobot);

            //if: если в очередной итерации второму роботу до его атаки выбили последнюю часть
            if (secondRobot.getHitPoints() == 0) {
                break;
            }

            attacked = secondRobot.attack();
            defended = firstRobot.defence();

            printBattle(attacked, defended, secondRobot, firstRobot);

            //if: если в очередной итерации первому роботу до его следующей выбили последнюю часть
            if (firstRobot.getHitPoints() == 0) {
                break;
            }

            //if: считаем счетчики, если у роботов остались только одинаковые части
            if (firstHpCounter == firstRobot.getHitPoints() & secondHpCounter == secondRobot.getHitPoints()) {
                breakCounter++;
            }

            firstHpCounter = firstRobot.getHitPoints();
            secondHpCounter = secondRobot.getHitPoints();
        }

        System.out.printf("HP робота %s: %s. HP робота %s: %s.\n", firstRobot.getRobotName(), firstRobot.getHitPoints(),
                secondRobot.getRobotName(), secondRobot.getHitPoints());

        if (firstRobot.getHitPoints() > secondRobot.getHitPoints()) {
            System.out.println(firstRobot.getRobotName() + " Победил!");
        } else if (firstRobot.getHitPoints() < secondRobot.getHitPoints()) {
            System.out.println(secondRobot.getRobotName() + " Победил!");
        } else if (firstRobot.getHitPoints() == secondRobot.getHitPoints()) {
            System.out.println("Ничья!");
        }
    }

    private static void printBattle(AbstractBodyPart attacked, AbstractBodyPart defended,
                                    AbstractRobot attackRobot, AbstractRobot defendRobot) {
        System.out.printf("%s атаковал робота %s, атакована %s, защищена %s\n",
                attackRobot.getRobotName(), defendRobot.getRobotName(),
                attacked.getBodyPartType(), defended.getBodyPartType());

        if (attacked.getBodyPartType() == defended.getBodyPartType()) {
            System.out.println(defended.getBodyPartType() + " не пострадала!");
        } else {
            defendRobot.removeBodyPart(defended);
            defendRobot.setHitPoints();
            System.out.println(defended.getBodyPartType() + " повреждена!");
        }
    }
}