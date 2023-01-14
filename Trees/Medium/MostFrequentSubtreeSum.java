// https://leetcode.com/problems/most-frequent-subtree-sum/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // creating map to store frequency table as <Sum, count>
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        // we need to start from bottom till up so apply postOrder
        postOrder(root);
        
        // after postorder we will have all sum and their respective occurance count
        // also will have maxCount for particular sum
        
        // so create list and add only those sums(keys) which having count == maxCount
        List<Integer> tempList = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxCount)
                tempList.add(key);
        }
        
        // as per the requirement convert list into array and return it
        int[] result = new int[tempList.size()];
        for(int i=0; i<tempList.size(); i++)
            result[i] = tempList.get(i);
        
        return result;
    }
    
    public int postOrder(TreeNode root){
        
        // it root is null then return sum = 0
        if(root == null)
            return 0;
        
        // else go its left and right start from bottom
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        // get sum for each node
        int sum = left + right + root.val;
        
        // put in map if already present then inc count by 1
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // every time we put sum in map we need to check its count if its greater than maxCount then update maxCount with it
        maxCount = Math.max(maxCount, map.get(sum));
        
        // return sum for parent node 
        return sum;
    }
}