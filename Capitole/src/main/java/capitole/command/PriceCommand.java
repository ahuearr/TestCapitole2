package capitole.command;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceCommand {

	@NotNull
    private Integer brandId;
	@NotNull
    private String date;
	@NotNull
    private Integer productId;
}
