// https://leetcode.com/problems/word-ladder/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        // creating set to find word in O(1) time
        Set<String> set = new HashSet<>();
        for(String word : wordList)
            set.add(word);
        
        // if that endword is not in set then we cant convert word so return 0 
        if(!set.contains(endWord)) return 0;
        
        // creating queue to store word with its level
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        
        
        while(!queue.isEmpty()){
            
            // poping out pair with word and steps from queue
            String word = queue.peek().word;
            int steps = queue.peek().steps;
            queue.poll();
            
            // if word mathes with endword then we got result. as its first time so its minimum level so retrun it
            if(word.equals(endWord) == true)
                return steps;
            
            // taking word length to keep changing char in string index wise
            int wordLen = word.length();
            
            for(int i=0; i<wordLen; i++){
                
                // trying all a to z possible values
                for(char ch='a'; ch<='z'; ch++){
                    
                    // creating new word based on a to z at every index of string
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    
                    // if new word is present in set then add in queue with pair -> newword, steps+1 and remove it from set as its used
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        queue.offer(new Pair(newWord, steps+1));
                    }
                }
            }
        }
        
        // if queue becomes empty then it means we cant convert start word into end word so return 0
        return 0;
    }
}

class Pair{
    
    String word;
    int steps;
    
    public Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}