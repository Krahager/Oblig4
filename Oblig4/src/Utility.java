import java.util.regex.Pattern;

public class Utility {
	private static final int BINARY = 0;
	private static final int HEX = 1;
	
	public static int hexToInt(String string) {
		if (!(string.length() >= 1 && string.length() <= 6)) {
			throw new IllegalArgumentException("String length should be 1-6");
		}
		checkString(string, HEX);
		int value = 0;
		int count = 0;
		char[] chars = string.toUpperCase().toCharArray();
		for (int i = string.length() - 1; i >= 0; i--) {
			if ((int) chars[i] <= 57 && (int) chars[i] >= 48) { //Between 0 and 9
				value += (int) (chars[i] - 48) * (Math.pow(16, count++));
			}
			else if ((int) chars[i] <= 70 && (int) chars[i] >= 65) { //Between A and F
				value += (int) (chars[i] - 55) * (Math.pow(16, count++));
			}
		}
		return value;
	}

	public static int binToInt(String string) {
		if (!(string.length() > 0 && string.length() <= 24))
			throw new IllegalArgumentException("Length of string should be between " + "1 and 24");
		checkString(string, BINARY);
		int value = 0;
		int count = 0;
		char[] chars = string.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			value += (int) (chars[i] - 48) * Math.pow(2, count++);
		}
		return value;
	}

	public static String intToHex(int number) {
		if (number < 0)
			throw new IllegalArgumentException("The number can't be less than 0");
		String digits = "0123456789ABCDEF";
		if (number == 0)
			return "0";
		String hexNumber = "";
		while (number > 0){
			int digit = number % 16;
			hexNumber = digits.charAt(digit) + hexNumber;
			number = number/16;
		}
		return hexNumber;
	}

	public static String intToBin(int number) {
		if(number>16777215)
			throw new IllegalArgumentException(
					"Number higher than 24 bits can support");
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < 24; i++){
			b.append(number%2);
			number=number/2;
		}
		return b.reverse().toString();
	}

	public static String bitwise(int operation, String bin1, String bin2) {
		if(!(bin1.length() <= 24 && bin2.length() <= 24))
			throw new IllegalArgumentException();
		checkString(bin1, BINARY);
		checkString(bin2, BINARY);
		switch(operation){
			case 1:
				return bitwiseAND(bin1, bin2);
			case 2:
				return bitwiseOR(bin1, bin2);
			default:
				throw new IllegalArgumentException();
		}
	}

	private static String bitwiseOR(String bin1, String bin2) {
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < bin1.length(); i++)
			b.append((bin1.charAt(i) == '1' || bin2.charAt(i) == '1')? 1: 0);
		return b.toString();
	}

	private static String bitwiseAND(String bin1, String bin2) {
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < bin1.length(); i++)
			b.append((bin1.charAt(i) == '1' && bin2.charAt(i) == '1')? 1: 0);
		return b.toString();
	}
	
	private static void checkString(String s, int type){
		Pattern p;
		if(type == BINARY)
			p = Pattern.compile("[^01]");
		else
			p = Pattern.compile("[^0-9A-Fa-f]");
		if(p.matcher(s).find())
			throw new IllegalArgumentException("String contains illegal characters"
					+ "Supported pattern is " + p.toString());
	}
}
