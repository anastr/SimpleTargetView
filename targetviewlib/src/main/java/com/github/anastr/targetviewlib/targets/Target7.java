package com.github.anastr.targetviewlib.targets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.github.anastr.targetviewlib.Target;


public class Target7 extends Target {

    public Target7(Context context, Builder builder) {
        super(context, builder);
        init();
    }

    private void init() {
        rect_paint = new Paint();
        circle_paint = new Paint();
        rect = new RectF();

        rect_paint.setAntiAlias(true);
        rect_paint.setStyle(Paint.Style.STROKE);

        circle_paint.setAntiAlias(true);
    }

    private Paint rect_paint, circle_paint;
    private RectF rect;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rect_paint.setColor(targetColor);
        rect_paint.setStrokeWidth(targetWidth/4f);
        circle_paint.setColor(targetColor);

        float risk = targetWidth/4f /2f;
        // arc,circle Top
        rect.set((getWidth()/2f) - targetWidth, getTop() +risk
                , (getWidth()/2f) +targetWidth, getTop() +risk +(targetWidth*2f));
        canvas.save();
        for (int i=1; i<=4; i++) {
            canvas.drawArc(rect, -180f, 180f, false, rect_paint);
            canvas.drawCircle(rect.centerX(), rect.centerY(), targetWidth/2f, circle_paint);
            canvas.rotate(90f, getWidth()/2f, getHeight()/2f);
        }
        canvas.restore();
    }
}
