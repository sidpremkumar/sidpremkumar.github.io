package hw2;

public class FractionLab {
	private	int numerator;
	private	int denominator;
	
	public FractionLab(int initialNumerator, int initialDenominator)
	{
		numerator = initialNumerator;

		if (initialDenominator == 0) // Better to throw an exception, but for now we will simply make it to 1
			initialDenominator = 1;

		denominator = initialDenominator;
		adjustSigns();
		reduceToLowestTerms();
	} // end constructor
	
	private void adjustSigns()
	{
		if (numerator * denominator < 0)
			setSign('-');
		else
			setSign('+');	// In case both signs are minus, change to plus
	} // end adjustSigns 
	
	public void setSign(char sign)
	{
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);

		if (sign == '-')
			numerator = -numerator;
	} // end setSign
	
	public int getNumerator()
	{
		return numerator;
	} // end getNumerator

	
	/*
	 * TODO: You must simply return back the denominator of your fraction. 
	 * This method must contain only 1 line of code inside its body 
	 */
	public int getDenominator()
	{
		return denominator;
	} // end getDenominator
	
	
	public Fraction add(Fraction operand)
	{
		// a/b + c/d is (ad + cb)/(bd)
		Integer newNumerator = numerator * operand.getDenominator() + operand.getNumerator() * denominator;
		Integer newDenominator = denominator * operand.getDenominator();
		return new Fraction(newNumerator, newDenominator);
	} // end add
	
	private int greatestCommonDivisor(int integerOne, int integerTwo)
	{
		while(integerOne!=integerTwo)
		{
			if (integerOne>integerTwo)
			{
				integerOne=integerOne-integerTwo;
			}
			else
			{
				integerTwo=integerTwo-integerOne;
			}
		}
		return integerOne;
	}	// end greatestCommonDivisor
	
	private void reduceToLowestTerms()
	{
		int gcd = greatestCommonDivisor(Math.abs(numerator), Math.abs(denominator));

		numerator = numerator / gcd;
		denominator = denominator / gcd;
	} // end reduceToLowestTerms
	
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	public static void main(String[] args)
	{
		
		Fraction f1=new Fraction(2,-2);
		Fraction f2=new Fraction(2,-4);
		Fraction f3 = f1.add(f2);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
	}
}
