package demo.ayaz.colourchangingbackgrounddemo;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RelativeLayout rel;
    Button start,stop;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.btn_start);
        stop=(Button)findViewById(R.id.btn_Stop);
        rel=(RelativeLayout)findViewById(R.id.rel_back);
        animationDrawable=(AnimationDrawable) rel.getBackground();


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.start();
                start.setAlpha(1f);
                stop.setAlpha(0.5f);
                Toast.makeText(getApplicationContext(),"Animation:started",Toast.LENGTH_SHORT).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.stop();
                start.setAlpha(0.5f);
                stop.setAlpha(1f);
                Toast.makeText(getApplicationContext(),"Animation:stopped",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        if(animationDrawable!=null)
        {
            animationDrawable.stop();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(animationDrawable!=null)
        {
            animationDrawable.start();
        }
        else
        {
            animationDrawable=(AnimationDrawable) rel.getBackground();
            animationDrawable.start();
        }
    }
}
