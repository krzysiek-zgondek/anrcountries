package com.source.countries.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.coroutineScope

suspend fun <T> LiveData<T>.observeTesting(): T =
    coroutineScope {
        val deffered = CompletableDeferred<T>()
        val observer = object : Observer<T> {
            override fun onChanged(t: T) {
                deffered.complete(t)
                removeObserver(this)
            }
        }
        observeForever(observer)
        deffered.await()
    }