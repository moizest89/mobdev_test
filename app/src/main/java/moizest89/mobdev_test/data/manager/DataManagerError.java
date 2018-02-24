package moizest89.mobdev_test.data.manager;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

import moizest89.mobdev_test.data.models.Breeds;
import retrofit2.Response;

/**
 * Created by moizest89 on 2/24/18.
 */

public class DataManagerError implements Parcelable {


    @SerializedName ( "code" )
    private int code;
    @SerializedName ( "errorDescription" )
    private String errorDescription;
    @SerializedName ( "userMessage" )
    private HashMap<String,String> userMessage;
    @SerializedName( "info" )
    private HashMap< String, Object > info;

    public DataManagerError() {
    }

    public DataManagerError(int code, String errorDescription, HashMap<String, String> userMessage, HashMap<String, Object> info) {
        this.code = code;
        this.errorDescription = errorDescription;
        this.userMessage = userMessage;
        this.info = info;
    }

    public DataManagerError(Response response) {
        this.setCode(response.code());
        this.setErrorDescription(DataManagerUtilites.getErrorMessage(response));
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public HashMap<String, String> getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(HashMap<String, String> userMessage) {
        this.userMessage = userMessage;
    }

    public HashMap<String, Object> getInfo() {
        return info;
    }

    public void setInfo(HashMap<String, Object> info) {
        this.info = info;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.errorDescription);
        dest.writeSerializable(this.userMessage);
        dest.writeSerializable(this.info);
    }

    protected DataManagerError(Parcel in) {
        this.code = in.readInt();
        this.errorDescription = in.readString();
        this.userMessage = (HashMap<String, String>) in.readSerializable();
        this.info = (HashMap<String, Object>) in.readSerializable();
    }

    public static final Parcelable.Creator<DataManagerError> CREATOR = new Parcelable.Creator<DataManagerError>() {
        public DataManagerError createFromParcel(Parcel source) {
            return new DataManagerError(source);
        }

        public DataManagerError[] newArray(int size) {
            return new DataManagerError[size];
        }
    };
}
