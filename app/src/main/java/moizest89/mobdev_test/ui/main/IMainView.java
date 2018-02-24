package moizest89.mobdev_test.ui.main;

import moizest89.mobdev_test.base.MvpView;
import moizest89.mobdev_test.data.models.Breeds;

/**
 * Created by moizest89 on 2/24/18.
 */

public interface IMainView extends MvpView{

    void setData(Breeds breeds);
    void showData();
    void hideData();
    void showLoader();
    void hideLoader();
    void showErrorMessage();

}
