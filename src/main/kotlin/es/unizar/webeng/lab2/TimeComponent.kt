package es.unizar.webeng.lab2
import org.springframework.stereotype.Service
import java.time.LocalDateTime

// Data Transfer Object (DTO) to represent the current time
data class TimeDTO(
    val time: LocalDateTime,
)

// Service interface to provide the current time
interface TimeProvider {
    fun now(): LocalDateTime
}

@Service // Indicates that this class is a Spring service component
class TimeService : TimeProvider {
    override fun now(): LocalDateTime = LocalDateTime.now()
}

// Extension function to convert LocalDateTime to TimeDTO
fun LocalDateTime.toDTO(): TimeDTO = TimeDTO(time = this)
