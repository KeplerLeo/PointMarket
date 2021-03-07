package com.example.pointmarket.model;

import android.graphics.HardwareRenderer;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String desc;
    private String value;

    public Product() {
    }
    public Product(String name, String desc, String value) {
        this.name = name;
        this.desc = desc;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", value=" + value +
                '}';
    }
    public static List<Product> startList(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Produto 1", "Descrição", "10,00"));
        products.add(new Product("Produto 2", "Descrição", "20,00"));
        products.add(new Product("Produto 3", "Descrição", "30,00"));
        products.add(new Product("Produto 4", "Descrição", "40,00"));
        products.add(new Product("Produto 5", "Descrição", "50,00"));
        return products;
    }

}
