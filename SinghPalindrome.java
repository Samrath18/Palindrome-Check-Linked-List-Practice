package linklist;

public class SinghPalindrome {

	private SinghPalindrome next, previous; //Declare SinghPalindrome variables next and previous
	private String data; //Declare string variable data
	private int idx; //Declare int variable idx

	public SinghPalindrome (String data, int idx) { //Constructor
		this.data = data;
		this.idx = idx;
	}
	public String getData() { //Get method for data
		return data;
	}
	public void setData(String data) { //Set method for data
		this.data = data;
	}
	public int getIdx() { //Get method for idx
		return idx;
	}
	public void setIdx(int idx) { //Set method for idx
		this.idx = idx;
	}
	public SinghPalindrome getNext() { //Get method for next
		return next;
	}
	public void setNext(SinghPalindrome next) { //Set method for next
		this.next = next;
	}
	public SinghPalindrome getPrevious() { //Get method for previous
		return previous;
	}
	public void setPrevious(SinghPalindrome previous) { //Set method for previous
		this.previous = previous;
	}
}