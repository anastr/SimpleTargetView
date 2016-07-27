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

import java.util.ArrayList;
import java.util.List;

/** Animation view to highlight a particular goals */
public class TargetView extends RelativeLayout {

    private boolean animationRunning = true;

    private com.github.anastr.targetviewlib.Target target;
    private BackgroundEffect backgroundEffect;
    private int targetColor , rotateDuration;
    /** Width of the Target line , in Pixel*/
    private int targetWidth ;
    private int targetMode = 1;

    private boolean withBackgroundEffect;
    private int backgroundEffectColor, backgroundEffectDuration;

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

        targetColor  = a.getColor(R.styleable.TargetView_targetColor, Color.BLACK);
        rotateDuration = a.getInt(R.styleable.TargetView_rotateDuration, 2000);
        targetWidth = a.getInt(R.styleable.TargetView_targetWidth, 10);
        targetMode = a.getInt(R.styleable.TargetView_targetMode, 1);
        withBackgroundEffect = a.getBoolean(R.styleable.TargetView_withBackgroundEffect, true);
        backgroundEffectColor = a.getColor(R.styleable.TargetView_backgroundEffectColor, Color.CYAN);
        backgroundEffectDuration = a.getInt(R.styleable.TargetView_backgroundEffectDuration, 500);
        a.recycle();

        animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());

        Target.Builder builder = new Target.Builder().setTargetWidth(targetWidth).setColor(targetColor);
        switch (targetMode) {
            case 1:{
                target = new Target1(getContext(), builder);
                break;
            }
            case 2:{
                target = new Target2(getContext(), builder);
                break;
            }
            case 3:{
                target = new Target3(getContext(), builder);
                break;
            }
            default :{
                target = new Target1(getContext(), builder);
                break;
            }
        }
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
        ObjectAnimator  rotate = ObjectAnimator.ofFloat(target, "rotation",0f,360f);
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
        animatorSet.start();
        animationRunning = true;
    }

    public boolean isAnimationRunning(){
        return animationRunning;
    }

    public void startAnimation(){
        if(!isAnimationRunning()){
            animatorSet.start();
            animationRunning = true;
        }
    }

    public void stopAnimation(){
        if(isAnimationRunning()){
            animatorSet.end();
            animationRunning = false;
        }
    }

    public int getRotateDuration() {
        return rotateDuration;
    }

    public int getTargetColor() {
        return targetColor;
    }

    public int getTargetWidth() {
        return targetWidth;
    }
}
