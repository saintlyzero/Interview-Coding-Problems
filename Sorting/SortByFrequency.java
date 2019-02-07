import java.util.*;
class SortByFrequency
{
	
	public static void FreqSort(int[] arr)
	{
		Map<Integer,Integer> map = new TreeMap<>();
		for(int i =0;i<arr.length;i++)
		{
			if(map.get(arr[i]) == null)
				map.put(arr[i],1);
			else
			{
				int count = map.get(arr[i]);
				map.put(arr[i],++count);
			}
		}
	//	System.out.println(map.entrySet());
		
		List list = new LinkedList(map.entrySet());
		
		Collections.sort(list, new Comparator()
		{
			@Override
			public int compare(Object obj1, Object obj2)
			{
				return ((Comparable) ((Map.Entry) (obj1)).getValue())
                  .compareTo(((Map.Entry) (obj2)).getValue());
			}
		});
	//	System.out.println(list);
		
		int count = 0;
		
		for(Iterator it = list.iterator(); it.hasNext();)
		{
			Map.Entry entry  = (Map.Entry) it.next();
			
			int key = (int)entry.getKey();
			int value = (int)entry.getValue();
			
			for(int i=0;i<value;i++)
			{
				arr[count] = key;
				count++;
			}
			
			
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	
	public static void main(String args[])
	{
		int a[] = {1,2,2,3,4,1,2,3,3,1,1,1,1,18};
		
		System.out.println("Original:\n");
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println("\n\nSorted by frequency\n");
		FreqSort(a);
	}
}