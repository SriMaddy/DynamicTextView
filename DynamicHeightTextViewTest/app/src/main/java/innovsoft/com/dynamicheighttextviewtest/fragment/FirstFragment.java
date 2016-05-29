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
 * Created by sridhar on 29/5/16.
 */
public class FirstFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private Activity mActivity;
    private List<String> list1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        list1 = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        findViewsById(view);

        return view;
    }

    private void findViewsById(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        list1.clear();
        list1.add("One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1One1");
        list1.add("Two1Two1Two1Two1Two1Two1Two1Two1Two1Two1Two1");
        list1.add("Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1Three1");
        list1.add("Four1");
        list1.add("Five1");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SetAdapterListener listener = (MainActivity) mActivity;
        listener.setAdapterToRecyclerView(mRecyclerView, list1, 1);
    }
}
