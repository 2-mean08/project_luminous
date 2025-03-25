package com.luminous.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "FAQs")
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int faq_id;

    private String faq_title;
    private String faq_content;
    private String faq_answer;
    private String faq_category;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
