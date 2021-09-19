package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection 학습테스트")
public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
    public void checkSize() throws Exception {
        //when
        int size = numbers.size();

        //then
        assertEquals(3, size);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("중복되는 코드 없이(파라미터가 중복되지 않아야 한다는 의미가 아님. 코드) 값이 존재하는지 확인")
    public void eraseDuplicateCode(int input) throws Exception {
        //given

        //when

        //then
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("중복되는 코드 없이 값이 존재하는지 확인해야할때. 인풋에 따라 결과값이 다를수도 있는경우")
    public void eraseDuplicateCode2(String input, String result) throws Exception {
        //given

        //when

        //then
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(
            Boolean.parseBoolean(result));
    }


}
