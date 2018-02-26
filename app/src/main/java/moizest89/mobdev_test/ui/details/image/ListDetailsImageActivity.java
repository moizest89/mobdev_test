package moizest89.mobdev_test.ui.details.image;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.mobdev_test.R;
import moizest89.mobdev_test.util.Util;

public class ListDetailsImageActivity extends AppCompatActivity {


    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private ListDetailsImageAdapter mAdapter;
    private List<String> data = new ArrayList<>();
    private int mPositionToStart = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details_image);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        if(intent != null){
            this.data = intent.getStringArrayListExtra(Util.INTENT_SENDED_DATA);
            this.mPositionToStart = intent.getIntExtra(Util.INTENT_SENDED_DATA_POSITION, 0);
        }

        this.mAdapter = new ListDetailsImageAdapter(this);
        this.mAdapter.setData(data);

        this.viewPager.setAdapter(this.mAdapter);
        this.viewPager.setCurrentItem(mPositionToStart);


    }

}
