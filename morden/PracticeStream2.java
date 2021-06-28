import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeStream2 {

  public static void main(String[] args) {
    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);

//    위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 배열 리스트를 반환하여라.
//    ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
    List<Integer[]> numbers3 = numbers1.stream()
        .flatMap(n -> numbers2.stream().map(m -> new Integer[]{n, m}))
        .collect(Collectors.toList());

    String result = numbers3.stream().map(a -> "(" + a[0] + ", " + a[1] + ")")
        .collect(Collectors.joining("\n"));
    System.out.println(result);

//    위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
//    ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12

  }

}
