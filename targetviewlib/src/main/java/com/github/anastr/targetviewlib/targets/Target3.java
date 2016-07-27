package com.github.anastr.targetviewlib.targets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.github.anastr.targetviewlib.Target;

/**
 * Created by my pc on 7/26/2016.
 */
public class Target3 extends Target {

    private float indicatorHeight;

    public Target3(Context context, Target.Builder builder) {
        super(context, builder);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        indicatorHeight = getWidth()/(2f + (getWidth()/100 +1) );

        Paint paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
        // indicator Top
        RectF indicator = new RectF(getWidth()/2f - (targetWidth/2f), getTop()
                , getWidth()/2f + (targetWidth/2f), getTop() + (indicatorHeight*2));
        canvas.drawArc (indicator, -70f, -40f, true, paint);
        // indicator Right
        indicator.set(getRight() - (indicatorHeight*2), getHeight()/2f - (targetWidth/2f)
                , getRight() , getHeight()/2f + (targetWidth/2f));
        canvas.drawArc (indicator, -20f, 40f, true, paint);
        // indicator Bottom
        indicator.set(getWidth()/2f - (targetWidth/2f), getBottom() - (indicatorHeight*2)
                , getWidth()/2f + (targetWidth/2f), getBottom() );
        canvas.drawArc (indicator, 70f, 40f, true, paint);
        // indicator Left
        indicator.set(getLeft() , getHeight()/2f - (targetWidth/2f)
                , getLeft() + (indicatorHeight*2), getHeight()/2f + (targetWidth/2f));
        canvas.drawArc (indicator, 160f, 40f, true, paint);
    }
}
