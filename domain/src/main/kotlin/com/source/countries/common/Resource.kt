package com.source.countries.common


sealed class Resource<T> {
    class Success<T>(val value: T) : Resource<T>()
    class Error<T>(val reason: Throwable) : Resource<T>()

    companion object{
        inline fun <reified T> success(value: T): Resource<T> {
            return Success(value)
        }

        inline fun <reified T> error(reason: Throwable): Resource<T> {
            return Error(reason)
        }
    }
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

/**
 * Helper functions
 * */
inline fun <reified T> Resource<T>.whenSuccessful(receiver: (T) -> Unit): Resource<T> {
    if (this is Resource.Success)
        receiver(value)
    return this
}

inline fun <reified T> Resource<T>.whenFailed(receiver: (Throwable) -> Unit): Resource<T> {
    if (this is Resource.Error)
        receiver(reason)
    return this
}