package com.github.anastr.targetviewlib.targets;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.github.anastr.targetviewlib.Target;

public class Target4 extends Target {

    public Target4(Context context, Target.Builder builder) {
        super(context, builder);
        init();
    }

    private void init() {
        rect_paint = new Paint();
        line_paint = new Paint();
        rect = new RectF();

        rect_paint.setAntiAlias(true);
        rect_paint.setStyle(Paint.Style.STROKE);

        line_paint.setAntiAlias(true);
        line_paint.setStrokeWidth(7f);
    }

    private Paint rect_paint, line_paint;
    private RectF rect;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /* line indicator */
        float indicatorHeight = getWidth() / (4f + (getWidth() / 100 + 1));
        float indicatorRisk = indicatorHeight - 4f;

        rect_paint.setColor(targetColor);
        rect_paint.setStrokeWidth(targetWidth);
        line_paint.setColor(targetColor);

        float risk = targetWidth /2f;
        rect.set(getLeft() +risk + indicatorRisk, getTop() +risk + indicatorRisk
                , getRight() -risk - indicatorRisk, getBottom()-risk - indicatorRisk);
        canvas.drawOval(rect, rect_paint);

        // indicator Top
        canvas.save();
        for (int i=1; i<=4; i++) {
            canvas.drawLine(getWidth()/2f, getTop(), getWidth()/2f, getTop() + indicatorHeight, line_paint);
            canvas.rotate(90f, getWidth()/2f, getHeight()/2f);
        }
        canvas.restore();
    }
}

