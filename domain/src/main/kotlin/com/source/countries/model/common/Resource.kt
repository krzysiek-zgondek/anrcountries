package com.source.countries.model.common


sealed class Resource<T> {
    class Success<T>(val resource: T) : Resource<T>()
    class Error<T>(val reason: Throwable) : Resource<T>()
}

/**
 * Either provides result of [provider] execution [Resource.Success] or
 * error [Resource.Error]
 * */
inline fun <reified T> resource(provider: () -> T): Resource<T> {
    return try {
        Resource.Success(provider())
    } catch (reason: Throwable) {
        Resource.Error(reason)
    }
}

inline fun <reified T> Resource<T>.onSuccess(receiver: (T) -> Unit): Resource<T> {
    if (this is Resource.Success)
        receiver(resource)
    return this
}

inline fun <reified T> Resource<T>.onFailed(receiver: (Throwable) -> Unit): Resource<T> {
    if (this is Resource.Error)
        receiver(reason)
    return this
}