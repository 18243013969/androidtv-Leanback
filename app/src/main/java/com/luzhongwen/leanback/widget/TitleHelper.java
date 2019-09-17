package com.luzhongwen.leanback.widget;

import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.leanback.widget.BrowseFrameLayout;

/**
 * 帮助类 用于处理动画和聚焦
 * **/
public class TitleHelper {
    ViewGroup mSceneRoot;
    View mTitleView;
    private Object mTitleUpTransition;
    private Object mTitleDownTransition;
    private Object mSceneWithTitle;
    private Object mSceneWithoutTitle;

    private final BrowseFrameLayout.OnFocusSearchListener mOnFocusSearchListener = new BrowseFrameLayout.OnFocusSearchListener() {

        @Override
        public View onFocusSearch(View focused, int direction) {
            //当前View 不等于mTitleView 并且向上聚焦的时候
            if(focused != mTitleView && direction == View.FOCUS_UP) {
                return mTitleView;
            }
            //布局方向，因为有些地方是从右向左看
            final  boolean isRtl = ViewCompat.getLayoutDirection(focused) == ViewCompat.LAYOUT_DIRECTION_RTL;
            final int forward = isRtl ? View.FOCUS_LEFT : View.FOCUS_RIGHT;
            if(mTitleView.hasFocus() && (direction == View.FOCUS_DOWN || direction == forward)) {
                return mSceneRoot;
            }
            return null;
        }
    };

}
