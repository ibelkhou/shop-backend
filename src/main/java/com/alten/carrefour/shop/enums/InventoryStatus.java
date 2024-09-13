package com.alten.carrefour.shop.enums;

public enum InventoryStatus {
    INSTOCK("INSTOCK"),
    LOWSTOCK("IN LOWSTOCK"),
    OUTOFSTOCK("OUTOFSTOCK");

    public final String label;

    public String getLabel() {
        return this.label;
    }

    private InventoryStatus(String label) {
        this.label = label;
    }
}
