package com.currencyfair.rest.trademessages;

import com.currencyfair.rest.trademessages.dto.TradeMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by scacun on 4/25/15.
 */
@RestController
@RequestMapping(value = "/trademessages", produces = MediaType.APPLICATION_JSON_VALUE)
class TradeMessageController {

    private final TradeMessageFacade tradeMessageFacade;

    @Autowired
    TradeMessageController(TradeMessageFacade tradeMessageFacade) {
        this.tradeMessageFacade = tradeMessageFacade;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public TradeMessageDTO createTrade(@Valid @RequestBody TradeMessageDTO tradeMessage) {
        return tradeMessageFacade.createTradeMessage(tradeMessage);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TradeMessageDTO> getTradeMessages() {
        return tradeMessageFacade.getTradeMessages();
    }

}
