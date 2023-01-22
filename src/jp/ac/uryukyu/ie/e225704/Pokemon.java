package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

public abstract class Pokemon {
    private String name; //そのポケモンの種族名
    private String precious = ""; //色違いなどのシミュレーション要素を入れたい
    private int[] raceValue = new int[6]; //俗に言う種族値。0 = HP、1 = 攻撃、2 = 防御、3 = 特攻、4 = 特防、5 = 素早さ
    private int[] individualValue = new int[6]; //俗に言う個体値。上と同じ
    private int[] efortValue = new int[6]; //俗に言う努力値。上と同じ
    private int[] status = new int[6]; //俗に言う実数値。プレイヤーが見ることができる能力値。上と同じ
    private int level; //その個体のレベル
    final int maxLevel = 100; //原作通り最高レベルは100にしておく
    private int evolutionLevel; //進化するレベル
    private boolean[] eventCounter = {true, true, true, true}; //EventMakerクラスで使用。各イベント最大一回ずつのみ起きるようにする
    private boolean medal = true; //EventMakerクラスで使用。🎖をもらったかを確認する
    
    public Pokemon(){
        this.setterLevel(1);
        for(int i=0; i<6; i++){
            this.setterIndividualValue(i, new Random().nextInt(32));
        }
    }
    
    

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
    public boolean getterEventCounter(int i){
        return this.eventCounter[i];
    }
    public boolean getterMedal(){
        return this.medal;
    }

    //setterメソッド
    public void setterName(String name){
        this.name = name;
    }
    public void setterPrecious(String mark){
        this.precious += mark + " ";
    }
    public void setterLevel(int i){
        this.level += i;
    }
    public void setterEvolutionLevel(int i){
        this.evolutionLevel = i;
    }
    public void setterRaceValue(int i, int s){ //種族値は固定
        this.raceValue[i] = s;
    }
    public void setterIndividualValue(int i, int s){ //個体値は生まれた時に決まり固定
        this.individualValue[i] = s;
    }
    public void setterEfortValue(int i, int s){ //努力値は増える
        this.efortValue[i] += s;
    }
    public void setterEventCounter(int i){
        this.eventCounter[i] = false;
    }
    public void setterMedal(){
        this.medal = false;
    }

    abstract Pokemon evolution(); //各々進化先が異なるので抽象メソッドにした

    protected int[] calcStatus(){ //実数値を計算するメソッド
        for(int i=0; i<6; i++){
            if(i == 0){ //HP = （種族値＊２＋個体値＋努力値/４）＊（レベル/１００）＋１０＋レベル
                this.status[i] = (this.raceValue[i]*2 + this.individualValue[i] + this.efortValue[i]/4) * this.level/100 + 10+this.level;
            }
            else{ //その他 =（種族値＊２＋個体値＋努力値/４）＊（レベル/１００）＋５
                this.status[i] = (this.raceValue[i]*2 + this.individualValue[i] + this.efortValue[i]/4) * this.level/100 + 5;
            }
        }

        return this.status;
    }

    protected void takeStatus(Pokemon littel){ //進化時、進化先のインスタンスに個体値、努力値などを引き継ぐメソッド
        this.individualValue = littel.individualValue;
        this.efortValue = littel.efortValue;
        this.level = littel.level;
        this.precious = littel.precious;
        
    }

    
}
