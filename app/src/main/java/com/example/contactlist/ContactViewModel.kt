package com.example.contactlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactlist.db.Contact
import com.example.contactlist.db.ContactDao
import kotlinx.coroutines.launch

class ContactViewModel(private val dao: ContactDao):ViewModel() {

    val contacts = dao.getAllContacts()

    fun insertContact(contact: Contact) = viewModelScope.launch {
        dao.insertContact(contact)
    }

    fun updateContact(contact: Contact) = viewModelScope.launch {
        dao.updateContact(contact)
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch {
        dao.deleteContact(contact)
    }

}