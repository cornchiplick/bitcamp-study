import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// copyright by codefights.com
//
// 삼각형의 세변 길이가 주어질 때,
// 직각 삼각형인지 판별하라!
// 예)
//    rightTriangle(new int[] {3, 4, 5}) ==> true
//    rightTriangle(new int[] {3, 6, 7}) ==> false
//
// 구현조건)
// - 세변의 길이를 정렬할 때 자바 컬렉션 API를 사용하라!
//   - Arrays.asList()
//   - Collections.sort()
//
/*
For a given triangle determine if it is a right triangle.

[input] array.integer sides
array of three integers representing triangle sides

[output] boolean
true if the triangle with sides from the sides array is a right triangle, false otherwise
 */
//
// [시간 복잡도]
// - ?
//
public class Test11 {

  public static void main(String[] args) {
    System.out.println(rightTriangle(new int[] { 4, 5, 3 }) == true);
    System.out.println(rightTriangle(new int[] { 7, 6, 3 }) == false);
  }

  // 이 메서드를 완성하시오!
  static boolean rightTriangle(int[] sides) {
    Integer[] sidesInt = new Integer[sides.length];

    for (int i = 0; i < 3; i++) {
      sidesInt[i] = sides[i];
    }

    List<Integer> tri = Arrays.asList(sidesInt);
    Collections.sort(tri);

    if (
      Math.pow(tri.get(2), 2) ==
      Math.pow(tri.get(0), 2) +
      Math.pow(tri.get(1), 2)
    ) {
      return true;
    }
    return false;
  }
}
