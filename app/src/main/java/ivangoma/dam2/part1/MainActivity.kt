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

class MainActivity : AppCompatActivity() {
    private lateinit var date: TextView
    private lateinit var btn: Button
    private lateinit var nom: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        date = findViewById(R.id.editTextDate)
        btn = findViewById(R.id.btnIniciar)
        nom = findViewById(R.id.editText)
        btn.setOnClickListener {
            val nombre =  nom.text.toString()
            navigate(nombre)
        }
        val dateFormat: java.text.DateFormat = SimpleDateFormat(
            "dd-MM-yyyy",
            Locale.getDefault()
        )

        val currentDateString: String = dateFormat.format(Date())
        date.text = currentDateString
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun navigate(nom:String){
        val intent = Intent(this, StartActivity::class.java)
        intent.putExtra("nom",nom)
        startActivity(intent)
    }
}