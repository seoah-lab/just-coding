import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamArraytoList {

  public static void main(String[] args) {
    int[] arr = new int[]{4, 3, 2, 1};

    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

    int[] nums = list.stream().mapToInt(Integer::intValue).toArray();

    System.out.println(Arrays.toString(nums));

  }

}
