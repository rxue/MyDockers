package ruixue.rest.entity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="shops")
public class Shop extends BaseEntity {
	private String country;
	private String name;
	private String area;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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