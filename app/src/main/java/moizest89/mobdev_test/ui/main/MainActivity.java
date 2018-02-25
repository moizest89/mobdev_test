package moizest89.mobdev_test.ui.main;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.mobdev_test.R;
import moizest89.mobdev_test.base.BaseActivity;
import moizest89.mobdev_test.data.models.Breeds;
import moizest89.mobdev_test.ui.details.ListDetailsActivity;
import moizest89.mobdev_test.util.OnItemClickListener;
import moizest89.mobdev_test.util.Util;

import static moizest89.mobdev_test.util.Util.INTENT_SENDED_DATA;

public class MainActivity extends BaseActivity implements
        IMainView,
        OnItemClickListener
        {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private MainPresenter mainPresenter;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        this.mAdapter = new MainAdapter(this);
        this.mAdapter.setOnItemClickListener(this);

//        this.mRecyclerView = findViewById(R.id.recyclerView);
//        this.mProgressBar = findViewById(R.id.progressBar);


        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        this.mRecyclerView.setAdapter(this.mAdapter);


        this.mainPresenter = new MainPresenter(this);
        this.mainPresenter.attachView(this);

        if(savedInstanceState == null) {
            this.mainPresenter.getData();
        }else{
            List<String> data = savedInstanceState.getStringArrayList(Util.SAVE_INSTANCE);
            if(data.size() > 0) {
                Breeds breeds = new Breeds(data);
                this.mainPresenter.setDataInView(breeds);
            }else{
                this.mainPresenter.getData();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return false;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        mainPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void setData(Breeds breeds) {
        this.mAdapter.setData(breeds.getData());

        Bundle bundle = new Bundle();
        bundle.putParcelable(Util.SAVE_INSTANCE, breeds);
        onSaveInstanceState(bundle);


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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList(Util.SAVE_INSTANCE, (ArrayList<String>) mAdapter.getData());
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onItemClickListener(View view, int position) {
        Bundle bundle  = new Bundle();
        bundle.putString(INTENT_SENDED_DATA, mAdapter.getItemValue(position));

        Util.changeActivity(this, ListDetailsActivity.class, bundle, false);


    }
}
