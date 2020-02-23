import java.io.File
import java.util.*

fun readProperties(path: String): Properties? {
    return runCatching {
        Properties().apply {
            load(File(path).inputStream())
        }
    }.getOrNull()
}