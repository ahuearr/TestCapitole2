package capitole.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capitole.command.PriceCommand;
import capitole.dto.PriceDTO;
import capitole.model.Price;
import capitole.model.repository.PriceRepository;
import capitole.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService{

	@Autowired
	PriceRepository priceRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public PriceDTO getPrice(PriceCommand cmd){
		
		List<Price> priceList = priceRepository.getPrices(cmd.getBrandId(), cmd.getProductId(), cmd.getDate());
		if(priceList.size()>0) {
			Price price = priceList.get(0);
			PriceDTO priceDTO = modelMapper.map(price, new TypeToken<PriceDTO>() {}.getType());
			return priceDTO;
		}
		return null;
	}

	
}
