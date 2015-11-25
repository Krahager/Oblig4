import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {
	private HashMap<String, Entry> values;
	private Reader reader;
	private List<Entry> duplicateValues;
	private List<String> failures;

	public Data(Reader in) throws IOException {
		reader = in;
		values = new HashMap<>();
		duplicateValues = new ArrayList<>();
		failures = new ArrayList<>();
	}

	public void read() {
		String[] sArray;
		String result = null;
		while (true) {
			String s = reader.readLine();
			if (s == null)
				return; //End of file
			sArray = s.split("\\s+");
			result = null;
			try {
				result = Utility.bitwise(sArray[1], sArray[2], sArray[3]);
				int intResult = Utility.binToInt(result);
				if (values.containsKey(sArray[0])) {
					duplicateValues.add(new Entry(sArray[0], sArray[1], sArray[2], sArray[3], result, intResult));
				} else {
					values.put(sArray[0], new Entry(sArray[0], sArray[1], sArray[2], sArray[3], result, intResult));
				}
			} catch (Exception e) {
				failures.add(s);
			}
		}
	}

	public HashMap<String, Entry> getHashMap() {
		return values;
	}

	public class Entry {
		private String hexString;
		private String operation;
		private String bin1;
		private String bin2;
		private String resultString;
		private Integer resultInt;

		public Entry(String hexString, String operation, String bin1, String bin2, String resultString, int resultInt) {
			super();
			this.hexString = hexString;
			this.operation = operation;
			this.bin1 = bin1;
			this.bin2 = bin2;
			this.resultString = resultString;
			this.resultInt = resultInt;
		}

		public String getHexString() {
			return hexString;
		}

		public String getOperation() {
			return operation;
		}

		public String getBin1() {
			return bin1;
		}

		public String getBin2() {
			return bin2;
		}

		public String getResultString() {
			return resultString;
		}

		public Integer getResultInteger() {
			return resultInt;
		}

		public String toString() {
			String s = hexString + " " + operation + " " + bin1 + " " + bin2 + " " + resultString + " " + resultInt;
			return s;
		}
	}

	public List<String> getFailures() {
		return failures;
	}

	public List<Entry> getDuplicates() {
		return duplicateValues;
	}
}
