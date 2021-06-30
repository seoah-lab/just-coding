import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class StreamMaxMin {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(2, 3, 6, 4, 23, 10);

    int n = list.stream()
        .max(Comparator.comparing(integer -> integer))
        .orElseThrow(NoSuchElementException::new);

    System.out.println(n);

    n = list.stream()
        .min(Comparator.comparing(integer -> integer))
        .orElseThrow(NoSuchElementException::new);

    System.out.println(n);

    int[] intArr = {3, 2, 6, 10, 234};
    Integer max = Arrays.stream(intArr)
        .max()
        .getAsInt();

    System.out.println(max);
  }

}
