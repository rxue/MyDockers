package ruixue.rest.entity;
import java.math.BigInteger;
//import org.springframework.data.annotation.Id;

public class Shop {
	private BigInteger id;
	private String name;
	private String area;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}