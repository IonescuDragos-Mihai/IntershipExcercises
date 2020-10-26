package dmi.ase.intershipexcercises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import dmi.ase.intershipexcercises.retrofit.Post;
import dmi.ase.intershipexcercises.retrofit.server.ServerProvider;
import dmi.ase.intershipexcercises.thread.DownloaderUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements  OnMapReadyCallback{
    public static final String TAG=MainActivity.class.getSimpleName();
    private int  incrementValue=0;
    private TextView incremendTv;
    private Button incrementButton;
    private static  final String KEY_PARSE_COUNTER="key";
    private ImageView imageDownload;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageDownload=findViewById(R.id.image_download);

        Log.d(TAG,"Happy to be born!");
        initViews();
        if(savedInstanceState!=null){
            if(savedInstanceState.getString(savedInstanceState.getString(KEY_PARSE_COUNTER))!=null){
            incrementValue=Integer.parseInt(savedInstanceState.getString(KEY_PARSE_COUNTER));
            incremendTv.setText(savedInstanceState.getString(KEY_PARSE_COUNTER));
        }}

        //retrofit

      //  getPostSynchrously();


        getPostAsynchrously();
        
        
        getImageUsingThread();
        getImageUsingExecutor();


        MapView mapView=findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        mapView.getMapAsync((OnMapReadyCallback)this);

    }




    private void getImageUsingThread() {
//        Handler handler = new Handler();
//
//        final Runnable r = new Runnable() {
//            public void run() {
//               imageDownload.setImageBitmap(DownloaderUtil.INSTANCE.downloadImage());
//            }
//        };
//
//        handler.postDelayed(r, 1000);
    }

    private void getImageUsingExecutor() {
    }
    
    

    private void getPostAsynchrously() {
//        ServerProvider.createPostService().getPosts().enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                List<Post> posts=response.body();
//                if(posts!=null){
//                    Log.d(TAG,"there are "+posts.size());
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                Log.e(TAG,"error trying to get posts");
//            }
//        });
    }

//    private void getPostSynchrously() {
//        try {
//            Response<List<Post>> response= ServerProvider.createPostService().getPosts().execute();
//            List<Post> list=response.body();
//
//            if(list!=null){
//                Log.d(TAG,"there are "+list.size());
//            }
//        } catch (IOException e) {
//            Log.e(TAG,"error trying to get posts");
//
//        }
//    }

    private void initViews(){
            incremendTv=findViewById(R.id.counter_value_tv);
            incrementButton=findViewById(R.id.increment_btn);

//            incremendTv.setText(String.valueOf(incrementValue));
//            incrementButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    incrementValue++;
//                    incremendTv.setText(String.valueOf(incrementValue));
//                }
//            });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart:I exist ,but you connot see me!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume:Preparing finail UI changes for you master!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause:You can see me,but I don;t want to interact!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop:Packing up to leave!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy:Bye bye!");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_PARSE_COUNTER,incremendTv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        incremendTv.setText(savedInstanceState.getString(KEY_PARSE_COUNTER));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng coord=new LatLng(46/76766919,23.5709693);
        googleMap.addMarker(new MarkerOptions().position(coord));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coord,16));
    }
}
