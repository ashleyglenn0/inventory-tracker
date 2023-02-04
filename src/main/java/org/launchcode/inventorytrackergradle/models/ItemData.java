package org.launchcode.inventorytrackergradle.models;

import java.util.ArrayList;

public class ItemData {

    public static ArrayList<Item> findByColumnAndValue(String column, String value, Iterable<Item> allItems) {

        ArrayList<Item> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Item>) allItems;
        }

        if (column.equals("all")){
            results = findByValue(value, allItems);
            return results;
        }
        for (Item item : allItems) {

            String aValue = getFieldValue(item, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public static String getFieldValue(Item item, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = item.getName();
        } else if (fieldName.equals("manufacturer")){
            Manufacturer manufacturer = item.getManufacturer();
            theValue = manufacturer.getName();
        } else if (fieldName.equals("description")){
            theValue = item.getDescription();
        } else if (fieldName.equals("category")) {
            theValue = item.getCategory();
        } else {
            theValue = "Invalid field name! Backend only set up to search by name, manufacturer, description, or category. ItemData, line 41.";
            System.out.println(theValue);
        }
        return theValue;
    }

    public static ArrayList<Item> findByValue(String value, Iterable<Item> allItems) {
        String lower_val = value.toLowerCase();

        ArrayList<Item> results = new ArrayList<>();

        for (Item item : allItems) {

            Manufacturer manufacturer = item.getManufacturer();

            if (item.getName().toLowerCase().contains(lower_val)) {
                results.add(item);
            } else if (manufacturer.getName().toString().toLowerCase().contains(lower_val)) {
                results.add(item);
            } else if (item.getDescription().toString().toLowerCase().contains(lower_val)) {
                results.add(item);
            } else if (item.getCategory().toString().toLowerCase().contains(lower_val)) {
                results.add(item);
            }

        }

        return results;
    }
}
