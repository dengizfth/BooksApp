package com.canerture.booksapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.booksapp.repos.BooksRepository
import com.canerture.booksapp.model.Books

class BooksCartFragmentViewModel: ViewModel() {

    private val mrepo = BooksRepository()
    var cartBooks = MutableLiveData<ArrayList<Books>>()

    init {
        getCartBooks()
    }

    private fun getCartBooks() {
        mrepo.getCartBooks()
        cartBooks = mrepo.cartBooksList()
    }

    fun deleteCartBook(bookId: Int) {
        mrepo.cartStatusChange(bookId, 0)
        mrepo.getCartBooks()
    }

}