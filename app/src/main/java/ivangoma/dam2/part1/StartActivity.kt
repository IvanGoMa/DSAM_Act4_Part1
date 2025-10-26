package ivangoma.dam2.part1
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class StartActivity : AppCompatActivity(){

    private lateinit var btn: Button
    private lateinit var nomField: TextView
    private lateinit var nombreUsuari: EditText
    private lateinit var btnTorna: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)
        val nom = intent.extras?.getString("nom")
        val nombreEndevinar = (1..3).random()

        nombreUsuari = findViewById(R.id.input)
        btn=findViewById(R.id.btnOk)
        btnTorna=findViewById(R.id.btnTorna)
        nomField = findViewById(R.id.nomUsuari)
        nomField.text = nom

        btn.setOnClickListener {
            var intent2 = Intent(this, SuccessActivity::class.java)
            if(nombreUsuari.text.toString().toInt() != nombreEndevinar ){
                intent2 = Intent(this, ErrorActivity::class.java)
            }
            intent2.putExtra("nomUsuari",nom)
            intent2.putExtra("numUsuari", nombreUsuari.text.toString().toInt())
            intent2.putExtra("numCorrecte", nombreEndevinar)
            startActivity(intent2)
        }

        btnTorna.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }
}