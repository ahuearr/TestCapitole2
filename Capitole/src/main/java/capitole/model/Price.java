package capitole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "prices")
public class Price {

	@Id
    private int id;
	@Column(name="BRAND_ID")
    private int brandId;
	@Column(name="START_DATE")
    private String startDate;
	@Column(name="END_DATE")
    private String endDate;
	@Column(name="PRICE_LIST")
    private int priceList;
	@Column(name="PRODUCT_ID")
    private int productId;
	@Column(name="PRIORITY")
    private int priority;
	@Column(name="PRICE")
    private float price;
	@Column(name="CURR")
    private String curr;
}
