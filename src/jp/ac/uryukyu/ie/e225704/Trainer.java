package jp.ac.uryukyu.ie.e225704;

import java.util.Scanner;

public class Trainer {

    public void summary(Pokemon pokemon){ //種族名、レベル、実数値などのステータスを表示するメソッド
        System.out.println(pokemon.getterName() + "　" + pokemon.getterPrecious() + "　　Lv." + pokemon.getterLevel());
        System.out.println("つよさ");
        
        int statuss;
        pokemon.calcStatus();
        for(int i=0; i<6; i+=1){
            statuss = pokemon.getterStatus(i);
            System.out.println(statuss);
        }
        
    }

    public void newGame(){
        boolean con = true; //ゲームを終了させる
        boolean start = true; //育てるポケモンを既に決めているかを判断する
        Scanner scanner = new Scanner(System.in);
        
        Pokemon p1 = new Bulbasaur(); //デフォルトのポケモン
        EventMaker eventMaker = new EventMaker(); //イベントを発生させる

        while(con){
            if(start == true){
                System.out.println("どのポケモンを育てよう？");
                System.out.println("フシギダネ＝f、ヒトカゲ＝h、ゼニガメ＝z");
                String poke = scanner.next();
                switch(poke){
                    case "f" :
                    p1 = new Bulbasaur();
                    break;
                    case "h" :
                    p1 = new Charmander();
                    break;
                    case "z" :
                    p1 = new Squirtle();
                    break;
                }
                System.out.println(p1.getterName() + "に決めた！\n");
                start = false;
            }
            System.out.println("何をしようか？");
            System.out.println("たたかう＝b、つよさをみる＝s、しんかさせる＝e、終了する＝f");
            String order = scanner.next();

            switch(order){
                case "b" :
                eventMaker.battle(p1);
                break;
                case "s" :
                summary(p1);
                break;
                case "e" :
                p1 = p1.evolution();
                break;
                case "f" :
                con = false;
                break;
            }
            
        }
    }
}
