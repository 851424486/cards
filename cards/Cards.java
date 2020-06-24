package cards;

import java.util.ArrayList;

public class Cards {
    //存储五张牌
    private ArrayList<Card> cards=new ArrayList<>(5);
    //牌的等级
    //同花顺＞同花＞四条>顺子＞三条＞两对＞对子＞散牌
    //0: 散牌   1：对子  2：两对  3：三条  4: 顺子  5:四条 6: 同花  7: 同花顺
    private int level;

    //构造器
    public Cards(String cardsStr){
        //把牌分成5部分
        String[] strs = cardsStr.split(" ", 5);
        //把每部分放到ArrayList里
        for(String str:strs){
            //牌的第一位
            char numChar=str.charAt(0);
            //牌的第二位
            char suit=str.charAt(1);
            //数字是10
            if(numChar=='T'){
                Card card=new Card(10,suit);
                this.cards.add(card);
            }
            //11
            else if(numChar=='J'){
                Card card=new Card(11,suit);
                this.cards.add(card);
            }
            //12
            else if(numChar=='Q'){
                Card card=new Card(12,suit);
                this.cards.add(card);
            }
            //13
            else if(numChar=='K'){
                Card card=new Card(13,suit);
                this.cards.add(card);
            }
            //14(把A认为成14)
            else if(numChar=='A'){
                Card card=new Card(14,suit);
                this.cards.add(card);
            }
            //2-9
            else{
                int number=(int)numChar-(int)'0';
                Card card=new Card(number,suit);
                this.cards.add(card);
            }
        }

        //ArrayList里的Card按照card的number大小从大到小排序
        this.cards=Sort.sort(this.cards);

        //调用Level类里的方法，给level,compareParam赋值
        this.level=Level.levelDefine(this.cards);
    }

    //输出五张牌
    @Override
    public String toString() {
        for(int i=0;i<5;i++){
            Card card=this.cards.get(i);
            System.out.println(card);
        }
        return null;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
