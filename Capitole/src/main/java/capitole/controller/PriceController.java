package capitole.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import capitole.command.PriceCommand;
import capitole.dto.PriceDTO;
import capitole.service.PriceService;

@RestController
public class PriceController{
	
    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    @ResponseBody
    public PriceDTO getTripList(@Valid PriceCommand cmd) {
    	return priceService.getPrice(cmd);
    }

}