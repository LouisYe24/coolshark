package cn.tedu.coolshark.pojo.entity;

import java.util.Date;

public class Product {
    private Integer id;
    private String title;
    private Double price;
    private Double oldPrice;
    private Integer saleCount;
    private Integer num;
    private Integer categoryId;
    private String url;
    private Integer viewCount;
    private Date created;

    /*
    CREATE TABLE product(id INT PRIMARY KEY AUTO_INCREMENT,title VARCHAR(50),
                        price DOUBLE(10,2),old_price DOUBLE(10,2),sale_count INT,
                        num INT,category_id INT,url VARCHAR(255),view_count INT,
                        created TIMESTAMP);

    )
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", saleCount=" + saleCount +
                ", num=" + num +
                ", categoryId=" + categoryId +
                ", url='" + url + '\'' +
                ", viewCount=" + viewCount +
                ", created=" + created +
                '}';
    }
}
