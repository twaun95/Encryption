import java.util.Scanner;

public class DoEncode {

	public static void main(String[] args) {
		
		byte[] inputdata = new byte[6];
		inputdata[0] = 0x12;
		inputdata[1] = 0x34;
		inputdata[2] = 0x56;
		inputdata[3] = 65;
		inputdata[4] = 66;
		inputdata[5] = 67;

		System.out.println("Input data: " 
		+ inputdata[0] +" "+ inputdata[1] +" "+ inputdata[2] +" " 
				+ inputdata[3] +" "+ inputdata[4] +" "+ inputdata[5] );
	
		SelectEncodeType(inputdata);
		
	}
	
	public static String Encode(byte[] inputdata, Encodable en) {
		
		String result = en.encode(inputdata);
		return result;
	}
	
	public static void SelectEncodeType(byte[] inputdata) {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("(ASCII : A, Base64 : B, Hexa : H, Binary : b, Decimal : D, Quit : q"); 

		  while(true){
			  System.out.println("=====================================================================");
			  System.out.println("Encode Type을 입력하시오"); 
			  char type = sc.next().charAt(0); // 숫자 입력 받기
		   
			  if(type == 'q'){
				  System.out.println("종료합니다");
				  break;
			  }
		   
			  else if(type == 'B'){
				  System.out.println("Encode to Base64 : " + Encode(inputdata, new Base64()));
			  }

			  else if(type == 'A'){
				  System.out.println("Encode to ASCII  : " + Encode(inputdata, new ASCII()));			   
			  }
			  
			  else if(type == 'H'){
				  System.out.println("Encode to Hex    : " + Encode(inputdata, new Hex()));
			  }
			   
			  else if(type == 'b'){
				  System.out.println("Encode to Binary : " + Encode(inputdata, new Binary()));
			  }
			   
			  else if(type == 'D'){
				  System.out.println("Encode to Decimal : " + Encode(inputdata, new Decimal())); 
			  }
		  }
		  sc.close();
	}
	
	
}
