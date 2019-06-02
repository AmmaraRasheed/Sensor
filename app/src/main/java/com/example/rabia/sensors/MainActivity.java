package com.example.rabia.sensors;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity implements SensorEventListener {
//    private SensorManager sensorManager;
//    private Sensor mSensor;
private SensorManager sensorManager;
    private Sensor mLight;
    float lux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

//        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
////        Toast.makeText(getApplicationContext(),"Sensor in my device"+deviceSensors,Toast.LENGTH_LONG).show();
//
//
//        if (sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) != null){
//            Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_LONG).show();
//        }


//        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        mSensor = null;
//
//        if (sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) != null){
//            List<Sensor> gravSensors = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);
//            for(int i=0; i<gravSensors.size(); i++) {
//                Toast.makeText(getApplicationContext()," Vendor "+gravSensors.get(i).getVendor(),Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext()," Vendor "+gravSensors.get(i).getVersion(),Toast.LENGTH_LONG).show();
//                if ((gravSensors.get(i).getVendor().contains("Google LLC")) &&
//                        (gravSensors.get(i).getVersion() == 3)){
//                    // Use the version 3 gravity sensor.
//                    mSensor = gravSensors.get(i);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"No  ",Toast.LENGTH_LONG).show();
//                }
//            }
//        }
//        if (mSensor == null){
//            // Use the accelerometer.
//            if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
//                mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//                Toast.makeText(getApplicationContext(),"Yes ACCELEROMETER",Toast.LENGTH_LONG).show();
//            } else{
//                Toast.makeText(getApplicationContext(),"No sensor ",Toast.LENGTH_LONG).show();
//            }
//        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
         lux = event.values[0];
        Toast.makeText(getApplicationContext(),"light is  "+lux,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
