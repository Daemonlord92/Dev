package org.blitmatthew;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Miner goldMiner = new Miner("Gold", 0);
        Miner godSteelMiner = new Miner("God Steel Miner", 0);
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("""
                    Welcome to the thread mining game
                    1) Access to Gold Miner
                    2) Access to God Steel Miner
                    """);
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("""
                            Welcome to the Gold Miner
                            1) Print available gold
                            2) Start Mining
                            3) Stop Mining
                            """);
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println(goldMiner.getResourceMined());
                            break;
                        case 2:
                            goldMiner.startMining();
                            break;
                        case 3:
                            goldMiner.stopMining();
                            break;
                        default:
                            System.out.println("Please choice 1-3");
                    }
                    break;
                case 2:
                    System.out.println("""
                            Welcome to the God Steel Miner
                            1) Print available God Steel
                            2) Start Mining
                            3) Stop Mining
                            """);
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println(godSteelMiner.getResourceMined());
                            break;
                        case 2:
                            godSteelMiner.startMining();
                            break;
                        case 3:
                            godSteelMiner.stopMining();
                            break;
                        default:
                            System.out.println("Please choice 1-3");
                    }
                    break;
                default:
                    System.out.println("Please choose 1-2");
            }
        }
    }
}