class Solution 
{
    public int removeElement(int[] nums, int val) 
    {
        int start=0;  //start index.
        int end = nums.length-1;  //last index.
        int count=0;
        while(start<=end)
        {
            if(nums[end]==val)  //checking if the last element matches with the val..
           {
               count++;  //increase the count..
               end--;  //and decrease the end index..
           }
            else if(nums[start]==val)  //if start index matches with the val..
            {
                count++;
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
            else  //if neither of them matches..then simply increase start index..
            {
                start++;
            }
        }
        return nums.length-count;  //return how many numbers did not match with the val..
    }
}
