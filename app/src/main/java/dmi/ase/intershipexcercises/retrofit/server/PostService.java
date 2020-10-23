package dmi.ase.intershipexcercises.retrofit.server;

import java.util.List;

import dmi.ase.intershipexcercises.retrofit.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("/posts")
    Call<List<Post>> getPosts();
}
