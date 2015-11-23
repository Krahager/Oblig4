import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Reader {
	BufferedReader readBuffer;
	HashMap<String, String> values = new HashMap<>();
	
	public static void main(String[] args){
		//Reader read = new Reader(null);
	}
	
	public Reader(BufferedReader in) throws IOException{
			while(in.ready()){
				String s = in.readLine();
				String[] sArray = s.split("\\s+");
				String result = Utility.bitwise(sArray[1], sArray[2], sArray[3]);
				values.put(sArray[0], sArray[0] + " " + sArray[1] + " " + sArray[2]
						+ " " + sArray[3] + " " + result);
			}
	}

	public HashMap<String, String> getHashMap() {
		return values;
	}

}
