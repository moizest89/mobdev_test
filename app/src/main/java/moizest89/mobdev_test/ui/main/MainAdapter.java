package moizest89.mobdev_test.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.mobdev_test.R;
import moizest89.mobdev_test.data.models.Breeds;
import moizest89.mobdev_test.util.OnItemClickListener;

/**
 * Created by moizest89 on 2/24/18.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder> {

    private List<String> data = new ArrayList<>();
    private Context context;
    private OnItemClickListener onItemClickListener;


    public MainAdapter() {
    }

    public MainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(this.context).inflate(R.layout.item_breeds_list, parent, false);

        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(Holder holder, int position) {

        String mBreed = this.data.get(position);

        holder.text_view_name.setText(mBreed);


    }

    public void setData(List<String> data){
        this.data = data;
        this.notifyDataSetChanged();
    }

    public String getItemValue(int position){
        if(position <= data.size()) {
            return this.data.get(position);
        }else{
            return "";
        }
    }

    public List<String> getData() {
        return data;
    }

    @Override
    public int getItemCount() {
        return this.data.size();

    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.text_view_name)
        TextView text_view_name;

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
