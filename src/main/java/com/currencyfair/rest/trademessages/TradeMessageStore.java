package com.currencyfair.rest.trademessages;

import com.currencyfair.rest.trademessages.dto.TradeMessageDTO;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacun on 4/26/15.
 */
@Component
class TradeMessageStore {

    private final List<TradeMessageDTO> tradeMessages = new ArrayList<>();

    public void addTradeMessage(TradeMessageDTO tradeMessageDTO) {
        tradeMessages.add(tradeMessageDTO);
    }

    public List<TradeMessageDTO> getTradeMessages() {
        return ImmutableList.copyOf(tradeMessages);
    }

}
