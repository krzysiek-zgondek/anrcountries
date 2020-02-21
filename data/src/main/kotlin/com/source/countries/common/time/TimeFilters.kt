package com.source.countries.common.time

import org.threeten.bp.Duration
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.temporal.Temporal

inline fun <S> Collection<S>.filterOutdated(
    lifetime: Duration,
    provider: (S) -> Temporal
): List<S> {
    val now: OffsetDateTime = OffsetDateTime.now()
    return filter { item ->
        val providedTime = provider(item)
        Duration.between(providedTime, now) < lifetime
    }
}