import java.util.regex.Pattern;

public class Utility {
	private static final int BINARY = 0;
	private static final int HEX = 1;
	public static final String HEX_CHARS = "0123456789ABCDEF";
	public static final String BIN_CHARS = "01";
	public static final int BIN_MAXSIZE = 16777215;
	public static final int HEX_MAXSIZE = 16777215;
	public static final int BIN_MAXLENGTH = 24;
	public static final int HEX_MAXLENGTH = 6;
	private static final int ASCII_ZERO = 48;
	
	public static int hexToInt(String string) {
		checkString(string, HEX);
		int value = 0;
		int count = 0;
		char[] chars = string.toUpperCase().toCharArray();
		for (int i = string.length() - 1; i >= 0; i--) {
			value += HEX_CHARS.indexOf(chars[i]) * (Math.pow(16, count++));
		}
		return value;
	}

	public static int binToInt(String string) {
		checkString(string, BINARY);
		int value = 0;
		int count = 0;
		char[] chars = string.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			value += (BIN_CHARS.indexOf(chars[i]) * Math.pow(2, count++));
		}
		return value;
	}

	public static String intToHex(int number) {
		if (number < 0)
			throw new IllegalArgumentException("The number can't be less than 0");
		if (number > HEX_MAXSIZE)
			throw new IllegalArgumentException("Number greater than highest supported hex value."
					+ " Highest permitted value is " + HEX_MAXSIZE +", Argument was " + number);
		if (number == 0)
			return "0";
		String hexNumber = "";
		while (number > 0){
			int digit = number % 16;
			hexNumber = HEX_CHARS.charAt(digit) + hexNumber;
			number = number/16;
		}
		return hexNumber;
	}

	public static String intToBin(int number) {
		if(number>BIN_MAXSIZE)
			throw new IllegalArgumentException(
					"Number higher than 24 bits can support");
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < BIN_MAXLENGTH; i++){
			b.append(number%2);
			number=number/2;
		}
		return b.reverse().toString();
	}

	public static String bitwise(String operation, String bin1, String bin2) {
		checkString(bin1, BINARY);
		checkString(bin2, BINARY);
		
		if(operation == null)
			throw new IllegalArgumentException("Operation cannot be null");
		
		int opValue = (int)(operation.charAt(0) - ASCII_ZERO);
		switch(opValue){
			case 1:
				return bitwiseAND(bin1, bin2);
			case 2:
				return bitwiseOR(bin1, bin2);
			default:
				throw new IllegalArgumentException("Invalid Operation");
		}
	}

	private static String bitwiseOR(String bin1, String bin2) {
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < bin1.length() && i < bin2.length(); i++)
			b.append((bin1.charAt(i) == '1' || bin2.charAt(i) == '1')? 1: 0);
		return b.toString();
	}

	private static String bitwiseAND(String bin1, String bin2) {
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < bin1.length() && i < bin2.length() ; i++)
			b.append((bin1.charAt(i) == '1' && bin2.charAt(i) == '1')? 1: 0);
		return b.toString();
	}
	
	private static void checkString(String s, int type){
		if (s == null)
			throw new IllegalArgumentException("String cannot be null");
		checkLength(s, type);
		Pattern p;
		if(type == BINARY)
			p = Pattern.compile("[^01]");
		else
			p = Pattern.compile("[^0-9A-Fa-f]");
		if(p.matcher(s).find())
			throw new IllegalArgumentException("String contains illegal characters. Supported pattern is " + p.toString());
	}
	
	private static void checkLength(String s, int type){
		String a = (type == BINARY)? "Binary": "Hexadecimal";
		int length = (type == BINARY)? BIN_MAXLENGTH: HEX_MAXLENGTH;
		if (s.length() == 0)
			throw new IllegalArgumentException("Length of string cannot be 0");
		if (s.length() > length)
			throw new IllegalArgumentException(a + " string too long. Maximum supported length is " + length + ". Length was " + s.length());
	}
}
