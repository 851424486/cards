package cards;

import java.util.Scanner;

public class Start {
    public static void main(String[] args){
        /*
        请输入黑方的牌:
        2H 3D 5S 9C KD
        请输入白方的牌:
        2C 3H 4S 8C AH

        方片 D
        黑桃 S
        红桃 H
        梅花 C

        2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A

        0: 散牌   1：对子  2：两对  3：三条  4: 顺子  5：四条 6: 同花  7: 同花顺

        同花：2S TS AS 9S 3S
                AD TD 3D 7D QD

        顺子：TD JS QS KH AD
                KD TD QS JH 9D

        同花顺：TD JD QD KD AD
                JS TS KS AS QS
                    3H 4H 5H 6H 7H

        三条：3C 5C KS KC KH
                TC TS AC AH TC

        两对：QC 5S 5D AH QD
              3C QD 5H QH 5S

        对子：QC 5S 2D AH QD
              6C 2S QD QH AD

        散牌：2D 3D 5D 7D 9S
                2S 5D 6H 9D 7S

        四条：7D 7S 7H 7C 9D
               AD AC AH 3S AC
         */
        while(true){
            //输入牌
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入黑方的牌:");
            String blackCardsStr = scan.nextLine();
            System.out.println("请输入白方的牌:");
            String whiteCardsStr = scan.nextLine();

            //牌字符串转换成Cards对象
            Cards blackCards = new Cards(blackCardsStr);
            Cards whiteCards = new Cards(whiteCardsStr);

            //调用比较方法
            Compare.compare(blackCards, whiteCards);
        }
    }
}
