package com.jb.ratingbar;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import java.util.UUID;


public abstract class RatingSliderAnimEffect extends CoreSlider {

    protected Handler mHandler;
    protected Runnable mRunnable;
    protected String mRunnableToken = UUID.randomUUID().toString();

    protected RatingSliderAnimEffect(Context context) {
        super(context);
        init();
    }

    protected RatingSliderAnimEffect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected RatingSliderAnimEffect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mHandler = new Handler();
    }

    protected void postRunnable(Runnable runnable, long ANIMATION_DELAY) {
        if (mHandler == null) {
            mHandler = new Handler();
        }

        long timeMillis = SystemClock.uptimeMillis() + ANIMATION_DELAY;
        mHandler.postAtTime(runnable, mRunnableToken, timeMillis);
    }

    protected abstract void emptyRatingBar();

    protected abstract void fillRatingBar(float rating);
}

