package mx.edu.utng.apptodoenuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_juego.*
import java.util.*
import kotlin.collections.ArrayList

class Juego : AppCompatActivity() {
    var handled: Handler= Handler()
    var runnab: Runnable= Runnable {  }
    var puntos : Int =0
    var imagenes = ArrayList<ImageView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        button3.setOnClickListener() {
            finish()
        }
        button4.setOnClickListener() {


        puntos = 0
        imagenes =
            arrayListOf(image1, image2, image3, image4, image5, image6, image7, image8, image9)
        esconderImg()
        object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                txtTime.text = "Se acabo el tiempo"
                handled.removeCallbacks(runnab)
                for (imagen in imagenes) {
                    imagen.visibility = View.INVISIBLE
                }
            }

            override fun onTick(millisUntilFinished: Long) {
                txtTime.text = "Tiempo:" + millisUntilFinished / 1000
            }

        }.start()
    }
    }
    fun esconderImg(){
        runnab= object : Runnable{
            override fun run() {
                for(imagen in imagenes){
                    imagen.visibility=View.INVISIBLE
                }
                val aleatorio = Random()
                val index = aleatorio.nextInt(8 - 0)
                imagenes[index].visibility=View.VISIBLE
                handled.postDelayed(runnab ,500)

            }

        }
handled.post(runnab)
    }
    fun incrementar (view: View){
puntos ++
        txtScore.text="Puntos: "+puntos
    }
}
