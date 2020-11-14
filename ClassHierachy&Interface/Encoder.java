public abstract class Encoder implements Encodable{
	// parent encoder class!
	public byte[] CodeWord(byte[] in) {
		return null;
	}
	
	protected String symbol_map;
	
	public String toString(int value) {
		return symbol_map.substring(value,value+1);
	}
	
	public String encode(byte[] in) {

		byte[] word;
		byte[] in_code = new byte[1];
		String result = "";
		for (int i = 0 ; i < in.length ; i = i+1) {
			in_code[0] = in[i];
			
			word = CodeWord(in_code);
			
			for (int j = 0 ; j < word.length ; j++) {
				result += toString(word[j]);
			}
		}
		return result;
	}
}
