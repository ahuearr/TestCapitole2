package capitole.service;

import capitole.command.PriceCommand;
import capitole.dto.PriceDTO;

public interface PriceService {

	PriceDTO getPrice(PriceCommand cmd);

}
