package moizest89.mobdev_test.ui.details.image;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.mobdev_test.R;
import moizest89.mobdev_test.util.TouchImageView;

/**
 * Created by moizest89 on 2/25/18.
 */

public class ListDetailsImageAdapter extends PagerAdapter {

    private List<String> mData = new ArrayList<>();
    private Context context;


    public ListDetailsImageAdapter(Context context) {
        this.context = context;
        this.mData = mData;
    }

    public void setData(List<String> mData) {
        this.mData = mData;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.mData.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        super.restoreState(state, loader);
    }

    @Override
    public Parcelable saveState() {
        // TODO Auto-generated method stub
        return super.saveState();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void startUpdate(View container) {
        // TODO Auto-generated method stub
        super.startUpdate(container);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View vi=container;
        vi = LayoutInflater.from(this.context).inflate(R.layout.item_image_details, container, false);

        TouchImageView touchImageView = vi.findViewById(R.id.touch_imageview);

        Picasso.with(context)
                .load(mData.get(position))
                .placeholder(R.drawable.dog_placeholder)
                .error(R.drawable.dog_placeholder)
                .into(touchImageView);

        ViewPager pager = (ViewPager) container;
        pager.addView(vi);
        return vi;


    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ViewPager pager = (ViewPager) container;
        pager.removeView((View) object);
    }
}
