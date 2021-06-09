class Solution 
{
    public int[] sumZero(int n) 
    {
       int i;
        int arr[] = new int[n];
      //it will take any array based on the value of n..such that sum of all number will lead to 0;
        for(i=0;i<n;i++)
        {
            arr[i] = i*2 - n + 1;   //main logic
        }
        return arr;
    }
}
