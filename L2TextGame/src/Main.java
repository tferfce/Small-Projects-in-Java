import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //player stats: name,health,dmg,weapon*
        String playerName;
        int playerMaxHealth=200;
        int playerMaxDmg = 50;
        int playerMaxMp = 200;
        String weapon[] = {"Sword","Dagger","Bow","Mace","Dual Daggers","Staff"};

        //enemy stats: kind, health,dmg
        String enemyKinds[]={"Ghoul","Skeleton","Harpy","Werewolf","Vampire","Dragon","Shark-Man","Griffin"};
        String spells[]={"Fireball","Pinpoint","Phoenix","Blizzard","Simple Hit","Say hello","Body To Mind"};
        String region[]={"Varka Silenos Outpost","Ketra Orc","Death Pass","Dragon Valley"};
        int monsterMaxHealth=200;
        int monsterMaxDmg=40;

        //app running: boolean
        boolean running = true;

        //potions: healing,mana*
        int healingHpReplenish = 40;
        int manaPotionMpReplenish = 30;
        int numHealingPots=3;
        int numMpPots = 3;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter Character Name: ");
        playerName = scanner.nextLine();
        String randomWeapon = weapon[random.nextInt(weapon.length)];
        int playerHealth=random.nextInt(playerMaxHealth);
        int playerDmg = random.nextInt(playerMaxDmg);
        int playerMp = random.nextInt(playerMaxMp);
        System.out.println("Your stats are the following:\n========================="
                +"\nAvatar Name = "+playerName+"\nHealth = "+playerHealth+"\nDamage = "+playerDmg+"\nWeapon = "+randomWeapon+"\nAvailable Mp = "+playerMp+"\n=========================");
        System.out.println("Choose your actions:\n1)Enter the dungeon\n2)Leave the dungeon");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                running = true;
                break;
            case 2:
                System.out.println("Goodbye Coward!!");
                running = false;
                break;
            default:
                running = false;
                break;
        }
        String regionForFight = region[random.nextInt(region.length)];
        String changeRegion;
        while (running) {
            System.out.println("==========================");
            System.out.println("WELCOME TO "+regionForFight.toUpperCase());
            System.out.println("==========================");
            if (playerHealth==0){
                System.out.println("Generated invalid health!");
                break;
            }
            String enemy = enemyKinds[random.nextInt(enemyKinds.length)];
            int enemyHp = random.nextInt(monsterMaxHealth);
            int enemyDMG = random.nextInt(monsterMaxDmg);
            String spellForStats;
            System.out.println("Wild " + enemy.toUpperCase() + " appeared and he is very angry");
            System.out.println("Wanna see his stats??Y/N");
            spellForStats = scanner.next();
            if (spellForStats.equalsIgnoreCase("y")) {
                System.out.println("Spell casted! BOOM");
                System.out.println("His stats are: \n" +
                        "HP = " + enemyHp +
                        "\nDMG = " + enemyDMG);
            }
            System.out.println("Choose your actions:\n1) Attack the monster\n2) Leave the dungeon");
            boolean battleContinue =true;
            int choiceInBattle = scanner.nextInt();
            if (playerMp<5) {
                System.out.println("Replenish some mp so you can proceed into attacking!");
                if (numMpPots > 0) {
                    playerMp += manaPotionMpReplenish;
                    System.out.println("Your remaining mp are " + playerMp);
                    numMpPots--;
                    System.out.println("Remaining mp pots are "+numMpPots);

                } else {
                    System.out.println("Not enough mana potions and PlayerMP! BSOE activate! Emergency Exit Open!");
                    choiceInBattle=2;
                }
            }
            String wannaRun;
            String healingPotOn;
            String nextMonsterProceed;
            String mpPotOn;
            if (choiceInBattle==1){
                while (battleContinue) {
                    if ((playerHealth > 0) && (enemyHp > 0) && (battleContinue =true)&& (playerMp>=5)) {
                        String spell = spells[random.nextInt(spells.length)];
                        System.out.println(playerName.toUpperCase() + " casted " + spell);
                        if (spell.equalsIgnoreCase("Fireball") && playerMp >= 7) {
                            enemyHp -= playerDmg + 10;
                            playerMp -= 7;
                            System.out.println("You inflicted " + (playerDmg + 10) + " dmg " + "with " + randomWeapon + " and " + spell);
                        } else if (spell.equalsIgnoreCase("Pinpoint") && playerMp >= 9) {
                            enemyHp -= playerDmg + 13;
                            playerMp -= 9;
                            System.out.println("You inflicted " + (playerDmg + 13) + " dmg " + "with " + randomWeapon + " and " + spell);
                        } else if (spell.equalsIgnoreCase("Blizzard") && playerMp >= 11) {
                            enemyHp -= playerDmg + 15;
                            playerMp -= 11;
                            System.out.println("You inflicted " + (playerDmg + 15) + " dmg " + "with " + randomWeapon + " and " + spell);
                        } else if (spell.equalsIgnoreCase("Phoenix") && playerMp >= 13) {
                            enemyHp -= playerDmg + 17;
                            playerMp -= 13;
                            System.out.println("You inflicted " + (playerDmg + 17) + " dmg " + "with " + randomWeapon + " and " + spell);
                        } else if (spell.equalsIgnoreCase("Say hello")) {
                            System.out.println("You " + spell + " to the " + enemy + " !Hahahahhah randomizer you are insane!!! This is a joke!! \nZero dmg done!");
                        }else if (spell.equalsIgnoreCase("Body To Mind")) {
                            System.out.println("Wow finally some Mp...but for a cost.. or not! ;) ");
                            if (playerHealth>15){
                                playerMp+=30;
                                playerHealth-=7;
                                System.out.println("Now "+playerName+" has "+playerMp+" mana and "+playerHealth+" health!");
                            }else {
                                playerMp+=15;
                                System.out.println("Now "+playerName+" has "+playerMp+" mana and "+playerHealth+" health!");
                            }
                        }else {
                            enemyHp -= playerDmg;
                            playerMp -= 5;
                            System.out.println("You inflicted " + playerDmg+" dmg "+ "with "+randomWeapon+" and "+spell);
                        }

                        if (enemyHp <= 0) {
                            System.out.println(enemy + " has defeated! Good job!");
                            System.out.println("Remaining player mana are "+playerMp);
                            System.out.println("Remaining player hp is "+playerHealth);
                            System.out.println("Replenish your mana? Y/N");
                            mpPotOn = scanner.next();
                            if (mpPotOn.equalsIgnoreCase("y")){
                                if (numMpPots>0) {
                                    playerMp += manaPotionMpReplenish;
                                    numMpPots--;
                                    System.out.println("Remaining mp pots are "+numMpPots);
                                }else {
                                    System.out.println("Not enough mana potions!");
                                    if (playerMp<5){
                                        running = false;
                                        battleContinue = false;
                                        System.out.println("Cant continue farming! BSOE activated!");
                                    }
                                }
                            }
                            System.out.println("Replenish your HP? Y/N");
                            healingPotOn = scanner.next();
                            if (healingPotOn.equalsIgnoreCase("y") && numHealingPots>0){
                                numHealingPots--;
                                playerHealth+=healingHpReplenish;
                                System.out.println("Your life points are now "+playerHealth);
                            }else if (healingPotOn.equalsIgnoreCase("y") && numHealingPots<=0){
                                System.out.println("Not enough healing potions! ");
                            }
                            System.out.println("Wanna proceed to the next battle?? Y/N");
                            nextMonsterProceed = scanner.next();
                            battleContinue =false;
                            if (nextMonsterProceed.equalsIgnoreCase("n")){
                                System.out.println("Thanks for playing "+playerName.toUpperCase()+"! Come again next time!");
                                running = false;
                            }else if (nextMonsterProceed.equalsIgnoreCase("y")){
                                System.out.println("Want to change randomly region? Y/N");
                                changeRegion = scanner.next();
                                if (changeRegion.equalsIgnoreCase("y")) {
                                    regionForFight = region[random.nextInt(region.length)];
                                }
                                if (playerMp<5 && numMpPots<=0){
                                    System.out.println("Cant continue battling! Emergency exit! BSOE activated!");
                                    running = false;
                                    battleContinue = false;
                                }
                            }
                        } else {
                            playerHealth -=enemyDMG;
                            System.out.println(enemy + " has " + enemyHp + " life points left!");
                            System.out.println(enemy + " did " + enemyDMG + " dmg on you!");
                            if (playerHealth <= 0) {
                                System.out.println("You died a horrible death!");
                                System.out.println("=========================");
                                running = false;
                                battleContinue = false;
                            } else {
                                System.out.println("Your remaining health is " + playerHealth);
                                System.out.println("Your remaining mana is "+ playerMp);
                                System.out.println("Replenish your mana? Y/N");
                                mpPotOn = scanner.next();
                                if (mpPotOn.equalsIgnoreCase("y")){
                                    if (numMpPots>0) {
                                        playerMp += manaPotionMpReplenish;
                                        System.out.println("Your remaining mp are "+playerMp);
                                        numMpPots--;
                                        System.out.println("Remaining mp pots are "+numMpPots);
                                    }else {
                                        System.out.println("Not enough mana potions!");
                                        if (playerMp<5){
                                            running = false;
                                            battleContinue = false;
                                            System.out.println("Cant continue farming! BSOE activated!");
                                        }
                                    }
                                }
                                System.out.println("Use healing potion?? Y/N");
                                healingPotOn = scanner.next();
                                if (healingPotOn.equalsIgnoreCase("y") && numHealingPots>0){
                                    numHealingPots--;
                                    playerHealth+=healingHpReplenish;
                                    System.out.println("Your life points are now "+playerHealth);
                                }else if (healingPotOn.equalsIgnoreCase("y") && numHealingPots<=0){
                                    System.out.println("Not enough healing potions! ");
                                }
                                System.out.println("Run from this battle?? Y/N");
                                wannaRun = scanner.next();
                                if (wannaRun.equalsIgnoreCase("y")){
                                    System.out.println("Want to change randomly region? Y/N");
                                    changeRegion = scanner.next();
                                    if (changeRegion.equalsIgnoreCase("y")) {
                                        regionForFight = region[random.nextInt(region.length)];
                                    }
                                    battleContinue = false;
                                }
                                if (playerMp<5 && numMpPots<=0){
                                    System.out.println("Cant continue battling! Emergency exit! BSOE activated!");
                                    running = false;
                                    battleContinue = false;
                                }else if (playerMp<5 && numMpPots>0){
                                    System.out.println("Emergency replenish mp!");
                                    playerMp += manaPotionMpReplenish;
                                    System.out.println("Your remaining mp are "+playerMp);
                                    numMpPots--;
                                    System.out.println("Remaining mp pots are "+numMpPots);
                                }
                            }
                        }
                    } else {
                        battleContinue =false;
                    }
                }
            }else {

                System.out.println("Thanks for playing "+playerName.toUpperCase()+"! Come again next time!");
                running=false;
            }

        }



    }
}
