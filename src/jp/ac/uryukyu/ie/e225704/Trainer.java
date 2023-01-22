package jp.ac.uryukyu.ie.e225704;

import java.util.ArrayList;
import java.util.Scanner;

public class Trainer {
    private ArrayList<Pokemon> party = new ArrayList<Pokemon>(6);

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

    private Pokemon partySelect(){
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        System.out.println("\nてもちポケモン");
        for(var member : this.party){
            System.out.println(i + ". " + member.getterName() + "　Lv." + member.getterLevel());
            i ++;
        }
        while(true){
            int number = scanner.nextInt();

            if(number >=0 && number <= i){
                System.out.println("\nいけ、 " + this.party.get(number).getterName() + "！\n");
                return this.party.get(number);
            }
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
                party.add(p1);
                start = false;
            }
            System.out.println("何をしようか？");
            System.out.println("たたかう＝b、つよさをみる＝s、しんかさせる＝e、別のポケモンを育てる＝c、手持ちを見る＝p、終了する＝f");
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
                case "c" :
                if(party.size() < 6){
                    System.out.println(p1.getterName() + "は手持ちに戻した。\n");
                    start = true;
                }
                else{
                    System.out.println("これ以上は育てるのは身がもたない．．．");
                }
                break;
                case "p" :
                p1 = this.partySelect();
                break;
                case "f" :
                con = false;
                break;
            }
            
        }
    }
}
