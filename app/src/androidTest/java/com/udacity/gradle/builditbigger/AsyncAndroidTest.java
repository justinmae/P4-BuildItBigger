package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

/**
 * Created by justinmae on 4/30/16.
 */
public class AsyncAndroidTest extends AndroidTestCase{
    public void testVerifyAsyncResponse() {
        String result = null;
        try {
            result = new EndpointsAsyncTask().execute(getContext()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(result);
    }
}
