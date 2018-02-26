package moizest89.mobdev_test.ui.details.list;

import moizest89.mobdev_test.base.MvpView;
import moizest89.mobdev_test.data.models.BreedImages;
import moizest89.mobdev_test.data.models.Breeds;

/**
 * Created by moizest89 on 2/25/18.
 */

public interface IListDetailsView extends MvpView{


    void setData(BreedImages breedImages);
    void showData();
    void hideData();
    void showLoader();
    void hideLoader();
    void showErrorMessage();
    void setTextTitle(String title);
}
