package la.kaelae.kotshisample.model

import com.squareup.moshi.Json
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PersonParseTest {
  @Test
  fun parse_person() {
    val json = "{\"name\": \"kaelaela\", \"email\": \"test@gmail.com\", \"job_title\": \"title\", \"age\": 27}"
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val before = System.currentTimeMillis()
    val person = moshi.adapter<Person>(Person::class.java).fromJson(json)
    System.out.println(System.currentTimeMillis() - before)

    assertThat(person?.name).isEqualTo("kaelaela")
    assertThat(person?.email).isEqualTo("test@gmail.com")
    assertThat(person?.jobTitle).isEqualTo("title")
    assertThat(person?.age).isEqualTo(27)
  }

  @Test
  fun parse_person2() {
    val json = "{\"name\": \"kaelaela\", \"email\": \"test@gmail.com\", \"job_title\": \"nice job\", \"company_name\": \"good company\", \"address\": \"great place\",\"age\": 27}"
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val before = System.currentTimeMillis()
    val person = moshi.adapter<Person2>(Person2::class.java).fromJson(json)
    System.out.println(System.currentTimeMillis() - before)

    assertThat(person?.name).isEqualTo("kaelaela")
    assertThat(person?.email).isEqualTo("test@gmail.com")
    assertThat(person?.jobTitle).isEqualTo("nice job")
    assertThat(person?.companyName).isEqualTo("good company")
    assertThat(person?.companyAddress).isEqualTo("great place")
    assertThat(person?.age).isEqualTo(27)
  }
}

data class Person(
    val name: String,
    val email: String?,
    @Json(name = "job_title") val jobTitle: String,
    val age: Int
)

data class Person2(
    val name: String,
    val email: String?,
    @Json(name = "job_title") val jobTitle: String,
    @Json(name = "company_name") val companyName: String,
    @Json(name = "address") val companyAddress: String,
    val age: Int
)