package com.library_management.studentLibraryManagement.convertor;

import com.library_management.studentLibraryManagement.model.Card;
import com.library_management.studentLibraryManagement.requestDto.CardRequestDto;

public class CardConvertor {

    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto){

        Card card=new Card();

        card.setCardStutus(cardRequestDto.getCardStutus());

        return card;
    }
}
