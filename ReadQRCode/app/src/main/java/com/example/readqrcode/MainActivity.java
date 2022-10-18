package com.example.readqrcode;

import static android.Manifest.permission.VIBRATE;
import static android.Manifest.permission_group.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import eu.livotov.labs.android.camview.ScannerLiveView;
import eu.livotov.labs.android.camview.scanner.decoder.zxing.ZXDecoder;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ScannerLiveView camera;
    private TextView scannedTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkPermission()){
            Toast.makeText(this,"Permission Granted...", Toast.LENGTH_SHORT).show();

        }else{
            requestPermission();
        }

        scannedTV = findViewById(R.id.idTVscanned);
        camera = findViewById(R.id.camview);

        camera.setScannerViewEventListener(new ScannerLiveView.ScannerViewEventListener() {
            @Override
            public void onScannerStarted(ScannerLiveView scanner) {
                // method is called when scanner is started
                Toast.makeText(MainActivity.this, "Scanner Started", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onScannerStopped(ScannerLiveView scanner) {
                // method is called when scanner is stopped.
                Toast.makeText(MainActivity.this, "Scanner Stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onScannerError(Throwable err) {
                // method is called when scanner gives some error.
                Toast.makeText(MainActivity.this, "Scanner Error: " + err.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeScanned(String data) {
                // method is called when camera scans the
                // qr code and the data from qr code is
                // stored in data in string format.
                scannedTV.setText(data);
            }
        });

    }

    @Override
    protected void onResume() {

        super.onResume();
        ZXDecoder decoder = new ZXDecoder();
        decoder.setScanareaPercent(0.8);
        camera.setDecoder(decoder);
        camera.startScanner;
    }

    @Override
    protected void onPause() {
        camera.stopScanner();
        super.onPause();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length> 0){
            boolean cameraaccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            boolean vibrateaccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
            if ( cameraaccepted && vibrateaccepted) {
                Toast.makeText(this,"Permission granted...", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Permission Denined \n You cannot use app without providing permission"
                , Toast.LENGTH_SHORT).show();
            }
        }


    }




    private boolean checkPermission(){
        int camera_permission = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        int vibrate_permission = ContextCompat.checkSelfPermission(getApplicationContext(), VIBRATE);
        return camera_permission == PackageManager.PERMISSION_GRANTED &&
                vibrate_permission == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission(){
        int PERMISSION_REQUEST_CODE = 200;
        ActivityCompat.requestPermissions(this,new String[]{CAMERA,VIBRATE},PERMISSION_REQUEST_CODE);
    }

}