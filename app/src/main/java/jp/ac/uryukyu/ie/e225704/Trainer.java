package jp.ac.uryukyu.ie.e225704;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Trainer {
    private ArrayList<Pokemon> party = new ArrayList<Pokemon>();
    
    //getterクラス
    public ArrayList<Pokemon> getterParty(){
        return this.party;
    }
    //setterクラス
    public void setterParty(Pokemon pokemon){
        if(this.party.size() <5){
            this.party.add(pokemon);
        }
        else{
            System.out.println("これ以上は育てるのは身がもたない．．．\n");
        }
        
    }

    protected void summary(Pokemon pokemon){ //種族名、レベル、実数値などのステータスを表示するメソッド
        System.out.println(pokemon.getterName() + "　" + pokemon.getterPrecious() + "　　Lv." + pokemon.getterLevel());
        System.out.println("つよさ");
        
        int statuss;
        pokemon.calcStatus();
        for(int i=0; i<6; i+=1){
            statuss = pokemon.getterStatus(i);
            System.out.println(statuss);
        }
        
    }

    protected Pokemon partySelect(Pokemon pokemon){
        Scanner scanner = new Scanner(System.in);
        int i = 2;

        if(this.party.contains(pokemon)){
            party.remove(pokemon);
        }

        System.out.println("\n0. もどる");
        System.out.println("1. 新しくポケモンを育てる");
        System.out.println("\nてもちポケモン");
        for(var member : this.party){
            System.out.println(i + ". " + member.getterName() + " " + member.getterPrecious() + "　Lv." + member.getterLevel());
            i ++;
        }
        while(true){
            try{
                int number = scanner.nextInt();

            if(number == 0){
                return pokemon;
            }
            if(number == 1){
                if(this.party.size() < 5){
                    this.party.add(pokemon);
                    System.out.println(pokemon.getterName() + "は手持ちに戻した。\n");
                    this.start = true;
                    return pokemon;
                }
                else{
                    System.out.println("これ以上は育てるのは身がもたない．．．\n");
                    return pokemon;
                }
            }
            if(i > 2 && number >=2 && number <= i){ //もどるや新しく育てるの項目を入れているため実際の指定するてもちの位置は−２
                party.add(pokemon);
                System.out.println("\nいけ、 " + this.party.get(number-2).getterName() + "！\n");
                return this.party.get(number-2);
            }
            else{
                continue;
            }
            } catch(InputMismatchException e){
                System.out.println("数字を一文字入力してください\n");
                return pokemon;
            }
        }
    }
    //ゲームを動かすメインのコード
    private boolean con = true; //ゲームを終了させる
    private boolean start = true; //育てるポケモンを既に決めているかを判断する

    public void newGame(){
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
                    default :
                    continue; //上記のアルファベット以外が入力された場合もう一度入力を求める
                }
                System.out.println(p1.getterName() + "に決めた！\n");
                start = false;
            }
            System.out.println("何をしようか？");
            System.out.println("トレーニング＝b、つよさをみる＝s、しんかさせる＝e、ポケモンを入れ替える＝p、終了する＝f");
            String order = scanner.next();

            switch(order){
                case "b" :
                eventMaker.battle(p1);
                eventMaker.randomEvent(this, p1);
                break;
                case "s" :
                summary(p1);
                break;
                case "e" :
                p1 = p1.evolution(this);
                break;
                case "p" :
                p1 = this.partySelect(p1);
                break;
                case "f" :
                con = false;
                break;
                default :
                continue;
            }
        }
    }
}
