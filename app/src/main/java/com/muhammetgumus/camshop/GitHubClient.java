package com.muhammetgumus.camshop;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface GitHubClient {

  /*  @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);
*/
    @GET("/den")
    Call<String> deneme();

  /*  @POST("create")
    Call<String> createAccount(@Body User user);
*/

    
    @Multipart
    @POST("image/text")
    Call<ImageResponse> processImage(@Part MultipartBody.Part body);


}
