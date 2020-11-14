public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		private Object data;
		private Object data2;
		private Node next;
		public Node(Object input, Object input2) {
			this.data = input;
			this.data2 = input2;
			this.next = null;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}

	//처음에 추가
	public void addFirst(Object input, Object input2) {
		Node newNode = new Node(input, input2);
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	
	//끝에 추가
	public void addLast(Object input, Object input2) {
		Node newNode = new Node(input, input2);
		if(size == 0) {
			addFirst(input, input2);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}	
	}
	
	//몇번째 노드를 불러올 때
	public Node node(int index) {
		Node x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	
	//특정한 위치에 넣을 때
	public void add(int k, Object input, Object input2) {//k는 인덱스
		if(k == 0) {
			addFirst(input, input2);
		} else {//바꿀위치의 노드와 그 전 노드를 알아야 함
			Node temp1 = node(k-1);//전 노드, node(k-1)은 바로 위 함수
			Node temp2 = temp1.next;//바꿀위치 노드
			Node newNode = new Node(input, input2);//새로 들어올 노드
			temp1.next = newNode;//전 노드를 새 노드에 연결
			newNode.next = temp2;//새 노드를 바꿀위치 노드에 연결
			size++;
			if(newNode.next == null) { // tail에 새노드를 추가 한다고 했을 때
				tail = newNode;
			}
		}	
	}
	
	//데이터값 출력
	public String toString() {
		if(head == null) { //아무것도 없다면
			return "할당 중인 메모리가 없습니다.";
		}
		Node temp = head;
		String str = "할당중인 메모리 영역: ["; //출력의 시작
	
		while(temp.next != null) {//tail 전까지
			str += "<0x" + temp.data + ", 0x" + temp.data2 + ">, ";
			temp = temp.next; 
		}
		str += "<0x" + temp.data + ", 0x" + temp.data2 + ">"; //tail에 대하여
		
		return str+"]";
	}
	
	//첫 노드 삭제
	public Object removeFirst() {
		Node temp = head;
		head = head.next; //head는 첫번째거 그다음것을 head로 지정
		Object returnData = temp.data;//지울 노드의 값 리턴
		temp = null;
		size--;
		return returnData;
	}
	
	//특정 노드 삭제
	public Object remove(int k) {
		if(k == 0) {//head지울떄
			return removeFirst();
		}
		Node temp = node(k-1);//지울 노드의 전 노드
		Node todoDeleted = temp.next;//지울 노드
		temp.next = temp.next.next;
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail) {		//tail을 지울 경우 tail은 삭제하기 전 노드를 가리킴
			tail = temp; //tail은 그전 노드를 가리키도록
		}
		todoDeleted = null;
		size--;
		
		return returnData;
	}
	
	//마지막노드 삭제
	public Object removeLast() {
		return remove(size-1);//size-1이 tail의 전 노드에 해당
	}
	
	//총 size
	public int size() {
		return size;
	}
	
	//시작 주소
	public Object start(int k) {
		Node temp = node(k);
		return temp.data;
	}
	
	//끝 주소
	public Object end(int k) {
		Node temp = node(k);
		return temp.data2;
	}

	//특정한 데이터가 어떤 위치에 있는지
	/*public int idexof(Object data) {
		Node temp = head;
		int index = 0;
		while(temp.data != data) {//데이터를 찾을 때 까지
			temp = temp.next;
			index++;
			
			if(temp == null) {
				return -1; //while문 종료
			}
		}
		return index;
	}
	*/	
}








