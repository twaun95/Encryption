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

	//ó���� �߰�
	public void addFirst(Object input, Object input2) {
		Node newNode = new Node(input, input2);
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	
	//���� �߰�
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
	
	//���° ��带 �ҷ��� ��
	public Node node(int index) {
		Node x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	
	//Ư���� ��ġ�� ���� ��
	public void add(int k, Object input, Object input2) {//k�� �ε���
		if(k == 0) {
			addFirst(input, input2);
		} else {//�ٲ���ġ�� ���� �� �� ��带 �˾ƾ� ��
			Node temp1 = node(k-1);//�� ���, node(k-1)�� �ٷ� �� �Լ�
			Node temp2 = temp1.next;//�ٲ���ġ ���
			Node newNode = new Node(input, input2);//���� ���� ���
			temp1.next = newNode;//�� ��带 �� ��忡 ����
			newNode.next = temp2;//�� ��带 �ٲ���ġ ��忡 ����
			size++;
			if(newNode.next == null) { // tail�� ����带 �߰� �Ѵٰ� ���� ��
				tail = newNode;
			}
		}	
	}
	
	//�����Ͱ� ���
	public String toString() {
		if(head == null) { //�ƹ��͵� ���ٸ�
			return "�Ҵ� ���� �޸𸮰� �����ϴ�.";
		}
		Node temp = head;
		String str = "�Ҵ����� �޸� ����: ["; //����� ����
	
		while(temp.next != null) {//tail ������
			str += "<0x" + temp.data + ", 0x" + temp.data2 + ">, ";
			temp = temp.next; 
		}
		str += "<0x" + temp.data + ", 0x" + temp.data2 + ">"; //tail�� ���Ͽ�
		
		return str+"]";
	}
	
	//ù ��� ����
	public Object removeFirst() {
		Node temp = head;
		head = head.next; //head�� ù��°�� �״������� head�� ����
		Object returnData = temp.data;//���� ����� �� ����
		temp = null;
		size--;
		return returnData;
	}
	
	//Ư�� ��� ����
	public Object remove(int k) {
		if(k == 0) {//head���
			return removeFirst();
		}
		Node temp = node(k-1);//���� ����� �� ���
		Node todoDeleted = temp.next;//���� ���
		temp.next = temp.next.next;
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail) {		//tail�� ���� ��� tail�� �����ϱ� �� ��带 ����Ŵ
			tail = temp; //tail�� ���� ��带 ����Ű����
		}
		todoDeleted = null;
		size--;
		
		return returnData;
	}
	
	//��������� ����
	public Object removeLast() {
		return remove(size-1);//size-1�� tail�� �� ��忡 �ش�
	}
	
	//�� size
	public int size() {
		return size;
	}
	
	//���� �ּ�
	public Object start(int k) {
		Node temp = node(k);
		return temp.data;
	}
	
	//�� �ּ�
	public Object end(int k) {
		Node temp = node(k);
		return temp.data2;
	}

	//Ư���� �����Ͱ� � ��ġ�� �ִ���
	/*public int idexof(Object data) {
		Node temp = head;
		int index = 0;
		while(temp.data != data) {//�����͸� ã�� �� ����
			temp = temp.next;
			index++;
			
			if(temp == null) {
				return -1; //while�� ����
			}
		}
		return index;
	}
	*/	
}








