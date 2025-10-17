package es.unizar.webeng.lab2

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.time.LocalDateTime

class TimeControllerUnitTest {

    @Test
    fun `should return current time from controller`() {
        // Fake TimeProvider that returns a fixed time
        val fakeTime = LocalDateTime.of(2024, 10, 1, 12, 0)
        val fakeProvider = object : TimeProvider {
            override fun now(): LocalDateTime = fakeTime
        }
        // Create TimeController with the fake provider
        val controller = es.unizar.webeng.lab2.controller.TimeController(fakeProvider)
        // Invoke the controller method
        val response = controller.time()
        // Check that the response time matches the fake time
        assertThat(response.time).isEqualTo(fakeTime)
    }
}
