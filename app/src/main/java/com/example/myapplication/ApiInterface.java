package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
   @POST("/api/users")
   Call<User> getUserInfo(@Field("name") String name, @Field("job") String job);

    @FormUrlEncoded
    @POST("/api/posts")
    Call<Post> getPostInfo(@Field("title") String title, @Field("description") String desc, @Field("content") String content);
}
