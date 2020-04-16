package cn.saul.test_t;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class TestForProject {
	public static void main(String[] args) {
		int[] a = null;
		long sum = 0;
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		if(n < 0 || m < 0 || k < 0) return;
		a = new int[n];
		for (int i = 0; i < n; i++){
			a[i] = in.nextInt();
		}



		for (int i = 0; i < m; i++){
			Arrays.sort(a);
			for (int j = 0; j < a.length; j++){
				a[i] += k;
			}
			a[a.length-1] /= 2;

		}

		for (int i = 0; i < a.length; i++){
			sum += a[i];
		}

		System.out.println(sum);


	}

	@Test
	public void test1(){
		String pattern = "\\p{Lower}+";
		String temp = "aabbcdf";
		System.out.println(temp.matches(pattern));
	}


}
