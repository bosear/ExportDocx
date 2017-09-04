package com.artem;

/**
 * Created by Артём on 13.02.2017.
 */
public class Component {
    private String name;
    private String standarts;

    public Component(String name, String standarts) {
        this.name = name;
        this.standarts = standarts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandarts() {
        return standarts;
    }

    public void setStandarts(String standarts) {
        this.standarts = standarts;
    }
}
