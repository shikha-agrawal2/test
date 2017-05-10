package medium;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.naming.CommunicationException;

public class CandidateCode {
	/*
	 * Complete the function below.
	 */
	public static String[] getHorizon(String[] input1) {
		List list1 = Arrays.asList(input1);
		Collections.sort(list1, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.charAt(0) - o2.charAt(0);
			}
		});
		String[] inputSorted = (String[]) list1.toArray();
		String[] output = new String[input1.length + 3];
		output[0] = new StringBuilder().append(inputSorted[0].charAt(0)).append("#0").toString();
		// System.out.println("o"+output[0]);
		int k = 0, l = 0;
		int[] rightcoordiante = new int[input1.length];
		// rightcoordiante[0] = inputSorted[0].charAt(4);
		// System.out.println("r"+rightcoordiante[0]);
		for (int i = 0; i < inputSorted.length; i++) {
			// System.out.println("oooo"+inputSorted[i].charAt(0)+inputSorted[i].charAt(1)+inputSorted[i].charAt(2)+inputSorted[i].charAt(3)+inputSorted[i].charAt(4));
			if (!(inputSorted[i].charAt(0) == inputSorted[i].charAt(4)) && inputSorted[i].charAt(2) != 0) {
				if (inputSorted.length > 1) {
					int height = 0;
					boolean checkrightcoordinate = false;
					if (i > 0) {
						for (int j = 0; j < rightcoordiante.length; j++) {
							int max;

							if (rightcoordiante[j] > inputSorted[i].charAt(4)) {
								checkrightcoordinate = true;
								max = rightcoordiante[j];
								// System.out.println("max" + max);
								if (inputSorted[j].charAt(4) == max) {
									height = inputSorted[j].charAt(3);
									// System.out.println("height" + height);
								}
							}

						}
					}
					rightcoordiante[k++] = inputSorted[i].charAt(4);
					if (i < input1.length - 1) {
						if (inputSorted[i].charAt(4) < inputSorted[i + 1].charAt(0)) {
							if (checkrightcoordinate) {
								System.out.println("inside"+checkrightcoordinate+height);
								output[++l] = new StringBuilder().append(inputSorted[i].charAt(4)).append("#")
										.append(height).toString();
							} else {
								output[++l] = new StringBuilder().append(inputSorted[i].charAt(4)).append("#0")
										.toString();
							}
						}
						if (inputSorted[i].charAt(4) > inputSorted[i + 1].charAt(0)) {
							if (inputSorted[i].charAt(4) < inputSorted[i + 1].charAt(4)) {
									if (inputSorted[i].charAt(2) > inputSorted[i + 1].charAt(2)) {
										output[++l] = new StringBuilder().append(inputSorted[i].charAt(4)).append("#")
											.append(inputSorted[i + 1].charAt(2)).toString();
									} else {
										output[++l] = new StringBuilder().append(inputSorted[i].charAt(0)).append("#")
											.append(inputSorted[i].charAt(2)).toString();
								}
							}
							
							output[++l] = new StringBuilder().append(inputSorted[i].charAt(0)).append("#")
									.append(inputSorted[i].charAt(2)).toString();
						}
						if (inputSorted[i].charAt(4) == inputSorted[i + 1].charAt(0)) {
							output[++l] = new StringBuilder().append(inputSorted[i].charAt(0)).append("#")
									.append(inputSorted[i].charAt(2)).toString();
						}
					} else {
						output[++l] = new StringBuilder().append(inputSorted[i].charAt(0)).append("#")
								.append(inputSorted[i].charAt(2)).toString();
					}

				} else {
					output[++l] = new StringBuilder().append(inputSorted[i].charAt(0)).append("#")
							.append(inputSorted[i].charAt(2)).toString();
				}
			}
		}
		output[++l] = new StringBuilder().append(inputSorted[inputSorted.length - 1].charAt(4)).append("#0").toString();
		return output;
		// Write code here
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String[] output = null;
		int ip1_size = 0;
		ip1_size = Integer.parseInt(in.nextLine().trim());
		String[] ip1 = new String[ip1_size];
		String ip1_item;
		for (int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
			try {
				ip1_item = in.nextLine();
			} catch (Exception e) {
				ip1_item = null;
			}
			ip1[ip1_i] = ip1_item;
		}
		output = getHorizon(ip1);
		for (int output_i = 0; output_i < output.length; output_i++) {
			System.out.println(String.valueOf(output[output_i]));
		}
	}
}
