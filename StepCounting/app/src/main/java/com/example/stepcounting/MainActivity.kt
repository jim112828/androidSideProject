package com.example.stepcounting

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), SensorEventListener {

    private var sensorManager: SensorManager? = null

    private var running = false

    private var totalSteps = 0f

    private var previousTotalSteps = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()

        resetSteps()

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    /**
     * {@inheritDoc}
     *
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are *not* resumed.
     */
    override fun onResume() {
        super.onResume()

        running = true

        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor == null) {
            Toast.makeText(this, "No sensor detected on this device", Toast.LENGTH_SHORT).show()

        } else {
            sensorManager?.registerListener(this,stepSensor, SensorManager.SENSOR_DELAY_UI)
        }

    }

    private fun resetSteps() {
        var tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
        tv_stepsTaken.setOnClickListener{
            Toast.makeText(this,"Long tap to reset steps", Toast.LENGTH_SHORT).show()
        }

        tv_stepsTaken.setOnLongClickListener {
            previousTotalSteps = totalSteps

            tv_stepsTaken.text = 0.toString()

            saveData()

            true

        }

    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("key1",previousTotalSteps)
        editor.apply()

    }

    private fun loadData() {
        val sharePreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val saveNumber = sharePreferences.getFloat("key1",0f)
        Log.d("MainActivity","$saveNumber")

        previousTotalSteps = saveNumber

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
        if (running) {
            totalSteps = event!!.values[0]

            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()

            tv_stepsTaken.text= ("$currentSteps")

        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}