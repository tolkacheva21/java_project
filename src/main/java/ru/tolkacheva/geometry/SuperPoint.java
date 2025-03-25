package ru.tolkacheva.geometry;

import java.util.ArrayList;
import java.util.List;

public class SuperPoint{
    private List<Attribute> attributeList = new ArrayList<>();

    public SuperPoint(List<Attribute> attributeList) {
        setAttributeList(attributeList);
    }

    public SuperPoint(){}

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void addAttribute(Attribute attribute){
        if (attributeList.contains(attribute)) return;
        attributeList.add(attribute);
    }
}
