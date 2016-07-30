package com.github.anastr.targetviewlib.targets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.github.anastr.targetviewlib.Target;


public class Target3 extends Target {

    public Target3(Context context, Target.Builder builder) {
        super(context, builder);
        init();
    }

    private void init() {
        paint = new Paint();
        indicator = new RectF();

        paint.setAntiAlias(true);
    }

    private Paint paint;
    private RectF indicator;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /** Arc indicator */
        float indicatorHeight = getWidth() / (2f + (getWidth() / 100 + 1));

        paint.setColor(targetColor);

        // indicator Top
        indicator.set(getWidth()/2f - (targetWidth/2f), getTop()
                , getWidth()/2f + (targetWidth/2f), getTop() + (indicatorHeight *2f));
        // indicator Right
        canvas.save();
        for (int i=1; i<=4; i++) {
            canvas.drawArc (indicator, -70f, -40f, true, paint);
            canvas.rotate(90f, getWidth()/2f, getHeight()/2f);
        }
        canvas.restore();
    }
}
