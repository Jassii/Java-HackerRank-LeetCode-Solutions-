class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        int i,j;
        //brute force approach.
       /* int arr[] = new int[2];
        for(i=0;i<nums.length-1;i++)
        {
            for(j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    arr[0]=i;
                    arr[1]=j;
                    break;
                }
            }
        }
        return arr;*/
        int arr[] = new int[2];
        //lets take the help of map
        
        Map<Integer,Integer> M = new HashMap<>();
        //number and index.
        for(i=0;i<nums.length;i++)
        {
            if(M.containsKey(target-nums[i]))  //if difference is there then input the value in the array..and break.
            {
                arr[1] = i;
                arr[0] = M.get(target-nums[i]);
                break;
            } 
            //else insert the value and its index in the map..
            M.put(nums[i],i);
        }
        return arr;  //at last return the array..
    }
}
