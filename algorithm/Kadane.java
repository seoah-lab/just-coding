public class Kadane {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(kadane(nums));
    }
    /**
     * 연속된 배열을 더한 수 중에 가장 큰 수를 구한다.
     * 첫번째 요소와 다음 요소를 더한 것과 다음 요소를 비교해서 다음 요소가 더 클 경우
     * 더하기를 시작하는 요소를 다음 요소로 지정해서 O(n) 의 시간 복잡도를 같는다. 
     */
    static int kadane (int[] nums) {
        int max = nums[0]; int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(sum + nums[i] < nums[i]) {
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            
            max = Math.max(max, sum);
        }
        return max;
    }
}
