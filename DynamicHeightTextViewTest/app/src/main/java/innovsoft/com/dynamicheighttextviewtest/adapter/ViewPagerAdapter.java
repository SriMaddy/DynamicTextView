package innovsoft.com.dynamicheighttextviewtest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import innovsoft.com.dynamicheighttextviewtest.bean.PagerItem;

/**
 * Created by sridhar on 29/5/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<PagerItem> mTabs;

    public ViewPagerAdapter(FragmentManager fm, List<PagerItem> mTabs) {
        super(fm);
        this.mTabs = mTabs;
    }

    @Override
    public Fragment getItem(int i) {
        return mTabs.get(i).getFragment();
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs.get(position).getTitle();
    }
}
