package com.example.uidashboard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backB: ImageButton =findViewById(R.id.backB)
        val logOutB: ImageButton = findViewById(R.id.logOutB)
        val profileB: ImageButton = findViewById(R.id.profileB)

        val todoB: Button = findViewById(R.id.todoB)
        val editProfileB: Button = findViewById(R.id.profileB)

        val contributeCard: CardView = findViewById(R.id.contributeCard)
        val practiceCard: CardView = findViewById(R.id.practiceCard)
        val learnCard: CardView = findViewById(R.id.learnCard)
        val interestsCard: CardView = findViewById(R.id.interestsCard)
        val helpCard: CardView = findViewById(R.id.helpCard)
        val settingsCard: CardView = findViewById(R.id.settingsCard)

        backB.setOnClickListener {
            Toast.makeText(this, "Back Button", Toast.LENGTH_SHORT).show()
        }
        logOutB.setOnClickListener {
            Toast.makeText(this, "Logout Button", Toast.LENGTH_SHORT).show()
        }

        profileB.setOnClickListener {
            Toast.makeText(this, "Profile Image", Toast.LENGTH_SHORT).show()
        }


        // handle each of the buttons with the OnClickListener
        todoB.setOnClickListener {
            Toast.makeText(this, "TODO LIST", Toast.LENGTH_SHORT).show()
        }
        editProfileB.setOnClickListener {
            Toast.makeText(this, "Editing Profile", Toast.LENGTH_SHORT).show()
        }


        // handle each of the cards with the OnClickListener
        contributeCard.setOnClickListener {
            Toast.makeText(this, "Contribute Articles", Toast.LENGTH_SHORT).show()
        }
        practiceCard.setOnClickListener {
            Toast.makeText(this, "Practice Programming", Toast.LENGTH_SHORT).show()
        }
        learnCard.setOnClickListener {
            Toast.makeText(this, "Learn Programming", Toast.LENGTH_SHORT).show()
        }
        interestsCard.setOnClickListener {
            Toast.makeText(this, "Filter your Interests", Toast.LENGTH_SHORT).show()
        }
        helpCard.setOnClickListener {
            Toast.makeText(this, "Anything Help you want?", Toast.LENGTH_SHORT).show()
        }
        settingsCard.setOnClickListener {
            Toast.makeText(this, "Change the settings", Toast.LENGTH_SHORT).show()
        }



    }
}

