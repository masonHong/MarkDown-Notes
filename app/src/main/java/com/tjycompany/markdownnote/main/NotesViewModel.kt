package com.tjycompany.markdownnote.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.tjycompany.markdownnote.model.AllNotesItem
import com.tjycompany.markdownnote.room.dao.NotesDao
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class NotesViewModel(private val notesDao: NotesDao) : ViewModel() {
    val allNotes = MutableLiveData<List<AllNotesItem>>()
    private val _allNotes = ArrayList<AllNotesItem>()
    private var disposable: Disposable? = null

    fun getAllNotes() {
        disposable = notesDao.all()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            _allNotes.clear()
                            _allNotes.addAll(it)
                            allNotes.value = _allNotes
                        },
                        {
                            Timber.i(it)
                        }
                )
    }

    fun createNote(note: AllNotesItem) {
        Single.fromCallable { notesDao.insert(note) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        _allNotes.add(note)
        allNotes.value = _allNotes
    }

    override fun onCleared() {
        if (disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}