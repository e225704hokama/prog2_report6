package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

import javax.sound.midi.VoiceStatus;

public abstract class Pokemon {
    private String name; //その個体の種族名
    private String precious = ""; //色違いなどのシミュレーション要素を入れたい
    private int[] raceValue = new int[6]; //俗に言う種族値
    private int[] individualValue = new int[6]; //俗に言う個体値
    private int[] efortValue = new int[6]; //俗に言う努力値
    private int[] status = new int[6]; //俗に言う実数値。プレイヤーが見ることができる能力値
    private int level; //その個体のレベル
    final int maxLevel = 100; //原作通り最高レベルは100にしておく
    private int evolutionLevel; //進化するレベル
    

    //getterメソッド
    public String getterName(){
        return this.name;
    }
    public String getterPrecious(){
        return this.precious;
    }
    public int getterRaceValue(int i){
        return this.raceValue[i];
    }
    public int getterIndividualValue(int i){
        return this.individualValue[i];
    }
    public int getterEfortValue(int i){
        return this.efortValue[i];
    }
    public int getterStatus(int i){
        return this.status[i];
    }
    public int getterLevel(){
        return this.level;
    }
    public int getterEvolutionLevel(){
        return this.evolutionLevel;
    }

    //setterメソッド
    public void setterName(String name){
        this.name = name;
    }
    public void setterPrecious(String mark){
        this.precious += mark;
    }
    public void setterLevel(int i){
        this.level += i;
    }
    public void setterEvolutionLevel(int i){
        this.evolutionLevel = i;
    }
    public void setterRaceValue(int i, int s){
        this.raceValue[i] = s;
    }
    public void setterIndividualValue(int i, int s){
        this.individualValue[i] = s;
    }
    public void setterEfortValue(int i, int s){
        this.efortValue[i] = s;
    }

    abstract Pokemon evolution(); //各々進化先が異なるので抽象メソッドにした

    public void summary(){ //種族名、レベル、実数値などのステータスを表示するメソッド
        System.out.println(this.name + " " + this.precious + "　　Lv." + this.level);
        System.out.println("つよさ");
        
        int statuss;
        this.calcStatus();
        for(int i=0; i<6; i+=1){
            statuss = this.individualValue[i];
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
