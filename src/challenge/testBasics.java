package challenge;

public class testBasics {

	public static void testDecToBin() {
		// 0, 1, 2, 10, 15
		if (Basics.decToBin(0).equals("0000") && Basics.decToBin(1).equals("0001") &&
			Basics.decToBin(2).equals("0010") && Basics.decToBin(10).equals("1010") &&
			Basics.decToBin(15).equals("1111")) {
			System.out.println("Passed!");
		}
		else
			System.out.println("NOT passed!");
	}
	
	public static void testHexToBin() {
		// 0, 1, 9, 10, 15, 65 -> 41, 3855 -> f0f
		if (Basics.hexToBin("0").equals("0000") && Basics.hexToBin("1").equals("0001") &&
			Basics.hexToBin("9").equals("1001") && Basics.hexToBin("a").equals("1010") &&
			Basics.hexToBin("f").equals("1111") && Basics.hexToBin("41").equals("01000001") &&
			Basics.hexToBin("f0f").equals("111100001111")) {
			System.out.println("Passed!");
		}
		else
			System.out.println("NOT passed!");
	}
	
	public static void testBinToDec() {
		// "", 0, 1, 01, 1010, 000, 1111, 01000001
		if (Basics.binToDec("") == 0 && Basics.binToDec("0") == 0 && Basics.binToDec("1") == 1 && 
			Basics.binToDec("01") == 1 && Basics.binToDec("1010") == 10 && Basics.binToDec("000") == 0 && 
			Basics.binToDec("1111") == 15 && Basics.binToDec("111100001111") == 3855) {
			System.out.println("Passed!");
		}
		else
			System.out.println("NOT passed!"+Basics.binToDec("01000001"));
		
	}
	
	public static void testHexToBase64() {
		String hex = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		// 0 -> AA==; 1 -> AQ==; f -> AA==
		
		if (Basics.hexToBase64(hex).equals("SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t")
			&& Basics.hexToBase64("49276d").equals("SSdt") && Basics.hexToBase64("ff").equals("/w==")  && Basics.hexToBase64("fc").equals("/A==") 
			&& Basics.hexToBase64("0").equals("AA==") //&& Basics.hexToBase64("1").equals("AQ==") && Basics.hexToBase64("c").equals("AA==") 
			&& Basics.hexToBase64("54686520717569636b2062726f776e20666f78206a756d7073206f766572203133206c617a7920646f67732e").equals("VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wcyBvdmVyIDEzIGxhenkgZG9ncy4="))
			System.out.println("Passed!");
		else
			System.out.println("Error: " + Basics.hexToBase64("c"));
	}

	public static void main(String[] args) {
		testDecToBin();
		testHexToBin();
		testBinToDec();
		testHexToBase64();
	}

}
