package com.github.anastr.targetviewlib;

import android.content.Context;
import android.view.View;

public class Target extends View{
    protected int color;
    protected float targetWidth;

    public Target(Context context, Builder builder) {
        super(context);
        this.targetWidth = builder.getTargetWidth();
        this.color = builder.getColor();
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
