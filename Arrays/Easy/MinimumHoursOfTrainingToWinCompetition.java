// https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        // First handling the energy hours
        // Since Energy is decreasing after every fight. We need our energy to be strictly greater than the sum of total energy.
        int energySum = 0;
        for(int i=0; i<energy.length; i++)
            energySum += energy[i];
        
        // if energySum - initialEnergy is less than 0 then we dont need to spend any extra hours for energy so assgin 0 else assgin energySum - initialEnergy + 1(stricly greater )
        int requiredEnergy = (energySum - initialEnergy >= 0) ? (energySum + 1 - initialEnergy) : 0;
        
        
        // Since Experience is only increasing after every fight. 
         // No of training hours needed is the (max of the diff of opponent experience and current experience) to win over all the opponents
        int requiredExp = Integer.MIN_VALUE;
        int currentExp = initialExperience;
        
        for(int i=0; i<experience.length; i++){
            
            // if current experience is less than or equal to experience it means we need training hours
            if(currentExp <= experience[i])
                requiredExp = Math.max(requiredExp, (experience[i] + 1 - currentExp));
            
            // keep adding upcoming experience in currentExp
            currentExp += experience[i];
        }
        
        // if requiredExp is not changed then make it 0 
        if(requiredExp == Integer.MIN_VALUE)
            requiredExp = 0;
        
        // total training hours = required for enegery + required for experience
        int total = requiredEnergy + requiredExp;
        
        return total;
    }
}