package com.currencyfair.rest;

import com.currencyfair.rest.dto.TradeMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by scacun on 4/25/15.
 */
@RestController
@RequestMapping(value = "/trademessages", produces = MediaType.APPLICATION_JSON_VALUE)
class TradeMessageController {

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public TradeMessageDTO createTrade(@Valid @RequestBody TradeMessageDTO tradeMessage) {
        return tradeMessage;
    }

}
