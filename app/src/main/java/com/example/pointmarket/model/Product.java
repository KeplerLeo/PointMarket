package com.example.pointmarket.model;

import android.graphics.HardwareRenderer;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private String desc;
    private Double value;

    public Product() {
    }
    public Product(String name, String desc, Double value) {
        this.name = name;
        this.desc = desc;
        this.value = value;
    }

    public Product(String id, String name, String desc, Double value) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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
        products.add(new Product("Produto 1", "Descrição", 10.00));
        products.add(new Product("Produto 2", "Descrição", 20.00));
        products.add(new Product("Produto 3", "Descrição", 30.00));
        products.add(new Product("Produto 4", "Descrição", 40.00));
        products.add(new Product("Produto 5", "Descrição", 50.00));
        return products;
    }

}
