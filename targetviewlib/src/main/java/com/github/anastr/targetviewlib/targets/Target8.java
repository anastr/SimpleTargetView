package com.github.anastr.targetviewlib.targets;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.github.anastr.targetviewlib.Target;

public class Target8 extends Target {

    public Target8(Context context, Builder builder) {
        super(context, builder);
        init();
    }

    private void init() {
        circle_paint = new Paint();
        rect = new RectF();

        circle_paint.setAntiAlias(true);
        circle_paint.setStyle(Paint.Style.STROKE);
    }

    private Paint circle_paint;
    private RectF rect;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        circle_paint.setColor(targetColor);
        circle_paint.setStrokeWidth(targetWidth);

        float risk = targetWidth /2f;
        // Oval Top
        rect.set((getWidth()/2f) - targetWidth, getTop() +risk
                , (getWidth()/2f) +targetWidth, getTop() +risk +(targetWidth*2f));
        canvas.save();
        for (int i=1; i<=8; i++) {
            canvas.drawOval(rect, circle_paint);
            canvas.rotate(45f, getWidth()/2f, getHeight()/2f);
        }
        canvas.restore();
    }
}
