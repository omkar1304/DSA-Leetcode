// https://leetcode.com/problems/word-ladder-ii/

// Brute force way -> but it will accept in interviews
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        // to store list of sequence
        List<List<String>> result = new ArrayList<>();
        
         // creating set to find word in O(1) time
        Set<String> set = new HashSet<>();
        for(String word : wordList)
            set.add(word);
        
        // queue to store seq words level wise
        Queue<List<String>> queue = new LinkedList<>();
        // creating list at every nodes at level
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        queue.offer(temp);
        
        // to keep track of usedword level wise
        List<String> usedWords = new ArrayList<>();
        
        while(!queue.isEmpty()){
            
            // removing usedword from set for next level to avoid duplicate calls
            for(String useWord : usedWords)
                set.remove(useWord);
            
            // getting size so we can run loop level wise
            int size = queue.size();
            
            for(int index=0; index<size; index++){
                
                // at each level pop out available string list
                List<String> tempList = queue.peek();
                queue.poll();
                
                // as we know new word will at the last so we can take out word from last index
                String word = tempList.get(tempList.size() - 1);
                
                // if word is matching with endword then we got out sequenece so store in result
                if(word.equals(endWord)){
                    result.add(tempList);
                    continue;
                }
                    
                // taking word length to keep changing char in string index wise
                int wordLen = word.length();
                
                for(int i=0; i<wordLen; i++){
                    
                    // trying all a to z possible values
                    for(char ch='a'; ch<='z'; ch++){
                        
                        // creating new word based on a to z at every index of string
                        char[] wordArray = word.toCharArray();
                        wordArray[i] = ch;
                        String newWord = new String(wordArray);
                        
                        // if that new word is present in set then it can be part of seq
                        if(set.contains(newWord)){
                            
                            // add word in current temp list and also add in usedword list 
                            tempList.add(newWord);
                            usedWords.add(newWord);
                            
                            // and add that updated list in queue
                            queue.offer(new ArrayList<>(tempList));
                            
                            // remove that word from list #backtrack
                            tempList.remove(tempList.size() - 1);
                            
                        }
                    }
                }
            }
        }
        
        return result;
    }
}

// optimized and accepted solution but not predictable
class Solution {
    // if we move seq from start word to end word we will get multiple routes but at the end we will get few only which will leads to end word so we can start from endword to start word to avoid extra paths
    public void DFS(String currWord, String targetWord, List<String> seq, Map<String, Integer> map, List<List<String>> result){
        
        // if current word is targetword hence we recehed so store that seq in result and return it
        if(currWord.equals(targetWord)){
            
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp); // we are storing end to start so reverse it and store it
            result.add(temp);
            return;
        }
        
        // taking current word length and its level from map
        int wordLen = currWord.length();
        int steps = map.get(currWord);
        
        // now same way we can backtrack from end word to new word with creating new word with changing char from a to z at every index
        
        for(int i=0; i<wordLen; i++){
            
            for(char ch='a'; ch<='z'; ch++){
                
                // creating new word based on a to z at every index of string
                char[] wordArray = currWord.toCharArray();
                wordArray[i] = ch;
                String newWord = new String(wordArray);
                
                // if that newword is present means backtrack is possible but also we need to make sure that if targetnode at level 4 then its previous word should at level 3
                if(map.containsKey(newWord) && map.get(newWord) + 1 == steps){
                    
                    // add word in sequenece 
                    seq.add(newWord);
                    
                    // apply same to its next level
                    DFS(newWord, targetWord, seq, map, result);
                    
                    // remove word in sequence for backtracking
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        // to store list of sequence
        List<List<String>> result = new ArrayList<>();
        
        // creating set to find word in O(1) time
        Set<String> set = new HashSet<>();
        for(String word : wordList)
            set.add(word);
        
        // creating map to store key : value -> word : level
        Map<String, Integer> map = new HashMap<>();
        // starting with startword with level 1
        map.put(beginWord, 1);
        
        // queue to store seq words level wise
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        // if startword is there in set then we already added in queue so remove it from set
        set.remove(beginWord);
        
        while(!queue.isEmpty()){
            
            // pop out word from queue
            String word = queue.peek();
            queue.poll();
            
            // and get level value from that word
            int steps = map.get(word);
            
            // if we converted start word to end word then break loop
            if(word.equals(endWord))
                break;
            
            // taking word length to keep changing char in string index wise
            int wordLen = word.length();
            for(int i=0; i<wordLen; i++){
                
                // trying all a to z possible values
                for(char ch='a'; ch<='z'; ch++){
                    
                    // creating new word based on a to z at every index of string
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    
                    // if that newowrd is present in set then add in queue and map with level + 1
                    // also its used so remove from set
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        map.put(newWord, steps+1);
                        queue.offer(newWord);
                    }
                }
            }
        }
        
        // need to check loop completed due queue empty or we converted start word to end word
        // if endword is there in map then apply DFS technique and update result and retrun it else return empty result
        if(map.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            DFS(endWord, beginWord, seq, map, result);
        }
        
        return result;
    }
}