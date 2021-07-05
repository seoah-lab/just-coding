public class Nara {

  public static String solution(int n) {
    String answer = "";

    while(n > 0) {

      if(n%3 == 0) {
        answer = "4" + answer;
        n--;
      } else if(n%3 == 1) {
        answer = "1" + answer;
      } else if(n%3 == 2) {
        answer = "2" + answer;
      }
      n = n/3; 
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println( solution(12));
  }
}
