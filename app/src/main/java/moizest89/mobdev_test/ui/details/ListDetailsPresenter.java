package moizest89.mobdev_test.ui.details;

import android.content.Context;

import moizest89.mobdev_test.base.BasePresenter;
import moizest89.mobdev_test.data.manager.DataManager;
import moizest89.mobdev_test.data.manager.DataManagerCallBack;
import moizest89.mobdev_test.data.manager.DataManagerError;
import moizest89.mobdev_test.data.models.BreedImages;

/**
 * Created by moizest89 on 2/25/18.
 */

public class ListDetailsPresenter extends BasePresenter<IListDetailsView>{

    private Context context;
    private DataManager dataManager;

    public ListDetailsPresenter(Context context) {
        this.context = context;
        this.dataManager = new DataManager(this.context);
    }

    public ListDetailsPresenter(Context context, DataManager dataManager) {
        this.context = context;
        this.dataManager = dataManager;
    }


    public void getData(String breed){

        this.dataManager.getImagePerBreadItems(breed, new DataManagerCallBack<BreedImages>() {
            @Override
            public void onSucces(BreedImages success) {
                getMvpView().setData(success);
                getMvpView().hideLoader();
                getMvpView().showData();
            }

            @Override
            public void onError(DataManagerError error) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }



}
