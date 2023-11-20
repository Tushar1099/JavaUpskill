package basicDS;

public class ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 19)
			{
				System.out.println(i);
			}
		}
	}

}
