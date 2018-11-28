import java.util.List;
import java.util.function.Predicate;

public class Order {
	
	private int orderId;
	private List<Item> items;
	
	public Order(int orderId, List<Item> items) {
		super();
		this.orderId = orderId;
		this.items = items;
	}
	
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	

	 


}
