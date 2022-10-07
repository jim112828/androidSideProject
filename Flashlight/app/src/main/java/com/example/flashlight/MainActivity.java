package com.example.flashlight;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleFlashLightOnOff;
    private CameraManager cameraManager;
    private String getCameraID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleFlashLightOnOff = findViewById(R.id.toggle_flashlight);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            getCameraID = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    public void  setToggleFlashLight(View view){
        if (toggleFlashLightOnOff.isChecked()){
            try {
                cameraManager.setTorchMode(getCameraID, true);

                Toast.makeText(MainActivity.this, "Flashlight is turned ON", Toast.LENGTH_LONG ).show();
            }catch (CameraAccessException e){
                e.printStackTrace();
            }
        }else {
            try {
                cameraManager.setTorchMode(getCameraID, false);
                Toast.makeText(MainActivity.this, "Flashlight is turned OFF", Toast.LENGTH_LONG ).show();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void finish(){
        super.finish();
        try {
            cameraManager.setTorchMode(getCameraID, false);
            Toast.makeText(MainActivity.this, "Flashlight is turned OFF", Toast.LENGTH_LONG ).show();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


}