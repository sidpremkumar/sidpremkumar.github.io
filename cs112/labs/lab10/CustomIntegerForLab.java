package labs;

public class CustomIntegerForLab implements Comparable<CustomIntegerForLab>, OperatorOverload<CustomIntegerForLab> {

	public CustomIntegerForLab(Integer x)
	{
		i=x;
	}
	private Integer i;

	@Override
	public int compareTo(CustomIntegerForLab o) {
		// TODO Auto-generated method stub
		return this.i.compareTo(o.i);
	}
	
	public String toString()
	{
		return i.toString();
	}

	@Override
	public CustomIntegerForLab plus(CustomIntegerForLab other) {
		// TODO Auto-generated method stub
		return new CustomIntegerForLab(other.i+this.i);
	}

}
