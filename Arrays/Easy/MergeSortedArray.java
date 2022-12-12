// https://leetcode.com/problems/merge-sorted-array/



public class MergeSortedArray {
    // without using extra space

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        
        while(p2>=0){
            if(p1>= 0 && nums1[p1] > nums2[p2]){
                nums1[index] = nums1[p1];
                p1--;
                index--;
            }
            else{
                nums1[index] = nums2[p2];
                p2--;
                index--;
            }
        }
    }


    // with using extra space
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
        
    //     int res[] = new int[m+n];
    //     int i=0,j=0,k=0;
        
    //     while(i<m && j<n){
            
    //         if(nums1[i] < nums2[j]){
    //             res[k] = nums1[i];
    //             i++;
    //         }
    //         else{
    //             res[k] = nums2[j];
    //             j++;
    //         }
            
    //         k++;
    //     }  
    //     while(i<m){
    //         res[k] = nums1[i];
    //         i++;
    //         k++;
    //     }

    //     while(j<n){
    //         res[k] = nums2[j];
    //         j++;
    //         k++;
    //     }
        
    //     for(i=0; i<m+n; i++)
    //         nums1[i] = res[i];
        
    // }
}
