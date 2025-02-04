package com.library_management.studentLibraryManagement.requestDto;

import com.library_management.studentLibraryManagement.enums.CardStutus;
import lombok.Data;

@Data
public class CardRequestDto {
    private CardStutus cardStutus;
    private int studentId;
}
