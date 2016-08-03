package com.github.anastr.targetviewlib;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

import com.github.anastr.targetviewlib.targets.Target1;
import com.github.anastr.targetviewlib.targets.Target2;
import com.github.anastr.targetviewlib.targets.Target3;
import com.github.anastr.targetviewlib.targets.Target4;
import com.github.anastr.targetviewlib.targets.Target5;
import com.github.anastr.targetviewlib.targets.Target6;
import com.github.anastr.targetviewlib.targets.Target7;
import com.github.anastr.targetviewlib.targets.Target8;

import java.util.ArrayList;
import java.util.List;

/** Animation view to Highlight particular views */
public class TargetView extends RelativeLayout {

    private com.github.anastr.targetviewlib.Target target;
    private int rotateDuration = 2000;
    private int targetMode = 1;
    private BackgroundEffect backgroundEffect;
    private boolean withBackgroundEffect = true;
    private int backgroundEffectColor = Color.CYAN, backgroundEffectDuration = 500;
    private AnimatorSet animatorSet;

    public TargetView(Context context) {
        super(context);
    }

    public TargetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TargetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int size = (width > height) ? height : width;
        setMeasuredDimension(size, size);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TargetView, 0, 0);

        targetMode = a.getInt(R.styleable.TargetView_targetMode, 1);
        int rotateSide = a.getInt(R.styleable.TargetView_rotateSide, 1);
        float targetWidth = a.getFloat(R.styleable.TargetView_targetWidth, 10);
        int targetColor = a.getColor(R.styleable.TargetView_targetColor, Color.BLACK);
        rotateDuration = a.getInt(R.styleable.TargetView_rotateDuration, 2000);
        withBackgroundEffect = a.getBoolean(R.styleable.TargetView_withBackgroundEffect, true);
        backgroundEffectColor = a.getColor(R.styleable.TargetView_backgroundEffectColor, Color.CYAN);
        backgroundEffectDuration = a.getInt(R.styleable.TargetView_backgroundEffectDuration, 500);
        a.recycle();

        Target.Builder builder = new Target.Builder(targetWidth, targetColor, rotateSide);
        initializeTarget(builder);

        animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());

        LayoutParams targetParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        targetParams.addRule(CENTER_IN_PARENT, TRUE);
        if(withBackgroundEffect){
            backgroundEffect = new BackgroundEffect(getContext()
                    , new BackgroundEffect.Builder().setColor(backgroundEffectColor));
            this.addView(backgroundEffect, targetParams);
        }
        this.addView(target, targetParams);

        if (isInEditMode())
            return;

        List<Animator> animators = new ArrayList<>();
        // rotateSide = {1,-1} , {Right,Left}
        ObjectAnimator  rotate = ObjectAnimator.ofFloat(target, "rotation",0f,360f * target.getRotateSide());
        rotate.setDuration(rotateDuration);
        rotate.setRepeatCount(ObjectAnimator.INFINITE);
        rotate.setRepeatMode(ObjectAnimator.RESTART);
        rotate.setStartDelay(0L);
        animators.add(rotate);

        if(withBackgroundEffect){
            ObjectAnimator alpha = ObjectAnimator.ofFloat(backgroundEffect, "Alpha", 1.0f, 0.2f);
            alpha.setRepeatCount(ObjectAnimator.INFINITE);
            alpha.setRepeatMode(ObjectAnimator.REVERSE);
            alpha.setDuration(backgroundEffectDuration);
            animators.add(alpha);
        }

        animatorSet.playTogether(animators);
        startAnimation();
    }

    private void initializeTarget(Target.Builder builder) {
        switch (targetMode) {
            case 1:
                target = new Target1(getContext(), builder);
                break;
            case 2:
                target = new Target2(getContext(), builder);
                break;
            case 3:
                target = new Target3(getContext(), builder);
                break;
            case 4:
                target = new Target4(getContext(), builder);
                break;
            case 5:
                target = new Target5(getContext(), builder);
                break;
            case 6:
                target = new Target6(getContext(), builder);
                break;
            case 7:
                target = new Target7(getContext(), builder);
                break;
            case 8:
                target = new Target8(getContext(), builder);
                break;
            default :
                target = new Target1(getContext(), builder);
                break;
        }
    }

    public void startAnimation(){
        if(!animatorSet.isRunning()){
            animatorSet.start();
        }
    }

    public void stopAnimation(){
        if(animatorSet.isRunning()){
            animatorSet.end();
        }
    }

    public void setTargetColor(int targetColor) {
        target.setTargetColor(targetColor);
        target.invalidate();
    }

    public void setTargetWidth(float targetWidth) {
        target.setTargetWidth(targetWidth);
        target.invalidate();
    }

    public void setBackgroundEffectColor(int backgroundEffectColor) {
        this.backgroundEffectColor = backgroundEffectColor;
        backgroundEffect.setColor(backgroundEffectColor);
        backgroundEffect.invalidate();
    }

    public boolean isAnimationRunning(){
        return animatorSet.isRunning();
    }

    public int getRotateDuration() {
        return rotateDuration;
    }

    public int getTargetColor() {
        return target.getTargetColor();
    }

    public float getTargetWidth() {
        return target.getTargetWidth();
    }

    public boolean isWithBackgroundEffect() {
        return withBackgroundEffect;
    }

    public int getBackgroundEffectDuration() {
        return backgroundEffectDuration;
    }

    /** Return "Right" if TargetView rotate to Right OR
     *         "Left" if TargetView rotate to Left */
    public String getRotateSide() {
        return (target.getRotateSide() == 1) ? "Right" : "Left";
    }
}
