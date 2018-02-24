package moizest89.mobdev_test.base;

/**
 * Created by moizest89 on 2/24/18.
 */

public interface Presenter <V extends MvpView>{

    void attachView(V mvpView);

    void detachView();
}
