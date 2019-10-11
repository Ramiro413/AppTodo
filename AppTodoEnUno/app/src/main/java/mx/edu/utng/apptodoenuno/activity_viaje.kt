package mx.edu.utng.apptodoenuno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_viaje.*

class activity_viaje : AppCompatActivity() {
    var KmcienGas:Double =0.0
    var KmcienDin:Double =0.0
    var Km =0
    var lgasgastados: Double =0.0
    var lgasgastadosporKM: Double =0.0
    var tiempo1: Double =0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viaje)
        button.setOnClickListener(){
            var Kilom : Double = Kilometros.text.toString().toDouble()
            var Preciogas : Double = PrecioGaso.text.toString().toDouble()
            var DineroGas : Double = DineroGas.text.toString().toDouble()
            var  tiempo : Double = Tie.text.toString().toDouble()
            lgasgastados=(DineroGas/Preciogas)//   30=600/20
            lgasgastadosporKM=(lgasgastados/Kilom) //3.75=30/8
            KmcienGas=(lgasgastadosporKM*100)//375=3.75*100
            KmcienDin=(Preciogas*lgasgastadosporKM)//7500=600*3.75
            tiempo1=(Kilom/tiempo)
            txtResultado100.text="Se consumen ${KmcienGas} litros de gasolina y  $${100*KmcienDin}  pesos "
            txtConsumo1KM.text="Se consumen ${lgasgastadosporKM} litros de gasolina y $${KmcienDin}  pesos "
            tiemp.text = "${tiempo1} KM/H"

        }
        button2.setOnClickListener(){
            finish()
        }
    }

}
