// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        // first we need to calculate how many levels are required to get label
        int level = 0;
        int temp = label;
        
        while(temp >0){
            temp = temp / 2;
            level = level + 1;
        }

        List<Integer> result = new ArrayList<>();
        
        while(level > 0){
            // add label into result
            result.add(label);
            // if its normal tree(not a zig zag) then we can get any nodes parent -> node value / 2
            // suppose no is 4 -> path will be 4 -> 2 -> 1
            // but here we have zig zag so we need compliment of parent i.e. -> comp(value) / 2
            // to get comp we need to observe one thing if difference between node and end value at that level == compliment of node and start value
            // to get end value we have formula -> 2 ^ level - 1
            // to get start value we have formula -> 2 ^ (level -1)
            // so equation will be end - node value == comp of node - start -> 
            // comp of node = start + end - node value
            int comp = (int)Math.pow(2, level-1) + (int)(Math.pow(2, level) - 1) - label;
            // updating label with comp of label
            label = comp / 2;
            // reducing level as we done with one level
            level = level - 1;
            
        }
        // reversing list as we travel from lable to root and we need to return from root to label
        Collections.reverse(result);
        return result;
    }
}