import java.util.regex.Pattern;

public class Utility {

	public static int hexToInt(String string) {
		if (!(string.length() >= 1 && string.length() <= 6)) {
			throw new IllegalArgumentException("String length should be 1-6");
		}
		Pattern pattern = Pattern.compile("[^0-9A-Fa-f]");
		if (pattern.matcher(string).find()) {
			throw new IllegalArgumentException(
					"String contains unsupported character");
		}
		int value = 0;
		int count = 0;
		char[] chars = string.toUpperCase().toCharArray();
		for (int i = string.length() - 1; i >= 0; i--) {
			if ((int) chars[i] <= 57 && (int) chars[i] >= 48) {
				value += (int) (chars[i] - 48) * (Math.pow(16, count++)); // *(count++*16)
			}
			else if ((int) chars[i] <= 70 && (int) chars[i] >= 65) {
				value += (int) (chars[i] - 55) * (Math.pow(16, count++));
			}
		}
		return value;
	}

	public static int binToInt(String string) {
		if (!(string.length() > 0 && string.length() <= 24))
			throw new IllegalArgumentException("Length of string should be between " + "1 and 24");
		
		Pattern pattern = Pattern.compile("[^01]");
		if (pattern.matcher(string).find())
			throw new IllegalArgumentException("String should only contain 0 and 1");
		
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
}
