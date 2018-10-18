
//For Explanation refer: https://www.youtube.com/watch?v=DxW7VAsdX0o

class Stacks
{
	int[] stackTop; // Holds the location of Top for every stack
	int[] stackData; // Actual stack data
	int[] nextIndex; // Used for: 1)Storing next free location 2)Location of previous Top 
	int nextAvailable; // Location for storing next element 
	
	public Stacks(int numberOfStacks, int stackCapacity)
	{
		stackTop = new int[numberOfStacks];
		stackData = new int[stackCapacity];
		nextIndex = new int[stackCapacity];
		nextAvailable = 0;
		
		for(int i=0;i<numberOfStacks;i++)
			stackTop[i] = -1;
		
		for(int i=0;i<stackCapacity-1;i++)
			nextIndex[i] = i+1;
		nextIndex[stackCapacity-1] = -1;
		//s.display();

	}
	void display()
	{
		System.out.print("\nTop:  ");
		for(int i=0;i<stackTop.length;i++)
			System.out.print(stackTop[i]+" ");
		
		System.out.print("\nnextIndex:  ");
		for(int i=0;i<nextIndex.length;i++)
			System.out.print(nextIndex[i]+" ");
		
		System.out.print("\nStackData:  ");
		for(int i=0;i<stackData.length;i++)
			System.out.print(stackData[i]+" ");
		
		System.out.println("");
	} 
	
	boolean push(int stackNumber, int data)
	{
		if(stackNumber < 0 || stackNumber > stackTop.length-1)
			return false; //Invalid stackNumber
		if( nextAvailable < 0)
		{
			System.out.println("OverFlow");
			return false; //OverFlow
		}
			
		
		int currentIndex = nextAvailable;
		stackData[currentIndex] = data; 
		nextAvailable = nextIndex[currentIndex]; 
		nextIndex[currentIndex] = stackTop[stackNumber]; //storing the location of previous Top
		stackTop[stackNumber] = currentIndex; //update with new Top
		//s.display();
		return true;
	}
	
	int pop(int stackNumber)
	{
		if(stackNumber < 0 || stackNumber > stackTop.length-1)
			return -1; //Invalid stackNumber
		if( stackTop[stackNumber] < 0)
		{
			System.out.println("UnderFlow");
			return -1; //UnderFlow
		}
			
		
		int top = stackTop[stackNumber];
		int value = stackData[top];
		int previousTop = nextIndex[top]; //retrive the location of previous Top
		stackTop[stackNumber] = previousTop;
		nextIndex[top] = nextAvailable;
		nextAvailable = top;
		//s.display();
		return value;		
	}

}
class NStacks
{
	public static void main(String args[])
	{
		Stacks s = new Stacks(3,4); // Stack number : 0,1,2 ; Size of Stack Data: 4
		s.push(0,10);
		s.push(1,20);
		s.push(0,15);
		s.pop(1);
		s.push(0,55);
		s.push(2,31);
	}
}