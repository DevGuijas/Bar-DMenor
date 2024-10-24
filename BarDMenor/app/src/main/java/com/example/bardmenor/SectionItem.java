package com.example.bardmenor;

import com.example.bardmenor.model.CardapioItens;

public class SectionItem {
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_SECTION = 1;

    private int type;
    private CardapioItens item;
    private String sectionTitle;

    public SectionItem(int type, CardapioItens item, String sectionTitle) {
        this.type = type;
        this.item = item;
        this.sectionTitle = sectionTitle;
    }

    public int getType() {
        return type;
    }

    public CardapioItens getItem() {
        return item;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }
}
