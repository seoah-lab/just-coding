import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class StringArrayToString {

  public static void main(String[] args) {
    String low = "abcdefghijklmnopqrstuvwxyz";

    String[] lowArr = low.split("");

    String t = Arrays.stream(low.split("")).map(r -> r.toUpperCase(Locale.ROOT)).collect(Collectors.joining(""));

    System.out.println(t);
  }

}
