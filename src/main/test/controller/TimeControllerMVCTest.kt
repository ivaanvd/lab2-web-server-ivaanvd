package es.unizar.webeng.lab2

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.mockito.Mockito.`when`
import java.time.LocalDateTime
import es.unizar.webeng.lab2.controller.TimeController

@WebMvcTest(TimeController::class)
class TimeControllerMVCTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var timeProvider: TimeProvider

    @Test
    fun `should return time as JSON`() {
        // Set up mock TimeProvider
        val now = LocalDateTime.of(2024, 10, 1, 12, 0)
        `when`(timeProvider.now()).thenReturn(now)

        // Perform GET request and verify response
        mockMvc.perform(get("/time"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.time").value(now.toString()))
    }
}
