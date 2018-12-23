package com.codemanship.santa.permutations;
import java.util.ArrayList;
import java.util.List;

public class HeapsPermuter {
	
	public static Object[][] permute(Object[] array){
		return permute(array, array.length, new ArrayList<Object[]>());
	}

	private static Object[][] permute(Object[] array, int n, List<Object[]> permutations) {
		if(n == 1) {
			permutations.add(array.clone());
		} else {
			for(int i = 0; i < n - 1; i++) {
				permute(array, n - 1, permutations);
				if(n % 2 == 0) {
					swap(array, i, n-1);
				} else {
					swap(array, 0, n-1);
				}
			}
			permute(array, n - 1, permutations);
		}
		return permutations.stream().map(x -> x).toArray(Object[][]::new);
		
	}

	private static void swap(Object[] array, int i, int j) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;		
	}

}
