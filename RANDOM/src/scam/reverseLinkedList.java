package scam;

class Node
{
	private int data;
	private Node next;

	public Node(int data, Node next)
	{
		this.setData(data);
		this.setNext(next);
	}

	public int getData()
	{
		return data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public Node getNext()
	{
		return next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}
}

public class reverseLinkedList
{
	public static void main(String[] args)
	{

	}

	public static Node reverseList(Node head)
	{
		Node next = head.getNext();
		head.setNext(null);
		Node prev = head;
		while (next != null)
		{
			Node nextNext = next.getNext();
			next.setNext(prev);
			prev = next;
			next = nextNext;
		}

		return next;
	}
}
