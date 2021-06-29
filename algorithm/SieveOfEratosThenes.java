public class SieveOfEratosThenes {

  static boolean prime[] = new boolean[121];

  public static void main(String[] args) {
    int n = 120;

    prime[0] = true;
    prime[1] = true;

    for(int i=2; i*i<=n; i++){ // i * i 가 n 보다 작거나 같으면 ex) 2 제곱
        for(int j=i*i; j<=n; j+=i) { // i의 제곱에 i를 더해서 반복
          prime[j] = true;
      }
    }

    for(int i=1; i<=n;i++){
      if(!prime[i]) System.out.print(i+" ");
    }
  }
}