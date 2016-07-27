package com.github.anastr.targetviewlib;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.view.View;

class BackgroundEffect extends View{

    private int color;

    public BackgroundEffect(Context context, Builder builder) {
        super(context);
        this.color = builder.getColor();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerColor = Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
        int edgeColor = Color.argb(20, Color.red(color), Color.green(color), Color.blue(color));
        RadialGradient gradient = new RadialGradient(getWidth()/2f, getHeight()/2f, getWidth()/2f
                , new int[] {centerColor, color, edgeColor}, null, android.graphics.Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setShader(gradient);
        paint.setAntiAlias(true);

        canvas.drawCircle(getWidth()/2f, getHeight()/2f, getWidth()/2f, paint);
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
