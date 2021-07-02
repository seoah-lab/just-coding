import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeStream {

  public static void main(String[] args) {

    List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    // List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라. ex) ("T", 1), ("a", 2) ...
    for (String s : WORDS) {
//      System.out.println(s.substring(0,1));
    }

    Map<String, Integer> map = new HashMap<>();
    WORDS.stream()
        .map(w -> w.substring(0, 1))
        .forEach(prefix -> map.merge(prefix, 1, (oldValue, newValue) -> (newValue += oldValue)));

    map.entrySet().forEach(e -> System.out.println(e.getKey() +" :" + e.getValue()));

    // List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라. ex) ["Hello", "a", "Island", "b"] -> “HI”
    String word = WORDS.stream()
        .filter(w -> w.length() > 1)
        .map(String::toUpperCase)
        .map(w -> w.substring(0, 1))
        .collect(Collectors.joining(" "));

//    System.out.println(word);
  }

}
