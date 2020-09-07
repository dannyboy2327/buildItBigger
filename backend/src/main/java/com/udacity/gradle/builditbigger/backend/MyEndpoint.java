package com.udacity.gradle.builditbigger.backend;

import com.example.jokeprovider.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;


/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getTheJoke")
    public MyJoke getTheJoke() {
        JokeProvider jokeProvider = new JokeProvider();
        String joke = jokeProvider.getJoke();
        MyJoke response = new MyJoke();
        response.setData(joke);

        return response;
    }

}
