package capitole.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceDTO {

    private int brandId;
    private String startDate;
    private String endDate;
    private int priceList;
    private int productId;
    private float price;
    private String curr;
}
