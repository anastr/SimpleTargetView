package com.github.anastr.targetviewlib;

import android.content.Context;
import android.view.View;

public abstract class Target extends View{

    /** Width of the Target line , in Pixel*/
    protected float targetWidth;
    protected int targetColor;

    public Target(Context context, Builder builder) {
        super(context);
        this.targetWidth = builder.getTargetWidth();
        this.targetColor = builder.getColor();
    }

    public void setTargetColor(int targetColor) {
        this.targetColor = targetColor;
    }

    public void setTargetWidth(float targetWidth) {
        this.targetWidth = targetWidth;
    }

    public float getTargetWidth() {
        return targetWidth;
    }

    public int getTargetColor() {
        return targetColor;
    }

    protected static class Builder {
        private int color;
        private float targetWidth;


        public float getTargetWidth() {
            return targetWidth;
        }

        public Builder setTargetWidth(float targetWidth) {
            this.targetWidth = targetWidth;
            return this;
        }

        public int getColor() {
            return color;
        }

        public Builder setColor(int color) {
            this.color = color;
            return this;
        }
    }
}
