package com.beiwu.zhou;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 *
 * @author zhoubing
 * @since 2021/11/12 16:52
 */
public class SolutionNo343 {

  public static void main(String[] args) {
    SolutionNo343 soultion = new SolutionNo343();
    int i = soultion.integerBreak(3);
    assert i == 2;

    i = soultion.integerBreak(4);
    assert i == 4;

    System.out.println(soultion.integerBreak(5));
    System.out.println(i);

  }

  public int integerBreak(int n) {
    if (n == 1 || n == 2) {
      return 1;
    } else if (n == 3) {
      return 2;
    }

    // 用一个数组可以搞定 数组代表什么。用它前面的两位*2。或者前面一位即可
    int[] res = new int[n + 1];

    res[1] = 1;
    res[2] = 1;
    res[3] = 2;

    // 从这位开始  可以挨个判断 i*j
    for (int i = 4; i <= n; i++) {
      int max = 0;
      for (int j = 1; j < i; j++) {
        int curMax = Math.max(res[j] * (i - j), j * (i - j));
        max = Math.max(max, curMax);
      }
      res[i] = max;
    }
    return res[n];
  }
}
