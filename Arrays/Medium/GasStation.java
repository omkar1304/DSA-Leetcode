// https://leetcode.com/problems/gas-station/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0;
        int total = 0;
        int sumg = 0;
        int sumc = 0;
        
        for(int i=0; i<gas.length; i++){
            sumg+= gas[i];
            sumc+= cost[i];
        }
        
        if(sumg<sumc) return -1;
        
        for(int i=0; i<gas.length; i++){
            total = total + (gas[i]-cost[i]);
            if(total < 0){
                total = 0;
                res = i + 1;
            }
        }
        
        return res;
    }
}
