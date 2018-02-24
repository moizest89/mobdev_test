package moizest89.mobdev_test.data.manager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import moizest89.mobdev_test.data.models.Breeds;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by moizest89 on 2/24/18.
 */

public class DataManagerUtilites {


    public static String getErrorMessage(Response<Breeds> responseBody){

        String message = "";

        try {
            JSONObject jObjError = new JSONObject(responseBody.errorBody().string());
            message = jObjError.getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }

}
