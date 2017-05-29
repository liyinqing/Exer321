package atguigu.com.exer321;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

public class WelcomeActivity extends AppCompatActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMain();
            }


        }, 2000);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startMain();
        return super.onTouchEvent(event);
    }

    private void startMain() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        if(handler != null){
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
        super.onDestroy();

    }
}
