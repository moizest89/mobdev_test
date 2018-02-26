package moizest89.mobdev_test;

import android.content.Context;
import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import moizest89.mobdev_test.base.MvpView;
import moizest89.mobdev_test.ui.main.MainActivity;
import moizest89.mobdev_test.ui.main.MainPresenter;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

/**
 * Created by moizest89 on 2/25/18.
 */
@RunWith(AndroidJUnit4.class)
public class MainViewTest {

//    private MainActivity mainActivity;


    @Mock
    Context context;

    MainPresenter presenter;
    @Mock
    MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = Mockito.mock(MainPresenter.class);
        presenter = new MainPresenter(context);
        presenter.attachView(mainActivity);
    }


    @Test
    public void viewIsAttached(){
        assertThat(presenter.isViewAttached(), is(true));
    }

    @Test
    public void viewIsDettached(){

        assertNotNull(presenter.getMvpView());
        presenter.detachView();
        assertNull(presenter.getMvpView());

    }

    @Test
    public void verifyKindOfView(){
        assertThat(presenter.getMvpView(), instanceOf(MvpView.class));
    }

}
