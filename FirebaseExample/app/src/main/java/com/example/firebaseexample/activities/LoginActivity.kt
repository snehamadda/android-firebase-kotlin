package com.example.firebaseexample.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseexample.R
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        loginbtn.setOnClickListener {
            val email = emailET.text.toString()
            val password = passwordET.text.toString()
            loginUser(email, password)
        }
    }

    private fun loginUser(email: String, password: String) {
        auth?.signInWithEmailAndPassword(email, password)?.addOnSuccessListener(OnSuccessListener {
            if (it.user != null) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                val saveDataActivity = Intent(this, SavingDataActivity::class.java)
                startActivity(saveDataActivity)
            }
        })
    }
}
