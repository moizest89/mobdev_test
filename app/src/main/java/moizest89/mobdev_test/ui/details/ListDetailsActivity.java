package moizest89.mobdev_test.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

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

    private ListDetailsPresenter mPresenter;
    private ListDetailsAdapter mAdapter;
    private String breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        if(intent != null){
            this.breed = intent.getStringExtra(Util.INTENT_SENDED_DATA);
        }

        this.mAdapter = new ListDetailsAdapter(this);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        this.mRecyclerView.setAdapter(this.mAdapter);

        this.mPresenter = new ListDetailsPresenter(this);
        this.mPresenter.attachView(this);
        this.mPresenter.getData(this.breed);


    }


    @Override
    public void setData(BreedImages breedImages) {
        mAdapter.setData(breedImages.getData());
    }

    @Override
    public void showData() {
        this.mRecyclerView.animate().alpha(1).setDuration(Util.ANIMATION_DELAY);
    }

    @Override
    public void hideData() {
        this.mRecyclerView.animate().alpha(0).setDuration(Util.ANIMATION_DELAY);
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
}
