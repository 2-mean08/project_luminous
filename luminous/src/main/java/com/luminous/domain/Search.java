package com.luminous.domain;

import java.sql.Timestamp;

public class Search {


    private Long searchId; //PK

    private Long memberId; //FK
    
    private String searchContent;
    private int searchFrequency;
    private Timestamp lastSearchDate;
    


}
