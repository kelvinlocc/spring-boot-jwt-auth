package com.devglan.model.SqlEntity;




import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String product_name;
    @Column
    private String category;
    @Column
    private String color;
    @Column
    private String level;
    @Column
    private String description;
    @Column
    private long price;
    @Column
    private long amount;
    @Column
    private String create_timestamp;
    @Column
    private String update_timestamp;
    @Column
    private String offload_timestamp;
    @Column
    private Boolean is_on_sale;
    @Column
    private String image_link;
    @Column
    private String remark;

    public String getUpdate_timestamp() {
        return update_timestamp;
    }

    public void setUpdate_timestamp(String update_timestamp) {
        this.update_timestamp = update_timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }


    @JsonProperty(value = "create_timestamp")
    public String getCreate_timestamp() {
        return create_timestamp;
    }

    @JsonIgnore
    @JsonProperty(value = "create_timestamp")
    public void setCreate_timestamp(String create_timestamp) {
        this.create_timestamp = create_timestamp;
    }

    public String getOffload_timestamp() {
        return offload_timestamp;
    }

    public void setOffload_timestamp(String offload_timestamp) {
        this.offload_timestamp = offload_timestamp;
    }

    public Boolean getIs_on_sale() {
        return is_on_sale;
    }

    public void setIs_on_sale(Boolean is_on_sale) {
        this.is_on_sale = is_on_sale;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
