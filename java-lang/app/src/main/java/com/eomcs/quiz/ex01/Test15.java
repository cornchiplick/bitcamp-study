// 출처: codefights.com
//
// 주어진 문자열이 반복 문자열인지 검사하라!
// 예)
//   "abcdeabcde"   --> true
//   "qqq"          --> false
//   "2w2www        --> false
//
/*
Determine whether the given string is a concatenation of another string 
to itself.

Example

for 'tandemtandem' output should be true

for 'qqq' or '2w2ww' output should be false

[input] string inputString

[output] boolean

true if inputString represents a string concatenated to itself, 
false otherwise

 */
//
// [시간 복잡도]
// - ?
//
public class Test15 {

  public static void main(String[] args) {
    System.out.println(isTandemRepeat("abcdeabcde")); // true
    System.out.println(isTandemRepeat("qqq")); // false
    System.out.println(isTandemRepeat("2w2www")); // false
  }

  // 이 메서드를 완성하시오!
  static boolean isTandemRepeat(String inputString) {
    if ((inputString.length() & 1) == 1) {
      return false;
    }

    int length = inputString.length() / 2;
    for (int i = 0; i < length; i++) {
      if (inputString.charAt(i) != (inputString.charAt(i + length))) {
        return false;
      }
    }
    return true;
  }
}
