package com.luminous.domain;

import java.sql.Timestamp;

public class Notice {

    private Long noticeId; //PK

    private Long memberId; //FK
    private Long imageId; //FK

    private String noticeTitle;
    private String noticeContent;
    private Timestamp noticeDate;

}
