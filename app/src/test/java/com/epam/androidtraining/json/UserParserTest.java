package com.epam.androidtraining.json;

import com.epam.androidtraining.BuildConfig;
import com.epam.androidtraining.Constants;
import com.epam.androidtraining.http.HttpClient;
import com.epam.androidtraining.http.IHttpClient;
import com.epam.androidtraining.mocks.Mocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)
public class UserParserTest {

    private static final String TAG = UserParserTest.class.getSimpleName();

    private static final String SOURCE = "{\n" +
            "  \"id\" : 1,\n" +
            "  \"name\" : \"First Name and Last Name\",\n" +
            "  \"avatar\" : \"http://placehold.it/32x32\"\n" +
            "}";

    private static final int EXPECTED_ID = 1;
    private static final String EXPECTED_NAME = "First Name and Last Name";
    private static final String EXPECTED_AVATAR = "http://placehold.it/32x32";

    @Mock
    private IHttpClient mHttpClient;

    @Captor
    private ArgumentCaptor<HttpClient.ResponseListener> mResponseListenerArgumentCaptor;

    @Before
    public void setUp() {
        mHttpClient = mock(IHttpClient.class);
    }

    @Test
    public void parse() throws Exception {
        final UserParserFactory userParserFactory = new UserParserFactory();
        final IUser user = userParserFactory.createParser(SOURCE).parse();

        assertEquals(EXPECTED_ID, user.getId());
        assertEquals(EXPECTED_NAME, user.getName());
        assertEquals(EXPECTED_AVATAR, user.getAvatar());
    }

    @Test
    public void parseUserListFromResource() throws Exception {
        InputStream mockedInputStream = Mocks.stream("user/user_list.json");
//        mHttpClient.request(anyString(), mResponseListenerArgumentCaptor.capture());
        mResponseListenerArgumentCaptor.getValue().onError(new Exception());

//        final UsersListParserFactory usersListParserFactory = new UsersListParserFactory();
//        final IUsersList userList = usersListParserFactory.createParser(response).parse();
//        assertTrue(userList.getUsersList().size() == 2);
//        assertTrue(userList.getUsersList().get(0).getId() == 1);
//        assertEquals(userList.getUsersList().get(0).getName(), "First Name and Last Name");
//
//
//        InputStream mockedInputStreamWithObject = Mocks.stream("user/user_list_with_root_object.json");
//        when(mHttpClient.request(anyString())).thenReturn(mockedInputStreamWithObject);
//        InputStream responseWithObject = mHttpClient.request("http://myBackend/getUserListWithObject");
//
//        final IUsersList userListWithObject = usersListParserFactory.createParserForResponceWithObject(responseWithObject).parse();
//        assertTrue(userListWithObject.getUsersList().size() == 2);

    }

}