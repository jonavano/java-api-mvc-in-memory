package com.booleanuk.api;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private ArrayList<Item> items;

    public ItemRepository(){
        this.items = new ArrayList<>();
        items.add(new Item("bible", "book", 300));
        items.add(new Item("Bitcoin whitepaper", "whitepaper", 0));
        items.add(new Item("gulag archipelico", "Book", 30));
        items.add(new Item("コンビ二人間", "本", 5));
    }

    public ArrayList<Item> getAll() {
        return this.items;
    }

    public Item getOne(int id) {
        return this.items.stream().filter(
                item -> item.getId() == id
        ).findFirst().orElse(null);
    }

    public Item remove(int id) {
        Item item = this.items.stream().filter(
                item1 -> item1.getId() == id
        ).findFirst().orElse(null);
        this.items.remove(item);
        return item;
    }

    public Item add(Item item) {
        this.items.add(item);
        return item;
    }

    public Item update(int id, Item item) {
        Item toUpdate = getOne(id);
        if (toUpdate == null)
            return null;
        toUpdate.setName(item.getName());
        toUpdate.setCategory(item.getCategory());
        toUpdate.setPrice(item.getPrice());
        return toUpdate;
    }
}
