package com.library_management.studentLibraryManagement.requestDto;

import com.library_management.studentLibraryManagement.enums.Category;
import lombok.Data;

@Data
public class BookRequestDto {
    private String title;
    private int pages;
    private String publisherName;
    private String publishDate;
    private Category category;
    private boolean availability;
    private String rackNo;
    private int cardId;
    private int authorId;
}
