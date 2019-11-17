import java.util.HashMap;
import java.util.Scanner;
public class  Duplicate{
	static Node head=null;
    public Node removeDup(Node head){
        HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
        if(head==null){
            return null;
        }
        Node currNode = head.next;
        Node prevNode = head;
        Node temp; 
        ht.put(head.data, 1);
        while(currNode!=null){
            int data = currNode.data;
            if(ht.containsKey(data)){
                prevNode.next = currNode.next;
                temp= currNode;
                currNode = currNode.next;
                temp.next = null;
            }else{
                ht.put(data, 1);
                prevNode = currNode;
                currNode = currNode.next;
            }
        } return head;
    }
    Duplicate insert(Duplicate li,int data)
	{
		Node newNode= new Node(data);
		newNode.next=null;
		if(li.head==null)
			li.head=newNode;
		else
		{
			Node last=li.head;
			while(last.next!=null)
			{
				last=last.next;
			}
			last.next=newNode;
		}
		return li;
	}
    public void display(Node head){
        Node n=head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
    }
    public static void main(String args[]){
    	Duplicate d = new Duplicate();
    	Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many elements you want to add:");
		int n=sc.nextInt();
		int j;
		System.out.println("Enter Elements:");
		for(int i=0;i<n;i++)
		{
			j=sc.nextInt();
			d.insert(d,j);
		} 
        System.out.print("Original List : ");
        d.display(head);
        System.out.print("\n Updated List: ");
        Node x =d.removeDup(head);
        d.display(x);
    }
}
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        next = null;
    }
}
