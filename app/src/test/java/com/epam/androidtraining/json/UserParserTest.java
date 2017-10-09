package com.epam.androidtraining.json;

import com.epam.androidtraining.BuildConfig;
import com.epam.androidtraining.Constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(
    constants = BuildConfig.class,
    sdk = Constants.SDK_VERSION
)
public class UserParserTest {

    private static final String SOURCE = "{\n" +
            "  \"id\" : 1,\n" +
            "  \"name\" : \"First Name and Last Name\",\n" +
            "  \"avatar\" : \"http://placehold.it/32x32\"\n" +
            "}";

    private static final int EXPECTED_ID = 1;
    private static final String EXPECTED_NAME = "First Name and Last Name";
    private static final String EXPECTED_AVATAR = "http://placehold.it/32x32";


    @Test
    public void parse() throws Exception {
        final UserParserFactory userParserFactory = new UserParserFactory();
        final IUser user = userParserFactory.createParser(SOURCE).parse();

        assertEquals(EXPECTED_ID, user.getId());
        assertEquals(EXPECTED_NAME, user.getName());
        assertEquals(EXPECTED_AVATAR, user.getAvatar());
    }

}