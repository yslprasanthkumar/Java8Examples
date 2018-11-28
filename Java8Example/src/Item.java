import java.math.BigDecimal;
import java.util.function.Predicate;

public class Item {
	
	private int itemId;
	private String name;
    private int qty;
    private BigDecimal price;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	private boolean available=false;
	public Item(int itemId, boolean available) {
		super();
		this.itemId = itemId;
		this.available = available;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	} 
	
	
	 public static Predicate<Item> isItemAvailable() {
	        return p->p.isAvailable()==true;
	    }
	public Item(String name, int qty, BigDecimal price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

}
