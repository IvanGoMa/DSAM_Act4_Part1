package ivangoma.dam2.part1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SuccessActivity : AppCompatActivity() {

    private lateinit var nomField: TextView
    private lateinit var nombreAEndevinar: TextView
    private lateinit var nombreEndevinat: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)


        val btnTorna = findViewById<Button>(R.id.btnTorna)

        val nom = intent.getStringExtra("nomUsuari")
        val numUsuari = intent.getIntExtra("numUsuari", 0)
        val numCorrecte = intent.getIntExtra("numCorrecte", 0)

        nomField = findViewById(R.id.nomUsuari)
        nombreAEndevinar = findViewById(R.id.nombreAEndevinar)
        nombreEndevinat = findViewById(R.id.nombreEndevinat)
        nomField.text = nom
        nombreAEndevinar.text = numCorrecte.toString()
        nombreEndevinat.text = numUsuari.toString()



        btnTorna.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}