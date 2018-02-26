package moizest89.mobdev_test;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import moizest89.mobdev_test.base.MvpView;
import moizest89.mobdev_test.ui.details.list.ListDetailsActivity;
import moizest89.mobdev_test.ui.details.list.ListDetailsPresenter;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by moizest89 on 2/25/18.
 */

public class MainDetailsViewTest {

    @Mock
    Context context;

    ListDetailsPresenter presenter;
    @Mock
    ListDetailsActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = Mockito.mock(ListDetailsPresenter.class);
        presenter = new ListDetailsPresenter(context);
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
