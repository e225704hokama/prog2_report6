package jp.ac.uryukyu.ie.e225704;

import java.util.Scanner;

public class Trainer {
    public static void main(String[] args) {
        boolean con = true;
        Scanner scanner = new Scanner(System.in);
        
        Pokemon p1 = new Bulbasaur();

        while(con){
            System.out.println("何をしようか？");
            System.out.println("たたかう＝b、つよさをみる＝s、しんかさせる＝e、終了する＝f");
            String order = scanner.next();

            switch(order){
                case "b" :
                p1.battle();
                break;
                case "s" :
                p1.summary();
                break;
                case "e" :
                p1.evolution();
                break;
                case "f" :
                con = false;
                break;
            }
        }

    }
}
