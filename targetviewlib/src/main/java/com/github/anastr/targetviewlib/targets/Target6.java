package com.github.anastr.targetviewlib.targets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.github.anastr.targetviewlib.Target;

public class Target6 extends Target {

    public Target6(Context context, Builder builder) {
        super(context, builder);
        init();
    }

    private void init() {
        arc_paint = new Paint();
        rect = new RectF();

        arc_paint.setAntiAlias(true);
        arc_paint.setStyle(Paint.Style.STROKE);
    }

    private Paint arc_paint;
    private RectF rect;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        arc_paint.setColor(targetColor);
        arc_paint.setStrokeWidth(targetWidth);

        float risk = targetWidth /2f;
        // arc Top
        rect.set((getWidth()/2f) - (getWidth()/6f), getTop() +risk
                , (getWidth()/2f) +(getWidth()/6f), getTop() +(getHeight()/3f));
        canvas.save();
        for (int i=1; i<=8; i++) {
            canvas.drawArc(rect, 0f, -90f, false, arc_paint);
            canvas.rotate(45f, getWidth()/2f, getHeight()/2f);
        }
        canvas.restore();
    }
}
