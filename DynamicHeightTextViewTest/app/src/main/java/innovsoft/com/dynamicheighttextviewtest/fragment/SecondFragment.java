package innovsoft.com.dynamicheighttextviewtest.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import innovsoft.com.dynamicheighttextviewtest.MainActivity;
import innovsoft.com.dynamicheighttextviewtest.R;
import innovsoft.com.dynamicheighttextviewtest.listener.SetAdapterListener;

/**
 * Created by sridhar on 29/5/26.
 */
public class SecondFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private Activity mActivity;
    private List<String> list2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        list2 = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        findViewsById(view);
        
        return view;
    }

    private void findViewsById(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        list2.clear();
        list2.add("One2");
        list2.add("Two2");
        list2.add("Three2");
        list2.add("Four2");
        list2.add("Five2");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SetAdapterListener listener = (MainActivity) mActivity;
        listener.setAdapterToRecyclerView(mRecyclerView, list2, 2);
    }
}
