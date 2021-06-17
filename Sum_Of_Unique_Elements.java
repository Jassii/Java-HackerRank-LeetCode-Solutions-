class Solution 
{
    public int sumOfUnique(int[] nums) 
    {
       Map<Integer,Integer> M = new HashMap<>();
        int i,sum=0;
        for(i=0;i<nums.length;i++)
        {
            if(M.containsKey(nums[i]))
            {
                M.put(nums[i],M.get(nums[i])+1);
            }
            else
            {
                M.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : M.entrySet())
        {
            if(entry.getValue()==1)
            {
               sum = sum + entry.getKey(); 
            }
        }
        return sum;
    }
}
