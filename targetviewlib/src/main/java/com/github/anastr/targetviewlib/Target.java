package com.github.anastr.targetviewlib;

import android.content.Context;
import android.view.View;

public abstract class Target extends View{

    /** Width of the Target line , in Pixel*/
    protected float targetWidth;
    protected int targetColor;
    protected int rotateSide =1;

    public Target(Context context, Builder builder) {
        super(context);
        this.targetWidth = builder.getTargetWidth();
        this.targetColor = builder.getColor();
        this.rotateSide = builder.getRotateSide();
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

    public int getRotateSide() {
        return rotateSide;
    }

    protected static class Builder {
        private int color, rotateSide;
        private float targetWidth;

        Builder (float targetWidth, int color, int rotateSide){
            setTargetWidth(targetWidth)
                    .setColor(color)
                    .setRotateSide(rotateSide);
        }

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

        public int getRotateSide() {
            return rotateSide;
        }

        public Builder setRotateSide(int rotateSide) {
            this.rotateSide = rotateSide;
            return this;
        }
    }
}
