import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Arrays;

class FrequencySort
{
	public static void main(String args[])
	{
		int[] arr = {5,5,7,8,9,8,1,2,8};
		int len = arr.length;
		
		System.out.println("Unsorted: ");
		for(int i=0;i<len;i++)
			System.out.print(arr[i]+" ");
		
		Arrays.sort(arr);
		
		System.out.println("\nSorted: ");
		
		for(int i=0;i<len;i++)
			System.out.print(arr[i]+" ");
		
		Map<Integer,Integer> numbers = new HashMap<>();
		
		for(int number : arr)
		{
			if(numbers.containsKey(number))
			{
				Integer count = numbers.get(number);
				numbers.put(number,count+1);
			}
			else
			{
				numbers.put(number,1);
			}	
		}
		
		System.out.println("\n");
		
		for(Map.Entry<Integer,Integer> n: numbers.entrySet())
		{
			Integer key = n.getKey();
			Integer feq = n.getValue();
			
			System.out.println(key+" : "+feq);
		}
		System.out.println("\n");
		final class FrequencyComparator implements Comparator<Integer>
		{
			Map<Integer,Integer> refMap;
			public FrequencyComparator(Map<Integer,Integer> base)
			{
				this.refMap = base;
			}
			
			@Override
			public int compare(Integer k1, Integer k2)
			{
				Integer val1 = refMap.get(k1);
				Integer val2 = refMap.get(k2);
				
				int num = val1.compareTo(val2);
				// If frequencies are equal, then compare number itself
				return num == 0 ? k1.compareTo(k2) : num;
			}
			
		}
		
		FrequencyComparator comp = new FrequencyComparator(numbers);
		TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(comp);
		sortedMap.putAll(numbers);
		
		for(Integer i: sortedMap.keySet())
		{
			int frequencey = sortedMap.get(i);
            for(int count  = 1 ; count <= frequencey ; count++) 
               System.out.print(i + " " );
		}
		
		
		
	}
}