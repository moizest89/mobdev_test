package moizest89.mobdev_test.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by moizest89 on 2/24/18.
 */

public class Breeds implements Parcelable {


    @SerializedName("message")
    @Expose
    private List<String> message = null;

    public List<String> getData() {
        return message;
    }

    public void setData(List<String> message) {
        this.message = message;
    }

    public Breeds(List<String> message) {
        this.message = message;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.message);
    }

    public Breeds() {
    }

    protected Breeds(Parcel in) {
        this.message = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Breeds> CREATOR = new Parcelable.Creator<Breeds>() {
        public Breeds createFromParcel(Parcel source) {
            return new Breeds(source);
        }

        public Breeds[] newArray(int size) {
            return new Breeds[size];
        }
    };
}
