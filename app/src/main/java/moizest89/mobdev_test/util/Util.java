package moizest89.mobdev_test.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by moizest89 on 2/24/18.
 */

public class Util {

    public final static int ANIMATION_DELAY = 800;
    public final static int ANIMATION_DELAY_TOOLBAR = 200;
    public final static String SAVE_INSTANCE = "save_instance";
    public final static String INTENT_SENDED_DATA = "sended_data";


    public static void changeActivity(Context context, Class<?> target, Bundle options, boolean finish) {
        Intent i = new Intent(context, target);

        if (options != null)
            i.putExtras(options);

        context.startActivity(i);

        // Close the activity so the user won't able to go back this
        // activity pressing Back button
        if (finish)
            ((Activity) context).finish();

    }


    public static String capitalizeText(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1);

    }

}
