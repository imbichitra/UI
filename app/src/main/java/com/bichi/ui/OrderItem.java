package com.bichi.ui;

public class OrderItem {
    private String orderNumber;
    private boolean isNew;
    private String date;
    private int image;
    private int price;
    private String status;

    public OrderItem(String orderNumber, boolean isNew, String date, int image, int price, String status) {
        this.orderNumber = orderNumber;
        this.isNew = isNew;
        this.date = date;
        this.image = image;
        this.price = price;
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
