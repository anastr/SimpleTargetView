package com.github.anastr.targetviewlib.targets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.github.anastr.targetviewlib.Target;


public class Target5 extends Target {

    public Target5(Context context, Target.Builder builder) {
        super(context, builder);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    private Paint paint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /* line indicator */
        float indicatorHeight = getWidth() / (4f + (getWidth() / 100 + 1));

        paint.setColor(targetColor);
        paint.setStrokeWidth(targetWidth);

        // indicator Top
        canvas.save();
        for (int i=1; i<=4; i++) {
            canvas.drawLine(getWidth()/2f, getTop(), getWidth()/2f, getTop() + indicatorHeight, paint);
            canvas.rotate(90f, getWidth()/2f, getHeight()/2f);
        }
        canvas.restore();
    }
}

