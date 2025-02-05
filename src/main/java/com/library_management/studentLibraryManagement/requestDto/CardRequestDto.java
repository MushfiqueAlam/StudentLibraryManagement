package com.library_management.studentLibraryManagement.requestDto;

import com.library_management.studentLibraryManagement.enums.CardStutus;
import lombok.Data;

@Data
public class CardRequestDto {
    private CardStutus cardStutus;
    private int studentId;

    public CardStutus getCardStutus() {
        return cardStutus;
    }

    public void setCardStutus(CardStutus cardStutus) {
        this.cardStutus = cardStutus;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
