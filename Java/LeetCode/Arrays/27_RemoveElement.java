class Solution {
    public int removeElement(int[] nums, int val) {

        int start = 0;
        int end = nums.length - 1;
        
        while(start < end || (end >= 0 && nums[end] == val)){
            if(nums[end] == val)
                end--;
            else if(nums[start] == val) {
                swap(nums, start, end);
                start++;
                end--;
            } else
                start++;
        }
        
        return end+1;
    }
    
    public void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = array[a];
    }
}

