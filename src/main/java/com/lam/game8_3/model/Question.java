package com.lam.game8_3.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String photo;

    private String answer;
    private String dap_an_1;
    private String dap_an_2;
    private String dap_an_3;
    private String dap_an_4;
}
