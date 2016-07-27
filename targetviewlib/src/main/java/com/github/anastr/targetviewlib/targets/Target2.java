package com.github.anastr.targetviewlib.targets;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.github.anastr.targetviewlib.Target;

public class Target2 extends Target {

    private float indicatorHeight;
    private float indicatorRisk;

    public Target2(Context context, Target.Builder builder) {
        super(context, builder);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        indicatorHeight = getWidth()/(2f + (getWidth()/100 +1) );
        indicatorRisk = indicatorHeight - 10f;

        Paint rect_paint = new Paint();
        float risk = targetWidth /2;
        RectF rect = new RectF(getLeft() +risk + indicatorRisk, getTop() +risk + indicatorRisk
                , getRight() -risk - indicatorRisk, getBottom()-risk - indicatorRisk);
        rect_paint.setColor(color);
        rect_paint.setStrokeWidth(targetWidth);
        rect_paint.setAntiAlias(true);
        rect_paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rect, 0f, 360f, false, rect_paint);

        Paint paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
        // indicator Top
        RectF indicator = new RectF(getWidth()/2f - (getWidth()/16f), getTop() -(indicatorHeight /2f)
                , getWidth()/2f + (getWidth()/16f), getTop() + indicatorHeight);
        canvas.drawArc (indicator, 70f, 40f, true, paint);
        // indicator Right
        indicator.set(getRight() - indicatorHeight, getHeight()/2f - (getHeight()/16f)
                , getRight() +(indicatorHeight /2f), getHeight()/2f + (getHeight()/16f));
        canvas.drawArc (indicator, 160f, 40f, true, paint);
        // indicator Bottom
        indicator.set(getWidth()/2f - (getWidth()/16f), getBottom() - indicatorHeight
                , getWidth()/2f + (getWidth()/16f), getBottom() +(indicatorHeight /2f));
        canvas.drawArc (indicator, -70f, -40f, true, paint);
        // indicator Left
        indicator.set(getLeft() -(indicatorHeight /2f), getHeight()/2f - (getHeight()/16f)
                , getLeft() + indicatorHeight, getHeight()/2f + (getHeight()/16f));
        canvas.drawArc (indicator, -20f, 40f, true, paint);
    }
}
