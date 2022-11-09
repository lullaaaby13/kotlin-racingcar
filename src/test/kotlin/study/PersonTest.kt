package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "구민수", age = 20, nickname = "닉")
        assertThat(person.name).isEqualTo("구민수")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("닉")
    }

    @Test
    fun `널 타입`() {
        val person = Person("구민수", 20, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("구민수", 20)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("구민수", 20)
        val person2 = Person("구민수", 20)
        assertThat(person1).isEqualTo(person2)
    }
}
