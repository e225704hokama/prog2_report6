package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

import javax.sound.midi.VoiceStatus;

public abstract class Pokemon {
    String name; //その個体の種族名
    String precious = ""; //色違いなどのシミュレーション要素を入れたい
    int[] raceValue = new int[6]; //俗に言う種族値
    int[] individualValue = new int[6]; //俗に言う個体値
    int[] efortValue = new int[6]; //俗に言う努力値
    int level; //その個体のレベル
    final int maxLevel = 100; //原作通り最高レベルは100にしておく
    int evolutionLevel; //進化するレベル
    int[] status = new int[6]; //俗に言う実数値。プレイヤーが見ることができる能力値

    public abstract Pokemon evolution(); //各々進化先が異なるので抽象メソッドにした

    public void summary(){ //種族名、レベル、実数値などのステータスを表示するメソッド
        System.out.println(this.name + " " + this.precious + "　　Lv." + this.level);
        System.out.println("つよさ");
        
        int statuss;
        this.calcStatus();
        for(int i=0; i<6; i+=1){
            statuss = this.status[i];
            System.out.println(statuss);
        }
        
    }

    public int[] calcStatus(){ //実数値を計算するメソッド
        for(int i=0; i<6; i++){
            if(i == 0){
                this.status[i] = (this.raceValue[i]*2 + this.individualValue[i] + this.efortValue[i]/4) * this.level/100 + 10+this.level;
            }
            else{
                this.status[i] = (this.raceValue[i]*2 + this.individualValue[i] + this.efortValue[i]/4) * this.level/100 + 5;
            }
        }

        return this.status;
    }

    public void takeStatus(Pokemon littel){ //進化時、進化先のインスタンスに個体値、努力値などを引き継ぐメソッド
        this.individualValue = littel.individualValue;
        this.efortValue = littel.efortValue;
        this.level = littel.level;
        this.precious = littel.precious;
        
    }

    public void battle(){ //レベル上げ、努力値振りをするメソッド
        int encount = new Random().nextInt(6);
        if(this.level<maxLevel){
            this.level += 1;

            if(this.efortValue[encount]<252){
                this.efortValue[encount] += new Random().nextInt(8);
            }
            switch (encount){
                case 0 :
                System.out.println("キャタピーを倒した。レベルが" + this.level + "になった！\n");
                break;
                case 1 :
                System.out.println("ワンリキーを倒した。レベルが" + this.level + "になった！\n");
                break;
                case 2 :
                System.out.println("イシツブテを倒した。レベルが" + this.level + "になった！\n");
                break;
                case 3 :
                System.out.println("ゴースを倒した。レベルが" + this.level + "になった！\n");
                break;
                case 4 :
                System.out.println("メノクラゲを倒した。レベルが" + this.level + "になった！\n");
                break;
                case 5 :
                System.out.println("コイキングを倒した。レベルが" + this.level + "になった！\n");
                break;
            }
            
        }
        else{
            System.out.println("もう戦ってくれる相手がいないようだ。\n");
        }
        
    }
}
