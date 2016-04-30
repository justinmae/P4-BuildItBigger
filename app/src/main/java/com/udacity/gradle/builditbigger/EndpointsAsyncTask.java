package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

import gradle.udacity.com.displaylibrary.DisplayActivity;

/**
 * Created by justinmae on 4/24/16.
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://p4-builditbigger-1296.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.putJoke(new MyBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(context, DisplayActivity.class);
        intent.putExtra(DisplayActivity.JOKE_KEY, result);
        context.startActivity(intent);
    }
}
