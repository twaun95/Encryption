public class Binary  extends Encoder implements Encodable{
	public byte[] CodeWord(byte[] in) {

		byte [] word = new byte[8];
		word[0] = (byte)((in[0] & 0x80) >> 7);
		word[1] = (byte)((in[0] & 0x40) >> 6);
		word[2] = (byte)((in[0] & 0x20) >> 5);
		word[3] = (byte)((in[0] & 0x10) >> 4);
		word[4] = (byte)((in[0] & 0x08) >> 3);
		word[5] = (byte)((in[0] & 0x04) >> 2);
		word[6] = (byte)((in[0] & 0x02) >> 1);
		word[7] = (byte)((in[0] & 0x01) >> 0);
		
		return word;
	}
	
	Binary() {
		symbol_map = new String("01");
	}
	
}
