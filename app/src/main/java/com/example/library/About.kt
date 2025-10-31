package com.example.library
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale


class About : AppCompatActivity() {
    //Declare a tts variable.
    lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        //find text view and button
        val textView = findViewById<TextView>(R.id.textView)
        val speakButton = findViewById<Button>(R.id.speakButton)
        //Create a TTS object, check if tts is available and set Language
        tts = TextToSpeech(this) {
            if (it == TextToSpeech.SUCCESS) {
                tts.language = Locale.US
            }
        }//end
        //Set button listener
        speakButton.setOnClickListener {
            val text = textView.text.toString() //get text from text View
            //ask tts to speak the text from textview above
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }//end
    }//end

    //Stop the tts from speaking when app is closed/destroyed/killed
    override fun onDestroy() {
        tts.stop() //stops tts
        tts.shutdown()
        super.onDestroy()
    }
    }
