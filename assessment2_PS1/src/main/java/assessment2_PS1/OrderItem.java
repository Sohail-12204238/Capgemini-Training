package assessment2_PS1;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemid")
	private long itemId;
	
	private String productName;
	private int quantity;
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderItem() {
		super();
	}

	public OrderItem(String productName, int quantity, int price) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", productName=" + productName + ", quantity=" + quantity + ", price="
				+ price + ", order=" + order + "]";
	}	
}
