package innovsoft.com.dynamicheighttextviewtest.helper;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import java.util.List;

import innovsoft.com.dynamicheighttextviewtest.MainActivity;
import innovsoft.com.dynamicheighttextviewtest.adapter.MyRecyclerViewAdapter;
import innovsoft.com.dynamicheighttextviewtest.listener.SetAdapterListener;

/**
 * Created by sridhar on 29/5/16.
 */
public class MyTouchHelper extends ItemTouchHelper.SimpleCallback {

    private MyRecyclerViewAdapter adapter1;
    private MyRecyclerViewAdapter adapter2;
    private ViewPager viewPager;
    private Activity mActivity;

    private static final int RIGHT = 8;
    private static final int LEFT = 4;

    private List<String> list1;
    private List<String> list2;
    private int fragmentType;

    public MyTouchHelper(Activity activity, MyRecyclerViewAdapter adapter, ViewPager viewPager, List<String> list, int fragmentType) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.fragmentType = fragmentType;
        this.mActivity = activity;
        if(fragmentType == 1) {
            this.adapter1 = adapter;
            this.list1 = list;
        } else if(fragmentType == 2) {
            this.adapter2 = adapter;
            this.list2 = list;
        }
        this.viewPager = viewPager;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if(fragmentType == 1) {
            adapter1.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        } else if(fragmentType == 2) {
            adapter2.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        }
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Log.w("direction", String.valueOf(direction));
        if(fragmentType == 1) {
            if(direction == RIGHT) {
                viewPager.setCurrentItem(1);
                int position = viewHolder.getAdapterPosition();
                String object = list1.get(position);
                Log.w("object from list1 : ", object);
                SetAdapterListener listener = (MainActivity) mActivity;
                listener.moveToNextFragment(position, object, fragmentType);
            } else if(direction == LEFT) {
                viewPager.setCurrentItem(0);
                int position = viewHolder.getAdapterPosition();
                String object = list1.get(position);
                Log.w("object from list1 : ", object);
                adapter1.remove(position);
                adapter1.add(object);
            }
        } else if(fragmentType == 2) {
            if(direction == RIGHT) {
                viewPager.setCurrentItem(1);
                int position = viewHolder.getAdapterPosition();
                String object = list2.get(position);
                Log.w("object from list2 : ", object);
                adapter2.remove(position);
                adapter2.add(object);
            } else if(direction == LEFT) {
                viewPager.setCurrentItem(0);
                int position = viewHolder.getAdapterPosition();
                String object = list2.get(position);
                Log.w("object from list2 : ", object);
                SetAdapterListener listener = (MainActivity) mActivity;
                listener.moveToNextFragment(position, object, fragmentType);
            }
        }
    }
}
