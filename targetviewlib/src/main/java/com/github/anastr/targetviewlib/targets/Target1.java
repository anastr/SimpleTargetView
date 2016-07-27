package com.github.anastr.targetviewlib.targets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.github.anastr.targetviewlib.Target;


public class Target1 extends Target {

    public Target1(Context context, Builder builder) {
        super(context, builder);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        RectF rect = new RectF();
        float risk = targetWidth /2f;
        rect.set(getLeft() +risk, getTop() +risk, getRight() -risk, getBottom()-risk);
        paint.setColor(color);
        paint.setStrokeWidth(targetWidth);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rect, 0f, -90f, false, paint);
        canvas.drawArc(rect, 180f, -90f, false, paint);
    }
}
