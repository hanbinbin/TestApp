package com.gomore.adv;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;//定义sensor管理器
    private Vibrator vibrator;           //震动

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.first);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApplication.getInstance(), SecondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getInstance().startActivity(intent);
            }
        });
        //获取传感器管理服务
        mSensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        //震动
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        //values[0]:X轴，values[1]：Y轴，values[2]：Z轴
        float[] values = event.values;
        if (sensorType == Sensor.TYPE_ACCELEROMETER) {
             /*  因为一般正常情况下，任意轴数值最大就在9.8~10之间，只有在你突然摇动手机
              *  的时候，瞬时加速度才会突然增大或减少，所以，经过实际测试，只需监听任一轴的
              *  加速度大于14的时候，改变你需要的设置就OK了
              */
            if (Math.abs(values[0]) > 20) {
                //摇动手机后，再伴随震动提示~~
                vibrator.vibrate(500);
                mSensorManager.unregisterListener(this);
                //摇动手机后，设置button上显示的字为空
                Log.e("y", "123465443524516732615");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //当传感器精度改变时回调该方法，Do nothing.
    }

    @Override
    protected void onResume() {
        super.onResume();
        //加速度传感器 注册监听
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                //还有SENSOR_DELAY_UI、SENSOR_DELAY_FASTEST、SENSOR_DELAY_GAME等，
                //根据不同应用，需要的反应速率不同，具体根据实际情况设定
                SensorManager.SENSOR_DELAY_FASTEST);
        Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "测试1", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        //取消注册
        mSensorManager.unregisterListener(this);
        vibrator.cancel();
    }
}
