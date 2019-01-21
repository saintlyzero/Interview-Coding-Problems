import java.util.Vector;
import java.util.HashMap;

class FindPairs
{
	
	public static Boolean findParis(int[] arr,int k)
	{
		Boolean pairFound = false;
		HashMap<Integer,Boolean> data = new HashMap<>();
		for(int i=0;i<arr.length;i++)
			data.put(arr[i],true);
		
		for(int i=0;i<arr.length;i++)
		{
			if(data.get(k) && arr[i] > k)
			{
				System.out.println(k+" - "+arr[i]);
				pairFound = true;
			}
			
			if(arr[i] >= k)
			{
				Vector<Integer> divisors = findDivisors(arr[i]-k);
				
				for(int j=0;j<divisors.size();j++)
				{
					//int cur = divisors.get(j);
					if(arr[i]%divisors.get(j)==k && arr[i]!=divisors.get(j) && data.get(divisors.get(j)) )
					{
						System.out.println(arr[i]+" - "+divisors.get(j));
						pairFound = true;
					}
				}
				divisors.clear();
			}
				
		}
		return pairFound;
	}
	
	public static Vector<Integer> findDivisors(int n)
	{
		Vector<Integer> divisors = new Vector<>();
		
		for(int i=1;i<=Math.sqrt(n);i++)
		{
			if(n % i == 0)
			{
				if(n/i == i)
					divisors.add(i);
				else
				{
					divisors.add(i);
					divisors.add(n/i);
				}
			}
		}
		return divisors;
	}
	
	public static void main(String args[])
	{
		int[] arr = {2,3,10,20,5,4,7,9};
		int k = 3;
		
		if(findParis(arr,k)==false)
			System.out.println("No pair found");
	}
}