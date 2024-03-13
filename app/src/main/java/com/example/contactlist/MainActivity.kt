package com.example.contactlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.contactlist.db.Contact
import com.example.contactlist.db.ContactDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button

    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.etName)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameEditText = findViewById(R.id.etName)
        emailEditText = findViewById(R.id.etEmail)
        saveButton = findViewById(R.id.btnSave)
        clearButton = findViewById(R.id.btnClear)

        val dao = ContactDatabase.getInstance(application).contactDao()
        val factory = ContactViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(ContactViewModel::class.java)

        saveButton.setOnClickListener {
            saveContactData()
            clearInput()
        }

        clearButton.setOnClickListener {
            clearInput()
        }

    }
    private fun saveContactData() {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val contact = Contact(0, name, email )
        viewModel.insertContact(contact)
    }

    private fun clearInput() {
        nameEditText.setText("")
        emailEditText.setText("")
    }
}