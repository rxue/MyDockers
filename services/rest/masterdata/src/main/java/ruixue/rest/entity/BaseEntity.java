package ruixue.rest.entity;

import org.springframework.data.annotation.Id;

public abstract class BaseEntity {
	@Id
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
