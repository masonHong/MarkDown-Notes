package com.tjycompany.markdownnote.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.tjycompany.markdownnote.model.AllNotesItem
import com.tjycompany.markdownnote.room.AppDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by mason-hong on 2018. 10. 27..
 */
class NotesViewModel(private val database: AppDatabase) : ViewModel() {
    val allNotes = MutableLiveData<List<AllNotesItem>>()
    private var disposable: Disposable? = null

    fun getAllNotes() {
        disposable = database.notesDao().getAllNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            allNotes.value = it
                        },
                        {
                            Timber.i(it)
                        }
                )
    }

    override fun onCleared() {
        if (disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}