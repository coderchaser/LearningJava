package courseraJavaDesign;


public class StackOfInts {
	private int[] stack;
	private int next=0;
	public StackOfInts(int size)
	{
		stack=new int[size];
	}
	public void push(int on)
	{
		if (next<stack.length) {
			stack[next++]=on;
		}
	}
	public boolean isEmpty()
	{
		return next==0;
	}
	public int pop()
	{
		if(!isEmpty())
		{
			return stack[--next];
		}
		else 
			return 0;
	}
	public int getStackSize(){
		return next;
	}
	private class StepThrough
	{
		private int i=0;
		public void increment()
		{
			if (i<stack.length) {
				i++;
			}
		}
		public int current()
		{
			return stack[i];
		}
		public boolean isLast()
		{
			if (i==getStackSize()-1)
				return true;
			else
				return false;
		}
	}
	public StepThrough stepThrough()
	{
		return new StepThrough();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOfInts stackOne =new StackOfInts(15);
		for (int j = 0; j <15; j++) {
			stackOne.push(2*j);
		}
		StepThrough iterator=stackOne.stepThrough();
		while(!iterator.isLast())
		{
			System.out.print(iterator.current()+" ");
			iterator.increment();
		}
	}

}
