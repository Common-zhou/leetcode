package com.beiwu.zhou;

/**
 * @author zhoubing
 * @since 2021/11/12 16:45
 */
public class SolutionNo344 {
  public static void main(String[] args) {
    int len = 4;
    char[] test = new char[len];
    for (int i = 0; i < len; i++) {
      test[i] = (char) ('a' + i);
    }

    new SolutionNo344().reverseString(test);
    System.out.println(test);

  }

  public void reverseString(char[] s) {
    if (s == null || s.length <= 1) {
      return;
    }

    for (int i = 0; i < s.length / 2; i++) {
      int left = i;
      int right = s.length - left - 1;

      char tmp = s[left];
      s[left] = s[right];
      s[right] = tmp;
    }

  }

}
