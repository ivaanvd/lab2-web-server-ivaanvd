package es.unizar.webeng.lab2
import java.time.LocalDateTime
import org.springframework.stereotype.Service

data class TimeDTO(val time: LocalDateTime)

interface TimeProvider {
    fun now(): LocalDateTime
}

@Service // Indicates that this class is a Spring service component
class TimeService : TimeProvider {
    override fun now(): LocalDateTime = LocalDateTime.now()
}

fun LocalDateTime.toDTO(): TimeDTO = TimeDTO(time = this)


