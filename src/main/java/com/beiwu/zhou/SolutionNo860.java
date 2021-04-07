package com.beiwu.zhou;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * @author zhoubing
 * @date 2021-04-07 11:04
 */
public class SolutionNo860 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                // 不用找零
                five++;
            } else if (bill == 10) {
                // 如果是10  要找零
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (bill == 20) {
                // 20 要找15
                int left = 15;
                if (ten != 0) {
                    ten--;
                    left -= 10;
                }
                while (left != 0) {
                    if (five > 0) {
                        five--;
                        left -= 5;
                    }else{
                        return false;
                    }
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {

    }
}
