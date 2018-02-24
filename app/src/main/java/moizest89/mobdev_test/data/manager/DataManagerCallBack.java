package moizest89.mobdev_test.data.manager;

import retrofit2.Call;

/**
 * Created by moizest89 on 2/24/18.
 */

abstract public class DataManagerCallBack<T> {

    public abstract void onSucces(T success);
    public abstract void onError(DataManagerError error);
    public abstract void onFailure(Throwable t);
}
