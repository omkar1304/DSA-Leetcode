// https://leetcode.com/problems/find-center-of-star-graph/

class Solution {
    public int findCenter(int[][] edges) {
        // 'A center node must appear in every edge'
        // so we only need to check starting two edges
        // if edge1's fist node(u) is present in edge2 then its star node else edge1's second node(v) is star node
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}