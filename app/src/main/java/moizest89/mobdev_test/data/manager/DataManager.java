package moizest89.mobdev_test.data.manager;

import android.content.Context;

import moizest89.mobdev_test.data.models.Breeds;
import moizest89.mobdev_test.remote.ApiService;
import moizest89.mobdev_test.remote.MobdevTestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by moizest89 on 2/24/18.
 */

public class DataManager {

    private Context context;
    private ApiService apiService;

    public DataManager(Context context) {
        this.context = context;
        this.apiService = MobdevTestClient.getClient();
    }


    public DataManager(Context context, ApiService apiService) {
        this.context = context;
        this.apiService = apiService;
    }

    public void getAllBreadsItems(final DataManagerCallBack<Breeds> callBack){

        Call<Breeds> call = this.apiService.getAllBreads();
        call.enqueue(new Callback<Breeds>() {
            @Override
            public void onResponse(Call<Breeds> call, Response<Breeds> response) {

                if(response.isSuccessful()){
                    callBack.onSucces(response.body());
                }else{
                    DataManagerError dataManagerError = new DataManagerError(response);
                    callBack.onError(dataManagerError);
                }
            }

            @Override
            public void onFailure(Call<Breeds> call, Throwable t) {
                callBack.onFailure(t);
            }
        });

    }


}
