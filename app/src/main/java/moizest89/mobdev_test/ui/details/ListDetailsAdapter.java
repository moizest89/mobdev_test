package moizest89.mobdev_test.ui.details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import moizest89.mobdev_test.R;

/**
 * Created by moizest89 on 2/25/18.
 */

public class ListDetailsAdapter extends RecyclerView.Adapter<ListDetailsAdapter.Holder>{


    private List<String> mData = new ArrayList<>();
    private Context context;

    public ListDetailsAdapter(Context context) {
        this.context = context;
    }

    public ListDetailsAdapter() {
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_bread_details, parent, false);

        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return this.mData.size();
    }

    public void setData(List<String> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{

        public Holder(View itemView) {
            super(itemView);
        }
    }



}
