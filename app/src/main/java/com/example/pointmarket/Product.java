package com.example.pointmarket;

public class Product {
    private String name;
    private String desc;
    private float value;
    private  boolean visib;

    public Product() {
    }
    public Product(String name, String desc, float value, boolean visib) {
        this.name = name;
        this.desc = desc;
        this.value = value;
        this.visib = visib;
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isVisib() {
        return visib;
    }

    public void setVisib(boolean visib) {
        this.visib = visib;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", value=" + value +
                ", visib=" + visib +
                '}';
    }
}
