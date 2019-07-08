//public boolean onTouchEvent(MotionEvent event) {
//final int viewFlags = mViewFlags;
//        if ((viewFlags & ENABLED_MASK) == DISABLED) {
//        // A disabled view that is clickable still consumes the touch
//        // events, it just doesn't respond to them.
//        return (((viewFlags & CLICKABLE) == CLICKABLE ||
//        (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE));
//        }
//        if (mTouchDelegate != null) {
//        if (mTouchDelegate.onTouchEvent(event)) {
//        return true;
//        }
//        }
//        if (((viewFlags & CLICKABLE) == CLICKABLE ||
//        (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE)) {
//        switch (event.getAction()) {
//        case MotionEvent.ACTION_UP:
//        boolean prepressed = (mPrivateFlags & PREPRESSED) != 0;
//        if ((mPrivateFlags & PRESSED) != 0 || prepressed) {
//        // take focus if we don't have it already and we should in
//        // touch mode.
//        boolean focusTaken = false;
//        if (isFocusable() && isFocusableInTouchMode() && !isFocused()) {
//        focusTaken = requestFocus();
//        }
//        if (!mHasPerformedLongPress) {
//        // This is a tap, so remove the longpress check
//        removeLongPressCallback();
//        // Only perform take click actions if we were in the pressed state
//        if (!focusTaken) {
//        // Use a Runnable and post this rather than calling
//        // performClick directly. This lets other visual state
//        // of the view update before click actions start.
//        if (mPerformClick == null) {
//        mPerformClick = new PerformClick();
//        }
//        if (!post(mPerformClick)) {
//        performClick();
//        }
//        }
//        }
//        if (mUnsetPressedState == null) {
//        mUnsetPressedState = new UnsetPressedState();
//        }
//        if (prepressed) {
//        mPrivateFlags |= PRESSED;
//        refreshDrawableState();
//        postDelayed(mUnsetPressedState,
//        ViewConfiguration.getPressedStateDuration());
//        } else if (!post(mUnsetPressedState)) {
//        // If the post failed, unpress right now
//        mUnsetPressedState.run();
//        }
//        removeTapCallback();
//        }
//        break;
//        case MotionEvent.ACTION_DOWN:
//        if (mPendingCheckForTap == null) {
//        mPendingCheckForTap = new CheckForTap();
//        }
//        mPrivateFlags |= PREPRESSED;
//        mHasPerformedLongPress = false;
//        postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
//        break;
//        case MotionEvent.ACTION_CANCEL:
//        mPrivateFlags &= ~PRESSED;
//        refreshDrawableState();
//        removeTapCallback();
//        break;
//        case MotionEvent.ACTION_MOVE:
//final int x = (int) event.getX();
//final int y = (int) event.getY();
//        // Be lenient about moving outside of buttons
//        int slop = mTouchSlop;
//        if ((x < 0 - slop) || (x >= getWidth() + slop) ||
//        (y < 0 - slop) || (y >= getHeight() + slop)) {
//        // Outside button
//        removeTapCallback();
//        if ((mPrivateFlags & PRESSED) != 0) {
//        // Remove any future long press/tap checks
//        removeLongPressCallback();
//        // Need to switch from pressed to not pressed
//        mPrivateFlags &= ~PRESSED;
//        refreshDrawableState();
//        }
//        }
//        break;
//        }
//        return true;//原89行
//        }
//        return false;
//        }
        package com.example.johnyin.interviewproject.eventDispatch;

import android.content.Context;

/**
 * author:johnyin2015
 * time:2019/4/21
 * description:
 */
public class TouchEventSourceCode {
        Context context;
}
