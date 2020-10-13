package com.udacity.entitiesexcercise.Entities;

import javax.persistence.Entity;

@Entity
public class Shroud extends Plant{
    private int heightCm;
    private int widthCm;

    public int getHeightCm() {
        return heightCm;
    }

    public int getWidthCm() {
        return widthCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public void setWidthCm(int widthCm) {
        this.widthCm = widthCm;
    }
}
