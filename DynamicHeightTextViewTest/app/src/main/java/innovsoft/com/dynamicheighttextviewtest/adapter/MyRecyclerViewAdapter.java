package innovsoft.com.dynamicheighttextviewtest.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import innovsoft.com.dynamicheighttextviewtest.R;

/**
 * Created by sridhar on 29/5/16.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private Activity activity;
    private List<String> objects;
    private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<>();
    private Random mRandom;


    public MyRecyclerViewAdapter(Activity activity, List<String> objects) {
        this.activity = activity;
        this.objects = objects;
        mRandom = new Random();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.my_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String object = objects.get(position);
        holder.myTxt.setText(object);

        /*int height = (int) getPositionRatio(position) * 100;
        holder.myTxt.setHeight(height);*/
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView myTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            myTxt = (TextView) itemView.findViewById(R.id.my_txt);
        }
    }

    public void add(String object) {
        objects.add(object);
        int position = objects.size();
        notifyItemInserted(position + 1);
    }

    public void remove(int position) {
        objects.remove(position);
        notifyItemRemoved(position);
    }

    public void swap(int firstPosition, int secondPosition){
        Collections.swap(objects, firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }

    private double getPositionRatio(final int position) {
        double ratio = sPositionHeightRatios.get(position, 0.0);
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatios.append(position, ratio);
            Log.d("ExampleDraggableAdapter", "getPositionRatio:" + position + " ratio:" + ratio);
        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5 the width
    }
}
