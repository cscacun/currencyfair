package com.currencyfair.rest.trademessages;

import com.currencyfair.rest.trademessages.dto.TradeMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by scacun on 4/26/15.
 */
@Component
class TradeMessageFacade {

    private final TradeMessageStore tradeMessageStore;

    @Autowired
    public TradeMessageFacade(TradeMessageStore tradeMessageStore) {
        this.tradeMessageStore = tradeMessageStore;
    }

    public TradeMessageDTO createTradeMessage(TradeMessageDTO tradeMessageDTO) {
        tradeMessageStore.addTradeMessage(tradeMessageDTO);
        return tradeMessageDTO;
    }

    public List<TradeMessageDTO> getTradeMessages() {
        return tradeMessageStore.getTradeMessages();
    }

}
