
public class Utility {

	public static int hexToInt(String string) {
		if(!(string.length() >= 1 && string.length() <=6)){
			throw new IllegalArgumentException("String length should be 1-6");
		}
		if(string.matches("^([0-9][a-fA-F])")){
			throw new IllegalArgumentException(
					"String contains unsupported character");
		}
		int value = 0;
		int count = 0;
		char[] chars = string.toUpperCase().toCharArray();
		for(int i = string.length() - 1; i >= 0; i--){
			if((int)chars[i] <= 57 && (int)chars[i] >= 48){
				value += (int)(chars[i]-48)*(Math.pow(16, count++)); //*(count++*16)
			}
			else if((int) chars[i] <= 70 && (int) chars[i] >= 65){
				value += (int)(chars[i]-55)*(Math.pow(16, count++));
			}
		}
		return value;
	}
}
