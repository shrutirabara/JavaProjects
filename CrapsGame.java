package crapsgame;
import java.util.Random;

/*
 * Author: Shruti Rabara
 * Date: 9/4/19
 * Course: ITSC 1213 Intro to Computer Science II
 * Description: Simulation of the Craps dice game. Craps is a dice game that revolves around rolling two 
six-sided dice in an attempt to roll a particular number. Wins and losses are determined by 
rolling the dice. This project utilizes printing, loops, variables, if-statements or 
switch statements, generating random numbers, methods, and classes. 
 */

public class CrapsGame {

    public static void main(String[] args) {
        Random rand = new Random();

        int point = 0;
        int win = 0;
        int lose = 0;

        for (int i = 1; i < 11; i++) {
            System.out.print("Round: " + i + " , ");
            System.out.print("Roll 1 -- ");
            int dice1 = rand.nextInt(5) + 1;
            int dice2 = rand.nextInt(5) + 1;
            System.out.print("Die1: " + dice1);
            System.out.print(" , Die2: " + dice2);
            int firstRoll = dice1 + dice2;
            System.out.println(" -- Total: " + firstRoll);
            if (firstRoll == 7 || firstRoll == 11) {
                for (int k = 0; k > 0; k++) {
                    win++;
                }
                // win
                System.out.println("wins: " + win);
            } else if (firstRoll == 3 || firstRoll == 12 || firstRoll == 2) {
                for (int k = 0; k > 0; k++) {
                    lose++;
                }
                System.out.println("loses: " + lose);
                // lose
            } else {

                point = firstRoll;
                System.out.println("points stored: " + point);
            }

            boolean counter = true;

            while (counter) {

                int dice3 = rand.nextInt(5) + 1;
                int dice4 = rand.nextInt(5) + 1;
                int otherRoll = dice3 + dice4;
                System.out.print("Die 1: " + dice1);
                System.out.print(" , Die 2: " + dice2);
                System.out.println(" -- Total: " + otherRoll);
                if (otherRoll == point) {
                    win++;
                    counter = false;
                }
                if (otherRoll == 7) {
                    lose++;
                    counter = false;
                }

            }

        }

        // other rounds

        for (int i = 0; i < 999999; i++) {
            int dice5 = rand.nextInt(5) + 1;
            int dice6 = rand.nextInt(5) + 1;

            int firstRoll = dice5 + dice6;

            if (firstRoll == 7 || firstRoll == 11) {

                win++;

                // win

            } else if (firstRoll == 3 || firstRoll == 12 || firstRoll == 2) {

                lose++;

                // lose
            } else {

                point = firstRoll;

            }

        }
        System.out.println("OVERALL: ");
        System.out.print(win + " win(s) , ");
        System.out.print(lose + " loss(es)");

    }
}
