package com.example.firebaseexample.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseexample.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_saving_data.*

class SavingDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saving_data)

        addBtn.setOnClickListener {
            try {
                val name = nameET.text.toString()
                val email = emailET.text.toString()
                if (name.isEmpty() || email.isEmpty()) {
                    Toast.makeText(this, "Please enter name and email", Toast.LENGTH_SHORT).show()
                } else {
                    val db = FirebaseDatabase.getInstance().reference
                    db.child("Name").setValue(name).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Success data saved name", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(this, "Failed to save name", Toast.LENGTH_SHORT).show()
                        }

                    }
                    db.child("Email").setValue(email).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Success data saved email", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(this, "Failed to save email", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
}

