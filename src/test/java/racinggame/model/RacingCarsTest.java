package racinggame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mockStatic;

import java.util.List;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class RacingCarsTest {

    private RacingCars racingCars;

    private static MockedStatic<Randoms> mockRandoms;

    private static final int STOP = Car.BASE_VALUE - 1;
    private static final int FORWARD = Car.BASE_VALUE + 1;

    @BeforeAll
    public static void beforeAll() {
        mockRandoms = mockStatic(Randoms.class);
        mockRandoms.when(() -> Randoms.pickNumberInRange(0, 9))
                .thenReturn(FORWARD, FORWARD, FORWARD, FORWARD, FORWARD, STOP, FORWARD, STOP, STOP);
    }

    @Test
    void 생성_테스트() {
        racingCars = new RacingCars("do,re,mi");
        assertThat(racingCars).isNotNull();
        assertThat(racingCars.getCars().size()).isEqualTo(3);
        assertThat(racingCars.getCars()).filteredOn(e -> e.getCarName().equals("do")).hasSize(1);
        assertThat(racingCars.getCars()).filteredOn(e -> e.getCarName().equals("re")).hasSize(1);
        assertThat(racingCars.getCars()).filteredOn(e -> e.getCarName().equals("mi")).hasSize(1);
    }

    @Test
    void 생성_파라미터_미입력_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCars(null))
                .withMessage("[ERROR]입력된 차량이 없습니다");
    }

    @Test
    void 생성_파라미터_차량이름없음_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCars("dodo,rere,,mimi"))
                .withMessage("[ERROR]차량 이름이 없는 차량이 있습니다");
    }

    @Test
    void 생성_파라미터_차량이름_5자이상_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCars("dodo,rerere,,mimi"))
                .withMessage("[ERROR]차량 이름은 5자 이하만 가능합니다");
    }

    @Test
    void race_테스트() {
        racingCars = new RacingCars("do,re,mi");
        racingCars.race();
        racingCars.race();
        racingCars.race();
        assertThat(racingCars.getCars()).filteredOn(e -> e.getCarName().equals("do")).extracting("position").contains(3);
        assertThat(racingCars.getCars()).filteredOn(e -> e.getCarName().equals("re")).extracting("position").contains(2);
        assertThat(racingCars.getCars()).filteredOn(e -> e.getCarName().equals("mi")).extracting("position").contains(1);
    }

    @Test
    void winner_테스트() {
        race_테스트();
        List<Car> winner = racingCars.getWinner();
        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getCarName()).isEqualTo("do");
        assertThat(winner.get(0).getPosition()).isEqualTo(3);
    }
}