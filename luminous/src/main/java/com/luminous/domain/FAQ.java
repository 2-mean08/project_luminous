package com.luminous.domain;

public class FAQ {

    private Long faqId; //PK

    private String faqTitle;
    private String faqContent;
    private String faqAnswer;
    private String faqCategory;

    private Long memberId; //FK
}
