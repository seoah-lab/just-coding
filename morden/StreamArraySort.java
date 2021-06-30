import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamArraySort {

  public static void main(String[] args) {
    String s = "AZbcdefg";
    String[] arr = s.split("");

    Arrays.sort(arr);
    Arrays.stream(arr).forEach(System.out::println);

    Arrays.sort(arr, Comparator.reverseOrder());
    Arrays.stream(arr).forEach(System.out::println);
  }
  //Stream.of  Stream collect(Collectors.joining)
  public String reverseStr(String str){
    return Stream.of(str.split(""))
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.joining());
  }


}
