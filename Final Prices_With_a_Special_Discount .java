class Solution 
{
    public int[] finalPrices(int[] prices) 
    {
        int i;
        int n = prices.length;  //length of the prices array..
        
        //traversing the prices array.. one by one..
        for(i=0;i<n-1;i++)
        {
            int min = Integer.MAX_VALUE;  //this will store the index for the minimum value from i..
            int j=i+1;  
            while(j<n) //till it reaches the end of the array...
            {
                if(prices[j]<=prices[i])  //element is less than or equal to current i..
                {
                    min = j;   //store the index..of next minimum value..
                    break;
                }
                else
                {
                    j++;
                }
            }
            if(min==Integer.MAX_VALUE)  //if no minimum value is found..
            {
                continue;   //then skip it..
            }
            prices[i] = prices[i] - prices[min];  //discount..
        }
        return prices;  //return the updated array.
    }
}
