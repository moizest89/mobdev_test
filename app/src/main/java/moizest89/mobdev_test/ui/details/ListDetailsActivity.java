package moizest89.mobdev_test.ui.details;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.mobdev_test.R;
import moizest89.mobdev_test.base.BaseActivity;
import moizest89.mobdev_test.data.models.BreedImages;
import moizest89.mobdev_test.util.Util;

public class ListDetailsActivity extends BaseActivity implements IListDetailsView{

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_view_title)
    TextView text_view_title;
    @BindView(R.id.card_view_data)
    CardView card_view_data;

    private ListDetailsPresenter mPresenter;
    private ListDetailsAdapter mAdapter;
    private String breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);

        ButterKnife.bind(this);

        setToolbar();

        Intent intent = getIntent();
        if(intent != null){
            this.breed = intent.getStringExtra(Util.INTENT_SENDED_DATA);
        }

        this.mAdapter = new ListDetailsAdapter(this);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            private int space = 2;

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);

                outRect.left = space;
                outRect.right = space;
                outRect.bottom = space;

                // Add top margin only for the first item to avoid double space between items
                if (parent.getChildLayoutPosition(view) == 0) {
                    outRect.top = space;
                } else {
                    outRect.top = 0;
                }
            }
        });

        this.mPresenter = new ListDetailsPresenter(this);
        this.mPresenter.attachView(this);
        this.mPresenter.getData(this.breed);


    }

    private void setToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void setData(BreedImages breedImages) {
        mAdapter.setData(breedImages.getData());
    }

    @Override
    public void showData() {
        this.card_view_data.animate().alpha(1).setDuration(Util.ANIMATION_DELAY);
    }

    @Override
    public void hideData() {
        this.card_view_data.animate().alpha(0).setDuration(Util.ANIMATION_DELAY);
    }

    @Override
    public void showLoader() {
        this.mProgressBar.animate().alpha(1).setDuration(Util.ANIMATION_DELAY);
    }

    @Override
    public void hideLoader() {
        this.mProgressBar.animate().alpha(0).setDuration(Util.ANIMATION_DELAY);
    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void setTextTitle(String title) {
        this.text_view_title.setText(title);
    }
}
