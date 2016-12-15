/**
 * 
 */

/**
 * @author Emmanuel
 *
 */
public class SieveE {

	/**
	 * @author Emmanuel
	 * @param a[100], the array for putting all the numbers from 1 to 100
	 * @param isprime[100], each isprime[i] stores 
	 * the corresponding-a[i]-is-prime-or-not information
	 */
	
	public static final int MAXNUM = 100;	
	
	public static void main(String[] args) {
		int a[] = new int[MAXNUM];
		boolean isprime[] = new boolean[MAXNUM];
		
		constructor(a, isprime);
		sieve(a, isprime);
		prt(a, isprime);
	}
	
	static void constructor(int a[], boolean isprime[]){
		for (int i = 0; i < MAXNUM; ++i) a[i] = i+1;
		isprime[0] = false;
		for (int i = 1; i < MAXNUM; ++i) isprime[i] = true;
		
	}
	
	static void sieve(int a[], boolean isprime[]){
		/** 
		 * boolean default value equals false,
		 * not necessary to define isprime[0]
		 */
		for (int i = 1  ; i < MAXNUM; ++i){
		for (int j = i+1; j < MAXNUM; ++j){
				if (a[j] % a[i] == 0) isprime[j] = false;
		}
		}
	}
	
	static void prt(int a[], boolean isprime[]){
		for (int i = 0; i < MAXNUM; ++i){
			if (isprime[i] == true) System.out.println(a[i]);
		}
	}
}
