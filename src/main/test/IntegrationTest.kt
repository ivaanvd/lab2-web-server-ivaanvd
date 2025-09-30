package es.unizar.webeng.lab2.test
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTest {
    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun `should return error page`() {
    val response = restTemplate.getForEntity("http://localhost:$port")

    assertThat(response.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    assertThat(response.body).contains("<title>Error - Ocurrió un problema</title>")
    assertThat(response.body).contains("¡Ups! Algo salió mal")
    assertThat(response.body).contains("Ha ocurrido un error inesperado. Por favor, inténtalo de nuevo más tarde.")
    }
}