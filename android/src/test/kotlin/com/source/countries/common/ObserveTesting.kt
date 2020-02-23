package com.source.countries.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.coroutineScope

suspend fun <T> LiveData<T>.observeTesting(skipValue: T? = null): T =
    coroutineScope {
        val deffered = CompletableDeferred<T>()
        val observer = object : Observer<T> {
            override fun onChanged(t: T) {
                println(t)
                println("skip = $skipValue, received = $t")
                if(t == skipValue)
                    return

                println("completed $skipValue")
                deffered.complete(t)
                removeObserver(this)
            }
        }
        observeForever(observer)
        deffered.await()
    }