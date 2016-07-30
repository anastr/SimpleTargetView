package com.github.anastr.targetviewlib;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.view.View;

class BackgroundEffect extends View{

    private int color;
    private int centerColor, edgeColor;
    private Paint paint;

    public BackgroundEffect(Context context, Builder builder) {
        super(context);
        this.color = builder.getColor();
        init();
    }

    private void init() {
        centerColor = Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
        edgeColor = Color.argb(20, Color.red(color), Color.green(color), Color.blue(color));

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RadialGradient gradient = new RadialGradient(getWidth() / 2f, getHeight() / 2f, getWidth() / 2f
                , new int[]{centerColor, color, edgeColor}, null, android.graphics.Shader.TileMode.CLAMP);
        paint.setShader(gradient);

        canvas.drawCircle(getWidth()/2f, getHeight()/2f, getWidth()/2f, paint);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        centerColor = Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
        edgeColor = Color.argb(20, Color.red(color), Color.green(color), Color.blue(color));
    }

    static class Builder {
        private int color;

        public int getColor() {
            return color;
        }

        public Builder setColor(int color) {
            this.color = color;
            return this;
        }
    }
}
