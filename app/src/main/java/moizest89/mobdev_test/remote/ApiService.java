package moizest89.mobdev_test.remote;

import moizest89.mobdev_test.data.models.BreedImages;
import moizest89.mobdev_test.data.models.Breeds;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by moizest89 on 2/24/18.
 */

public interface ApiService {

    @GET("breeds/list")
    Call<Breeds> getAllBreads();

    @GET("breed/{breed}/images")
    Call<BreedImages> getAllImagePerBreed(@Path("breed") String breed);

}
