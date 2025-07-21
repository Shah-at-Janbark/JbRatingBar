package com.jb.ratingbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



public class RotationRatingEffect extends RatingSliderAnimEffect {

    // Control animation speed
    private static final long ANIMATION_DELAY = 15;

    public RotationRatingEffect(Context context) {
        super(context);
    }

    public RotationRatingEffect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RotationRatingEffect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void emptyRatingBar() {
        // Need to remove all previous runnable to prevent emptyRatingBar and fillRatingBar out of sync
        if (mRunnable != null) {
            mHandler.removeCallbacksAndMessages(mRunnableToken);
        }

        long delay = 0;
        for (final SliderElement sliderElement : mSliderElements) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    sliderElement.setEmpty();
                }
            }, delay += 5);
        }
    }

    @Override
    protected void fillRatingBar(final float rating) {
        // Need to remove all previous runnable to prevent emptyRatingBar and fillRatingBar out of sync
        if (mRunnable != null) {
            mHandler.removeCallbacksAndMessages(mRunnableToken);
        }

        for (final SliderElement sliderElement : mSliderElements) {
            final int ratingViewId = (int) sliderElement.getTag();
            final double maxIntOfRating = Math.ceil(rating);

            if (ratingViewId > maxIntOfRating) {
                sliderElement.setEmpty();
                continue;
            }

            mRunnable = getAnimationRunnable(rating, sliderElement, ratingViewId, maxIntOfRating);
            postRunnable(mRunnable, ANIMATION_DELAY);
        }
    }

    @NonNull
    private Runnable getAnimationRunnable(final float rating, final SliderElement sliderElement, final int ratingViewId, final double maxIntOfRating) {
        return new Runnable() {
            @Override
            public void run() {
                if (ratingViewId == maxIntOfRating) {
                    sliderElement.setPartialFilled(rating);
                } else {
                    sliderElement.setFilled();
                }

                if (ratingViewId == rating) {
                    Animation rotation = AnimationUtils.loadAnimation(getContext(), R.anim.rotation);
                    sliderElement.startAnimation(rotation);
                }
            }
        };
    }
}