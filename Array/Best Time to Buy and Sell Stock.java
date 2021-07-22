class Solution 
{
    public int maxProfit(int[] prices) 
    {
        //first find the minimum price...so that i can buy...
        if(prices.length==0)
        {
            return 0;
        }
        int i;
        int min = Integer.MAX_VALUE;
        int max =0;
        for(i=0;i<prices.length;i++)
        {
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }
}
