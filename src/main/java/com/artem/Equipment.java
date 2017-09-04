package com.artem;

import java.util.List;

/**
 * Created by Артём on 13.02.2017.
 */
public class Equipment {
    private String name;
    private String methodsOfInspection;
    private String typeOfControl;
    private String meansMeasurement;
    private String guarantee;
    private String fiatOfLabeling;
    private String note;
    private List<Component> list;

    public Equipment(String name, String methodsOfInspection, String typeOfControl, String meansMeasurement, String guarantee, String fiatOfLabeling, String note, List<Component> list) {
        this.name = name;
        this.methodsOfInspection = methodsOfInspection;
        this.typeOfControl = typeOfControl;
        this.meansMeasurement = meansMeasurement;
        this.guarantee = guarantee;
        this.fiatOfLabeling = fiatOfLabeling;
        this.note = note;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethodsOfInspection() {
        return methodsOfInspection;
    }

    public void setMethodsOfInspection(String methodsOfInspection) {
        this.methodsOfInspection = methodsOfInspection;
    }

    public String getTypeOfControl() {
        return typeOfControl;
    }

    public void setTypeOfControl(String typeOfControl) {
        this.typeOfControl = typeOfControl;
    }

    public String getMeansMeasurement() {
        return meansMeasurement;
    }

    public void setMeansMeasurement(String meansMeasurement) {
        this.meansMeasurement = meansMeasurement;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getFiatOfLabeling() {
        return fiatOfLabeling;
    }

    public void setFiatOfLabeling(String fiatOfLabeling) {
        this.fiatOfLabeling = fiatOfLabeling;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Component> getList() {
        return list;
    }

    public void setList(List<Component> list) {
        this.list = list;
    }
}
