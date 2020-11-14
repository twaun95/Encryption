import java.io.IOException;
import java.util.Scanner;

public class Encode {
	
	public static char base64(int input) {
		char base64[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/'};
		char result = base64[input];
		return result;
	}
	
	public static String encode(String input) {
		char[] data = input.toCharArray();
		byte[] bytes = new byte[data.length];
		String[] symbol = new String[data.length];
		
		int index = 0;
		byte first = 0;
		byte second = 0;
		byte third = 0;
		boolean make_addBit = false;
		String result = "";
		
		for(int i=0; i<data.length; i++) {
			bytes[i] = (byte)data[i];
		}

		for(int i=0; i<bytes.length; i++) {
			if(i%3 == 0) {
				first = bytes[i];
				
				if(i == data.length-1) {
					make_addBit = true;
				}
			}
			else if(i%3 == 1) {
				second = bytes[i];
				
				if(i == data.length-1) {
					make_addBit = true;
				}
			}
			else if(i%3 == 2) {
				third = bytes[i];
				make_addBit = true;
			}
			
			if(make_addBit) {
				int addBit = (first<<16)+(second<<8)+third;

				int k4 = (addBit&0x3f);
				int k3 = ((addBit>>6)&0x3f);
				int k2 = ((addBit>>12)&0x3f);
				int k1 = ((addBit>>18)&0x3f);
				
				char encode_k1 = base64(k1);
				char encode_k2 = base64(k2);
				char encode_k3 = base64(k3);
				char encode_k4 = base64(k4);
				
				if((i == data.length-1) && (base64(k3)=='A') && (base64(k4)=='A')){
					encode_k3 = '=';
					encode_k4 = '=';
				}
				if((i == data.length-1) && (base64(k4)=='A')){
					encode_k4 = '=';	
				}				
				
				String str_k1 = Character.toString(encode_k1);
				String str_k2 = Character.toString(encode_k2);
				String str_k3 = Character.toString(encode_k3);
				String str_k4 = Character.toString(encode_k4);
				String str_add = str_k1 + str_k2 + str_k3 + str_k4;
				
				symbol[index] = str_add;
				index++;
			
				first = 0;
				second = 0;
				third = 0;
				make_addBit = false;
			}
		}
	
		for(int i=0; i<index; i++) {
			result = result + symbol[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException{							
		Scanner scanner  = new Scanner(System.in);
		System.out.println("아스키값 입력:");
		String input = scanner.nextLine();
		
		String encode_result = encode(input);
		System.out.printf("인코딩 결과: '%s'", encode_result);
		scanner.close();		
	}
	
}
