package moizest89.mobdev_test.ui.details.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.mobdev_test.R;
import moizest89.mobdev_test.util.OnItemClickListener;


/**
 * Created by moizest89 on 2/25/18.
 */

public class ListDetailsAdapter extends RecyclerView.Adapter<ListDetailsAdapter.Holder>{


    private List<String> mData = new ArrayList<>();
    private Context context;
    private OnItemClickListener onItemClickListener;


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


        Picasso.with(context)
                .load(mData.get(position))
                .placeholder(R.drawable.dog_placeholder)
                .error(R.drawable.dog_placeholder)
                .into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return this.mData.size();
    }

    public void setData(List<String> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    public List<String> getData() {
        return mData;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.imageView)
        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClickListener(view, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
