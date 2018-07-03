 package com.devglan.model.SqlEntity;


import javax.persistence.*;


@Entity
public class PreOrder {

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
    private String last_update_timestamp;
    @Column
    private String status;
    @Column
    private String product_id;
    @Column
    private String product_cate;
    @Column
    private String product_name;
    @Column
    private Long price;
    @Column
    private Long amount;

    @Column
    private String discount;
    @Column
    private boolean is_valid;
    @Column
    private String expire_timestamp;

    // pick up
    // face to face
    // ATM
    @Column
    private String payment_type;
    @Column
    private String transaction_timestamp;
    @Column
    private String transaction_location;
    @Column
    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLast_update_timestamp() {
        return last_update_timestamp;
    }

    public void setLast_update_timestamp(String last_update_timestamp) {
        this.last_update_timestamp = last_update_timestamp;
    }

    public String getCreate_timestamp() {
        return create_timestamp;
    }

    public void setCreate_timestamp(String create_timestamp) {
        this.create_timestamp = create_timestamp;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_cate() {
        return product_cate;
    }

    public void setProduct_cate(String product_cate) {
        this.product_cate = product_cate;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public boolean isIs_valid() {
        return is_valid;
    }

    public void setIs_valid(boolean is_valid) {
        this.is_valid = is_valid;
    }

    public String getExpire_timestamp() {
        return expire_timestamp;
    }

    public void setExpire_timestamp(String expire_timestamp) {
        this.expire_timestamp = expire_timestamp;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getTransaction_timestamp() {
        return transaction_timestamp;
    }

    public void setTransaction_timestamp(String transaction_timestamp) {
        this.transaction_timestamp = transaction_timestamp;
    }

    public String getTransaction_location() {
        return transaction_location;
    }

    public void setTransaction_location(String transaction_location) {
        this.transaction_location = transaction_location;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
