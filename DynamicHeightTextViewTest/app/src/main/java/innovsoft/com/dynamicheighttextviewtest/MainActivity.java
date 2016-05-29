package innovsoft.com.dynamicheighttextviewtest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import innovsoft.com.dynamicheighttextviewtest.adapter.MyRecyclerViewAdapter;
import innovsoft.com.dynamicheighttextviewtest.adapter.ViewPagerAdapter;
import innovsoft.com.dynamicheighttextviewtest.bean.PagerItem;
import innovsoft.com.dynamicheighttextviewtest.fragment.FirstFragment;
import innovsoft.com.dynamicheighttextviewtest.fragment.SecondFragment;
import innovsoft.com.dynamicheighttextviewtest.helper.MyTouchHelper;
import innovsoft.com.dynamicheighttextviewtest.listener.SetAdapterListener;

public class MainActivity extends AppCompatActivity implements SetAdapterListener {

    private List<String> list1;
    private List<String> list2;
    private int fragmentType;

    private MyRecyclerViewAdapter adapter1;
    private MyRecyclerViewAdapter adapter2;
    private RecyclerView mRecyclerView;

    private ViewPager viewPager;
    private List<PagerItem> pagerItems;

    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        pagerItems = new ArrayList<>();


        /*// Setup ItemTouchHelper
        ItemTouchHelper.Callback callback = new MyTouchHelper(mAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecyclerView);*/
    }

    @Override
    public void setAdapterToRecyclerView(RecyclerView recyclerView, List<String> list, int fragmentType) {
        Log.w("setAdapter", "ToRecyclerView");
        mRecyclerView = recyclerView;
        if(fragmentType == 1) {
            list1 = list;
            adapter1 = new MyRecyclerViewAdapter(mActivity, list1);
            mRecyclerView.setAdapter(adapter1);
            this.fragmentType = fragmentType;
            Log.w("setAdapter", "ToRecyclerView1");
            ItemTouchHelper.Callback callback = new MyTouchHelper(mActivity, adapter1, viewPager, list1, fragmentType);
            setDragAndDrop(callback);
        } else if(fragmentType == 2) {
            list2 = list;
            adapter2 = new MyRecyclerViewAdapter(mActivity, list2);
            mRecyclerView.setAdapter(adapter2);
            this.fragmentType = fragmentType;
            Log.w("setAdapter", "ToRecyclerView2");
            ItemTouchHelper.Callback callback = new MyTouchHelper(mActivity, adapter2, viewPager, list2, fragmentType);
            setDragAndDrop(callback);
        }

    }

    @Override
    public void moveToNextFragment(int position, String object, int fragmentType) {
        if(fragmentType == 1) {
            adapter1.remove(position);
            adapter2.add(object);
        } else if(fragmentType == 2) {
            adapter2.remove(position);
            adapter1.add(object);
        }
    }

    private void setDragAndDrop(ItemTouchHelper.Callback callback) {
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("onResume","MainActivity");
        pagerItems.clear();
        pagerItems.add(new PagerItem(new FirstFragment(),
                "First fragment", // Title
                mActivity.getResources().getColor(R.color.colorAccent), // Indicator color
                Color.parseColor("#efedee"))); // Divider color

        pagerItems.add(new PagerItem(new SecondFragment(),
                "Second Fragment",
                mActivity.getResources().getColor(R.color.colorAccent),
                Color.parseColor("#efedee")));

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), pagerItems);
        viewPager.setAdapter(adapter);
    }
}
