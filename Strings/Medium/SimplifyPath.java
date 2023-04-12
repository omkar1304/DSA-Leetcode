// https://leetcode.com/problems/simplify-path/

class Solution {
    public String simplifyPath(String path) {
        
        /*
        So, basically what are we doing:-
        Pushing and Popping directory names based on rules

        And what are the rules :-

        /.. come out from the directory
        /nameOfDirectory going into directory
        */
        
        Stack<String> stack = new Stack<>();
        
        // split string based on '/' so we can push element in stack
        String[] p = path.split("/");
        
        for(int i=0; i<p.length; i++){
            
            // /.. come out from the directory so pop out from stack
            if(!stack.isEmpty() && p[i].equals(".."))
                stack.pop();
            // /nameOfDirectory going into directory so push it in stack
            else if(!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        
        // if stack is empty then we are in root directory so return '/'
        if(stack.isEmpty())
            return "/";
        
        //  remeber when returning we have to go in the form of reverse order. Because Stack use LIFO order and the highest one will comes out. But we need the lowest once first. So, we need to append in the carefull manner. so if stack contains -> c|b|a then we should return -> /a/b/c
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0, stack.pop()).insert(0, "/");
        }
        
        return res.toString();
    }
}