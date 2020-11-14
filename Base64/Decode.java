import java.io.IOException;
import java.util.Scanner;

public class Decode {

	public static int base64(char input) {
		char base64[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/'};
		String base_64 = new String(base64);
		String base_input = Character.toString(input);
		
		int result = base_64.indexOf(base_input);
		
		return result;
	}
	
	public static String decode(String input) {
		
		char[] data = input.toCharArray();
		int[] bytes = new int[data.length];
		String[] symbol = new String[data.length];

		int index = 0;
		int first = 0;
		int second = 0;
		int third = 0;
		int fourth = 0;
		boolean make_addBit = false;
		String result = "";
		
		for(int i=0; i<data.length; i++) {
			bytes[i] = base64(data[i]);
		}

		for(int i=0; i<bytes.length; i++) {
			if(i%4 == 0) {
				first = bytes[i];

				if(i == data.length-1) {
					make_addBit = true;
				}
			}
			else if(i%4 == 1) {
				second = bytes[i];

				if(i == data.length-1) {
					make_addBit = true;
				}
			}
			else if(i%4 == 2) {
				third = bytes[i];

				if(i == data.length-1) {
					make_addBit = true;
				}
			}
			else if(i%4 == 3) {
				fourth = bytes[i];
				make_addBit = true;
			}
			
			if(make_addBit) {
				int addBit = (first<<18)+(second<<12)+(third<<6)+fourth;
				
				int k3 = (addBit&0xff);
				int k2 = ((addBit>>8)&0xff);
				int k1 = ((addBit>>16)&0xff);
				
				char encode_k1 = (char)k1;
				char encode_k2 = (char)k2;
				char encode_k3 = (char)k3;
				
				String str_k1 = Character.toString(encode_k1);
				String str_k2 = Character.toString(encode_k2);
				String str_k3 = Character.toString(encode_k3);
				String str_add = str_k1 + str_k2 + str_k3;
				
				symbol[index] = str_add;
				index++;
			
				first = 0;
				second = 0;
				third = 0;
				fourth = 0;
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
		System.out.println("BASE64값 입력:");
		String input = scanner.nextLine();
		
		if(input.length() == 1) {
			System.out.println("Base64인코딩된 문자가 아닙니다. 바르게 입력해주세요.");
		}
		else {
			String decode_result = decode(input);
			System.out.printf("디코딩 결과: '%s'", decode_result);
		}
		scanner.close();		
	}

}
