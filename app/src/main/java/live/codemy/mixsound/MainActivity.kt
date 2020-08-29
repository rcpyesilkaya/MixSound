package live.codemy.mixsound

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import live.codemy.mixsoundlib.MixSound
import live.codemy.mixsoundlib.SoundType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        imgMicrophone.setOnClickListener {
            MixSound.getInstance(this).recordSound()
            "mic" log this

        }
        img_mana.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.Slow)
            "a" log this
        }
        img_manb.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.Chipmunk)
            "b" log this
        }
        img_manc.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.DarthVader)
            "c" log this
        }
        img_mand.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.Fast)
            "d" log this
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
                        Koyduğum nokta belki so
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
infix fun String.log(context:Context){
    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}