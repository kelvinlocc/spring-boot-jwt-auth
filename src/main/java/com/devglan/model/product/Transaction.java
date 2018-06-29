package com.devglan.model.product;


import javax.persistence.*;


@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String buyer_id;
    @Column
    private String buyer_name;
    @Column
    private String create_timestamp;
    @Column
    private String status;
    @Column
    private String proudct_id;
    @Column
    private String product_name;
    @Column
    private Long price;
    @Column
    private Long amount;

    @Column
    private String dicount;
    @Column
    private boolean is_valid;
    @Column
    private String expire_timestamp;
    @Column
    private String remark;


}
