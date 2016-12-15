/**
 * changeArrayRef() 试图改变指向a数组的引用，实际上只改变了临时变量para 
 */
public class ArrayPara {
	public static void changeArrayValue(int[] para) {
		para[0] = 2;
	}
	public static void changeArrayRef(int[] para) {
		int temp[] = {2, 3, 4, 5};
		para = temp;
	}
	public static void main(String[] args) {
		int a[];
		a = new int[] {99, 100};
		changeArrayValue(a);
		System.out.println(a[0]);
		a = new int[] {99, 100};
		changeArrayRef(a);
		System.out.println(a[0]);
	}

}
