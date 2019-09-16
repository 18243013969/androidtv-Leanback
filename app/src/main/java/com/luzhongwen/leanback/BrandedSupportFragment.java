package com.luzhongwen.leanback;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.TitleHelper;
import androidx.leanback.widget.TitleViewAdapter;

public class BrandedSupportFragment extends Fragment {
    private static final String TITLE_SHOW = "titleShow";

    private boolean mShowingTitle = true;
    private CharSequence mTitle;
    private Drawable mBadgeDrawable;
    private View mTitleView;
    private TitleViewAdapter mTitleViewAdapter;
    private SearchOrbView.Colors mSearchAffordanceColors;
    private boolean mSearchAffordanceColorSet;
    private View.OnClickListener mExternalOnSearchClickedListener;
    private TitleHelper mTitleHelper;

    /**
     * 获取title的布局
     * **/
    public View onInflateTitleView(LayoutInflater inflater, ViewGroup viewGroup, Bundle saveInstanceState) {
        TypedValue typedValue = new TypedValue();
        //获取id，根据id获取View
        boolean found = viewGroup.getContext().getTheme()
                .resolveAttribute(androidx.leanback.R.attr.browseTitleViewLayout,typedValue,true);
        return inflater.inflate(found ? typedValue.resourceId : androidx.leanback.R.layout.lb_browse_title,viewGroup,false);
    }
}
