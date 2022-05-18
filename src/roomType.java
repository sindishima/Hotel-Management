public class roomType extends Room{
	
	int price;
	String type;
	
	public roomType(String number, boolean available) {
		super(number, available);
	}
	
	public roomType(String number, boolean available,String str) {
		super(number, available);
		if(str.equals("single")) {
			setPrice(50);
			setType("Single Room");
		}
		else if(str.equals("double")){
			setPrice(100);
			setType("Double Room");
		}
		else{
			setPrice(200);
			setType("Suite");
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
 }