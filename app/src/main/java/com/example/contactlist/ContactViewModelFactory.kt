package com.example.contactlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactlist.db.ContactDao

class ContactViewModelFactory(private val dao : ContactDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContactViewModel::class.java)){
            return ContactViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}