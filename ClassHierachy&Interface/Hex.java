public class Hex extends Encoder implements Encodable{
	public byte[] CodeWord(byte[] in) {
		byte [] word = new byte[2];
		word[0] = (byte)((in[0] & 0xf0) >> 4);
		word[1] = (byte)((in[0] & 0xf));
		
		return word;
	}
	
	Hex() {
		symbol_map = new String("0123456789ABCDEF");
	}

}
