package com.company.models;

public class Items {
    Item ItemObject;


    // Getter Methods

    public Item getItem() {
        return ItemObject;
    }

    // Setter Methods

    public void setItem(Item itemObject) {
        this.ItemObject = itemObject;
    }

    @Override
    public String toString() {
        return "Items{" +
                "ItemObject=" + ItemObject +
                '}';
    }
}