package innovsoft.com.dynamicheighttextviewtest.listener;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by sridhar on 29/5/16.
 */
public interface SetAdapterListener {

    void setAdapterToRecyclerView(RecyclerView recyclerView, List<String> list, int fragmentType);
    void moveToNextFragment(int position, String object, int fragmentType);

}
