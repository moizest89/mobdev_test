package moizest89.mobdev_test;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListAdapter;

import com.android.dx.command.Main;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import moizest89.mobdev_test.data.manager.DataManager;
import moizest89.mobdev_test.data.manager.DataManagerCallBack;
import moizest89.mobdev_test.data.models.Breeds;
import moizest89.mobdev_test.ui.main.IMainView;
import moizest89.mobdev_test.ui.main.MainActivity;
import moizest89.mobdev_test.ui.main.MainAdapter;
import moizest89.mobdev_test.ui.main.MainPresenter;
import moizest89.mobdev_test.util.Util;

import static android.content.ContentValues.TAG;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock private Context context;
    @Mock private DataManager dataManager;
    @Mock private DataManagerCallBack dataManagerCallBack;
    @Mock private IMainView mainView;
    @Mock private MainPresenter mainPresenter;


    @Test
    public void verifyModel(){

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add(i, "item_"+i);
        }
        Breeds breeds = new Breeds(data);

        assertEquals(30, breeds.getData().size());
        assertThat(breeds.getData().get(0), is("item_0"));

    }



    @Test
    public void adapterHasData(){

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add(i, "item_"+i);
        }
        MainAdapter mainAdapter = new MainAdapter();
        mainAdapter.setData(data);
        assertEquals(30, mainAdapter.getItemCount());
        assertEquals("item_5", mainAdapter.getItemValue(5));

    }


    @Test
    public void verifyDataFromService(){

        final Breeds breeds = new Breeds();

//        when(mockMovieAPIService.getPopular(anyString())).thenReturn(Observable.just(results));
//        when(dataManager.getAllBreadsItems(dataManagerCallBack)).thenReturn(breeds);

    }


    @Test
    public void testCapitalizeText(){

        assertEquals("Title", Util.capitalizeText("title"));
    }


    @Rule
    public ActivityTestRule<MainActivity> rule  = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureRecyclerViewIsPresent() throws Exception {

        MainActivity activity = rule.getActivity();
        RecyclerView viewById = activity.findViewById(R.id.recyclerView);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(RecyclerView.class));
        RecyclerView recyclerView = (RecyclerView) viewById;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        assertThat(adapter, instanceOf(RecyclerView.Adapter.class));
        assertThat(adapter.getItemCount(), greaterThan(5));

    }


}
