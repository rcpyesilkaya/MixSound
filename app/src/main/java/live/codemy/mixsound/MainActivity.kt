package live.codemy.mixsound

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import live.codemy.mixsoundlib.MixSound
import live.codemy.mixsoundlib.SoundType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val imgMic = findViewById<ImageButton>(R.id.imgb_mic)
        val imgbFast: ImageButton = findViewById<ImageButton>(R.id.imgb_fast)
        val imgbSlow = findViewById<ImageButton>(R.id.imgb_slow)
        val imgbDarthVader = findViewById<ImageButton>(R.id.imgb_darth_vader)
        val imgbChimpmunk = findViewById<ImageButton>(R.id.imgb_chimpmunk)

        imgMic.setOnClickListener {

            MixSound.getInstance(this).recordSound()

            "imgMic clicked !! " extShowToast this
        }

        imgbSlow.setOnClickListener {

            MixSound.getInstance(this).changeSound(SoundType.Slow)

            "imgbSlow clicked !! " extShowToast this
        }

        imgbDarthVader.setOnClickListener {

            MixSound.getInstance(this).changeSound(SoundType.DarthVader)

            "imgbDarthVader clicked !! " extShowToast this
        }

        imgbChimpmunk.setOnClickListener {

            MixSound.getInstance(this).changeSound(SoundType.Chipmunk)

            "imgbChimpmonk clicked !! " extShowToast this
        }

        imgbFast.setOnClickListener {

            MixSound.getInstance(this).changeSound(SoundType.Fast)

            "imgbFast clicked !! " extShowToast this
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            MixSound.CODE_SPEECH_RECOGNIZER -> {
                data?.let {
                    val result = it.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
//                    MixSound.recordSound = result.first()
                    MixSound.recordSound = """
                        
                        Koyduğum nokta belki son
                        Ben bunu bilemem aynı bomb
                        Gibi gelir sana belki de aynı ton
                        Dibi delik gelebilir ama aynı fon
                        Kendini bilemez montofon
                        Ve monoton yaşar hep alt aynı don
                        Anlatırım ben derdimi yalnız
                        Ey, bi' mini microphone
                        
                        Şimdi bana bi' bakınız hadi
                        Muamelesi kesebilir hasi
                        Ve de Muhammed Ali gibi gelir asi
                        Bana bak, beni gör ve de öl vasi
                        Sesim hep duyulur tepeden bariton
                        Mekanım olabilir her an ozon
                        Yanıma gelenin canına girecektir
                        Ey, bi' mini microphone
                        
                        
                    """.trimIndent()
                }
            }
        }
    }

    override fun onStop() {

        MixSound.getInstance(this).textToSpeech.stop()
        MixSound.getInstance(this).textToSpeech.shutdown()

        super.onStop()
    }
}

infix fun String.extShowToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}