package test;

import cards.Cards;
import cards.Compare;
import org.junit.*;

public class CardsTest {
    @Test
    public void test1() {
            System.out.println("测试的数据都是顺子");
            System.out.println("TD JS QS KH AD");
            System.out.println("KD TD QS JH 9D");
            //牌字符串转换成Cards对象
            Cards blackCards = new Cards("TD JS QS KH AD");
            Cards whiteCards = new Cards("KD TD QS JH 9D");
            //调用比较方法
            Compare.compare(blackCards, whiteCards);
            System.out.println("");
    }

    @Test
    public void test2(){
        System.out.println("测试的数据都是散牌");
        System.out.println("2D 3D 5D 7D 9S");
        System.out.println("2S 5D 6H 9D 7S");
        //牌字符串转换成Cards对象
        Cards blackCards = new Cards("2D 3D 5D 7D 9S");
        Cards whiteCards = new Cards("2S 5D 6H 9D 7S");
        //调用比较方法
        Compare.compare(blackCards, whiteCards);
        System.out.println("");
    }

    @Test
    public void test3(){
        System.out.println("测试的数据 黑方同花顺 白方四条");
        System.out.println("3H 4H 5H 6H 7H");
        System.out.println("AD AC AH 3S AC");
        //牌字符串转换成Cards对象
        Cards blackCards = new Cards("3H 4H 5H 6H 7H");
        Cards whiteCards = new Cards("AD AC AH 3S AC");
        //调用比较方法
        Compare.compare(blackCards, whiteCards);
        System.out.println("");
    }

}