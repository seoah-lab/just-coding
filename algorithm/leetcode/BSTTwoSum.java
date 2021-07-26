package leetcode;

import java.util.HashSet;
import java.util.Set;
//653. Two Sum IV - Input is a BST

public class BSTTwoSum {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
        
    }

    // 두개의 숫자만 더하면 되니까 중복은 제거 되어도 되는 문제
    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if(root == null) return false;
        if(set.contains(k - root.val)) return true; // set 에 k - root.val 이 존재하면 합으로 k 가가능
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set); // left , right node recursion
    }
}
