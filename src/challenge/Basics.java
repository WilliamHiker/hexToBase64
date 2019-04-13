package challenge;

public class Basics {
	
	public static String hexToBin(String hex) {
		String alpha16 = "0123456789abcdef";
		String res = "";
		for (int i = 0; i < hex.length(); i++) {
			int dec = alpha16.indexOf(hex.charAt(i));
			res += decToBin(dec);
		}
		return res;
	}
	
	public static String decToBin(int dec) {
		// dec range: [0, 14]
		String res = "";
		while (dec > 0) {
			res = dec%2 + res;
			dec /= 2;
		}
		while (res.length() < 4)
			res = "0"+res;
		return res;
	}
	
	public static int binToDec(String bin) {
		int res = 0, pow = 1;
		for (int i = bin.length() - 1; i >= 0; i--) {
			if (bin.charAt(i) == '1')
				res += pow;
			pow *= 2;
		}
		return res;
	}
	
	public static String hexToBase64(String hex) {
		String bin = hexToBin(hex),
			   alpha64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",
			   res = "";
		while (bin.length() >= 24) {
			for (int i = 0; i < 4; i++) {
				int dec = binToDec(bin.substring(0, 6));
				res += alpha64.charAt(dec);
				bin = bin.substring(6);
			}
		}
		if (bin.length() > 0) {
			int counter = 0;
			while (bin.length() < 24) {
				bin += 0;
				counter++;
			}
			for (int i = 0; i < 4; i++) {
				int dec = binToDec(bin.substring(0, 6));
				if (dec > 0 || bin.length() > counter || bin.length() > 12)
					res += alpha64.charAt(dec);
				else
					res += '=';
				bin = bin.substring(6);
			}
		}
		return res;
	}

}
