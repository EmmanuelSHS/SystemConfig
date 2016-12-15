/*
 * to demonstrate that static value has only one memory address/value,
 * the following eg is given:
 * the counter & getTotalNumber() are static,
 * thus the two instance share the same counter with same address
 * the constructor alway adds counter once
 * thus when sn2 is created, the counter=0+1+1=2;
 * 
 * Moreover, notice the blank space in main when initialize sn
 * & the disappearance inside class.
 */

public class SoftwareNumber {
	private int serialNumber;
	public static int counter=0;
	public SoftwareNumber()
	{
		counter++;
		serialNumber=counter;
	}
	public static int getTotalNumber()
	{
		return counter;
	}
	public int getSerialNumber()
	{
		return serialNumber;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SoftwareNumber sn1 = new SoftwareNumber();
		System.out.println(SoftwareNumber.counter);
		System.out.println(SoftwareNumber.getTotalNumber());
		SoftwareNumber sn2 = new SoftwareNumber();
		System.out.println(sn2.getTotalNumber());
		
/*	
 * 		System.out.println(SoftwareNumber.getTotalNumber());
 * 		the above method equals the one above it.
 * 		in eclipse, to access static methods, better use method name.
 */
	}

}
