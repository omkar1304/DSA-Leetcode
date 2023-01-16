// https://leetcode.com/problems/find-duplicate-subtrees/

class Pair{
    TreeNode root;
    int count;
    
    public Pair(TreeNode root, int count){
        this.root = root;
        this.count = count;
    }
}
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // to store duplicate tree
        List<TreeNode> result = new ArrayList<>();
        
        // to store postorder string for every subtree and its count
        // here pair will contain node and their occurance count
        Map<String, Pair> map = new HashMap<>();
        
        helper(root, map);
        
        // if we get any subtree count more than 1 then add that node in string
        for(String str : map.keySet()){
            Pair pair = map.get(str);
            if(pair.count > 1)
                result.add(pair.root);               
        }
        
        // and return list
        return result;
    }
    
    public String helper(TreeNode root, Map<String, Pair> map){
        
        // if null then return "N" to get added in string
        if(root == null)
            return "N";
        
        // perform postorder as we need to build string for every node from bottom to up
        String left = helper(root.left, map);
        String right = helper(root.right, map);
        
        // build string with root + left + right
        String str = root.val + "#" + left + "#" + right;
        
        // if map contains that string then inc the count by 1
        if(map.containsKey(str))
            map.get(str).count++;
        // else create new pair(node and count 1) with string
        else
            map.put(str, new Pair(root, 1));
        
        // and return string for parent node 
        return str;
    }
}