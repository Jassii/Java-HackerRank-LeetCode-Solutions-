//.................................................................USING MERGE SORT ALGORITHM...................................................

// Given an array of integers nums, sort the array in ascending order.

// Example 1:

// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Example 2:

// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]

class Solution 
{
    public int[] sortArray(int[] nums) 
    {
        MergeSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void MergeSort(int arr[],int l,int r)
    {
      //base condition
        if(l<r)
        {
            int mid = l + (r-l)/2;   //(l+r)/2; //middle index..
            MergeSort(arr,l,mid);
            MergeSort(arr,mid+1,r);
            
            Merge(arr,l,mid,r);
        }
    }
    
    public void Merge(int arr[],int start,int mid,int end)
    {
        int n1 = mid-start+1;
        int n2 = end-mid;
        
        int L[] = new int[n1];//left array
        int R[] = new int[n2];//right array.
        
      //input the elements in the left array..
        for(int i=0;i<n1;i++)
        {
            L[i]=arr[i+start];
        }
      //input the elements in the right array..
        for(int i=0;i<n2;i++)
        {
            R[i]=arr[i+mid+1];
        }
        
        int i=0,j=0;
        int k=start;  //remember.
      
      //now main sorting is done over here..
        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k]=L[i];
                i++;
            }
            else if(R[j]<L[i])
            {
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        
      //for the remaining elements in the left or right array.
        while(i<n1)
        {
            arr[k]=L[i];
            k++;
            i++;
        }
        
        while(j<n2)
        {
            arr[k]=R[j];
            k++;
            j++;
        }
    }
}
