package dmi.ase.intershipexcercises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG=MainActivity.class.getSimpleName();
    private int  incrementValue=0;
    private TextView incremendTv;
    private Button incrementButton;
    private static  final String KEY_PARSE_COUNTER="key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Happy to be born!");
        initViews();
        if(savedInstanceState!=null){
            if(savedInstanceState.getString(savedInstanceState.getString(KEY_PARSE_COUNTER))!=null){
            incrementValue=Integer.parseInt(savedInstanceState.getString(KEY_PARSE_COUNTER));
            incremendTv.setText(savedInstanceState.getString(KEY_PARSE_COUNTER));
        }}

    }
    private void initViews(){
            incremendTv=findViewById(R.id.counter_value_tv);
            incrementButton=findViewById(R.id.increment_btn);

            incremendTv.setText(String.valueOf(incrementValue));
            incrementButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    incrementValue++;
                    incremendTv.setText(String.valueOf(incrementValue));
                }
            });
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
}
