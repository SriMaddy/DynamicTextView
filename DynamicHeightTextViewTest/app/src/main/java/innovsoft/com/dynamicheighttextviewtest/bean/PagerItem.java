package innovsoft.com.dynamicheighttextviewtest.bean;

import android.support.v4.app.Fragment;

/**
 * Created by sridhar on 29/5/16.
 */
public class PagerItem {

    private Fragment fragment;
    private final CharSequence mTitle;
    private final int mIndicatorColor;
    private final int mDividerColor;

    public PagerItem(Fragment fragment, CharSequence title, int indicatorColor, int dividerColor) {
        this.fragment = fragment;
        mTitle = title;
        mIndicatorColor = indicatorColor;
        mDividerColor = dividerColor;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public int getIndicatorColor() {
        return mIndicatorColor;
    }

    public int getDividerColor() {
        return mDividerColor;
    }

    public Fragment getFragment() { return  fragment; }
}
