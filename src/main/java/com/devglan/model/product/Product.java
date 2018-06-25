package com.devglan.model.product;




import javax.persistence.*;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String productName;
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
    private String createTimeStamp;
    @Column
    private String offloadTimeStamp;
    @Column
    private Boolean isOnSale;
    @Column
    private String imageLink;
    @Column
    private String remark;


    //
    @Column
    private String email;
    @Column
    private String facebookId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(String createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public String getOffloadTimeStamp() {
        return offloadTimeStamp;
    }

    public void setOffloadTimeStamp(String offloadTimeStamp) {
        this.offloadTimeStamp = offloadTimeStamp;
    }

    public Boolean getOnSale() {
        return isOnSale;
    }

    public void setOnSale(Boolean onSale) {
        isOnSale = onSale;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", level='" + level + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", createTimeStamp='" + createTimeStamp + '\'' +
                ", offloadTimeStamp='" + offloadTimeStamp + '\'' +
                ", isOnSale=" + isOnSale +
                ", imageLink='" + imageLink + '\'' +
                ", remark='" + remark + '\'' +
                ", email='" + email + '\'' +
                ", facebookId='" + facebookId + '\'' +
                '}';
    }
}
