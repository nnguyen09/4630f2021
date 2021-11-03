package com.example.a3_secondphaseofapp;

public class Stock {
    private String amount;
    private String imgSymbol;
    private String name;

    public Stock(String amount, String imgSymbol, String name) {
        this.amount = amount;
        this.imgSymbol = imgSymbol;
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getImgSymbol() {
        return imgSymbol;
    }

    public void setImgSymbol(String imgSymbol) {
        this.imgSymbol = imgSymbol;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "amount=" + amount +
                ", imgSymbol='" + imgSymbol + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
