import java.util.Scanner;

public class MemoryManger {
	public static void memory_manage(int linenum) {
		
		LinkedList resourceMap = new LinkedList();
		int start_address = 0;  
		int end_address = 0;	
		
		String[] input = new String[linenum];
		Scanner operation  = new Scanner(System.in);
		
		for(int i=0; i<linenum; i++) {	

			System.out.print("free 가능한 line: ");
			
			for(int t=1; t<resourceMap.size()+1; t++) {
				System.out.print(t+" ");
			}
			
			System.out.println("\rOperation 입력: ");
			String str_input = operation.nextLine();
			System.out.println("================================================================================");
			
			input[i] = str_input;
			char input_mode = input[i].charAt(0);
			
			int idx = input[i].indexOf(" ");
			String input_value =input[i].substring(idx+1);
			
				if(input_mode == '-') {
						int free_line = Integer.parseInt(input_value);
					
						if(resourceMap.node(free_line-1) != null) {
							resourceMap.remove(free_line-1);
							System.out.println(resourceMap);
						}
						else {			
							System.out.println("free할 위치가 잘못됬습니다.\r");
							System.out.println(resourceMap);
						}
				}

				else if(input_mode == '+') {
						String oper2_hexstr = input_value.substring(2);
						int malloc_size = Integer.parseInt(oper2_hexstr,16);
		
						if(resourceMap.node(0) == null){
							start_address = 0;
							end_address = start_address + malloc_size;
							resourceMap.addLast(Integer.toHexString(start_address), Integer.toHexString(end_address));
							start_address = end_address + 1;
							System.out.println(resourceMap);
						} 	 
						
						else if((Integer.valueOf((String)resourceMap.start(0)) != 0) 
								&& (Integer.valueOf((String)resourceMap.start(0)) > malloc_size)){
							
							resourceMap.addFirst(Integer.toHexString(0), Integer.toHexString(malloc_size));
							System.out.println(resourceMap);
						}
				
						else if(resourceMap.size() > 1){
								int satis = 0;
								
								for(int k=0; k<resourceMap.size()-1; k++) {
									
									if((Integer.valueOf((String)resourceMap.end(k))+1) != (Integer.valueOf((String)resourceMap.start(k+1)))  
											&& ((Integer.valueOf((String)resourceMap.start(k+1)) - Integer.valueOf((String)resourceMap.end(k))-1) > malloc_size)){
										
										int a = Integer.valueOf((String)resourceMap.end(k)) + 1;
										int b = Integer.valueOf((String)resourceMap.end(k)) + 1+ malloc_size;
										resourceMap.add(k+1, Integer.toHexString(a), Integer.toHexString(b));
										System.out.println(resourceMap);
										satis++;
										break;
									}
								}
								
								if(satis == 0) {
									end_address = start_address + malloc_size;
									resourceMap.addLast(Integer.toHexString(start_address), Integer.toHexString(end_address));
									start_address = end_address + 1;
									System.out.println(resourceMap);
								}		
						}
						
						else {	
							end_address = start_address + malloc_size;
							resourceMap.addLast(Integer.toHexString(start_address), Integer.toHexString(end_address));
							start_address = end_address + 1;
							System.out.println(resourceMap);
						}
				}
		}
		operation.close();
		System.out.println("\r최종 " + resourceMap);
	}
	
	public static int get_line(Scanner linenum) {
		
		System.out.println("라인수 입력:");
		String input_line = linenum.nextLine();
		int line = Integer.parseInt(input_line);
		
		return line;
	}
	
	public static void main(String[] args) {
		
		Scanner number  = new Scanner(System.in);
		int line = get_line(number);
		
		System.out.println("입력방식 => malloc: (+ malloc_size), free: (- line)\r");
		memory_manage(line);
		number.close();
	}
}

