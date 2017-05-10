package easy;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class CandidateCode {

	/*public static int nochange_bits(String input1, int input2, int input3) {
		if (input2 <= 0 || input3 <= 0 ) {
			return -1;
		}

		int input11 = Integer.parseInt(input1, 2);
		int n = input11;

		for (int i = input2 - 1; i < input1.length(); i += input2) {
			input11 = input11 ^ (1 << i);

			System.out.println(input11);
		}
		for (int i = input3 - 1; i < input1.length(); i += input3) {
			input11 = input11 ^ (1 << i);

			System.out.println(input11);
		}
		String output = Integer.toBinaryString(input11);
		int count = 0;
		for (int j = 0; j < input1.length(); j++) {
			if (input1.charAt(j) == output.charAt(j)) {
				count++;
				System.out.println(count);
			}
		}
		return count;

	}*/
	
	 public static int nochange_bits(String input1,int input2,int input3)
	    {	
		    if (input2 <= 0 || input3 <= 0 || input2>input1.length()||input3>input1.length()) {
				return -1;
			}

			int input11 = Integer.parseInt(input1, 2);

			for (int i = input2 - 1; i < input1.length(); i += input2) {
				input11 = input11 ^ (1 << i);
			}
			for (int i = input3 - 1; i < input1.length(); i += input3) {
				input11 = input11 ^ (1 << i);
			}
			String output = Integer.toBinaryString(input11);
			int count = 0;
			for (int j = 0; j < input1.length(); j++) {
				if (input1.charAt(j) == output.charAt(j)) {
					count++;
				}
			}
			return count;
	    }

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int output = 0;
		String ip1 = in.nextLine().trim();
		int ip2 = Integer.parseInt(in.nextLine().trim());
		int ip3 = Integer.parseInt(in.nextLine().trim());
		output = nochange_bits(ip1, ip2, ip3);
		System.out.println(String.valueOf(output));

	}
}
