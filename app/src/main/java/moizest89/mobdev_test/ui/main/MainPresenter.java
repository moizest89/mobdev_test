package moizest89.mobdev_test.ui.main;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import moizest89.mobdev_test.base.BasePresenter;
import moizest89.mobdev_test.data.manager.DataManager;
import moizest89.mobdev_test.data.manager.DataManagerCallBack;
import moizest89.mobdev_test.data.manager.DataManagerError;
import moizest89.mobdev_test.data.models.Breeds;

/**
 * Created by moizest89 on 2/24/18.
 */

public class MainPresenter extends BasePresenter<IMainView>{

    private Context context;
    private DataManager dataManager;

    public MainPresenter(Context context) {
        this.context = context;
        this.dataManager = new DataManager(this.context);
    }

    public MainPresenter(Context context, DataManager dataManager) {
        this.context = context;
        this.dataManager = dataManager;
    }


    public void getData(){

        this.dataManager.getAllBreadsItems(new DataManagerCallBack<Breeds>() {

            @Override
            public void onSucces(Breeds success) {
                setDataInView(success);
            }

            @Override
            public void onError(DataManagerError error) {
                getMvpView().hideLoader();
                getMvpView().hideData();
                getMvpView().showErrorMessage();
            }

            @Override
            public void onFailure(Throwable t) {
                getMvpView().hideLoader();
                getMvpView().hideData();
                getMvpView().showErrorMessage();
            }
        });
    }

    public void setDataInView(Breeds breeds){
        getMvpView().setData(breeds);
        getMvpView().hideLoader();
        getMvpView().showData();
    }


}
