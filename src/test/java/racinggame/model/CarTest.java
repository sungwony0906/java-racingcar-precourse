package racinggame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.MockedStatic;

@TestMethodOrder(OrderAnnotation.class)
class CarTest {

    private Car car;

    private static MockedStatic<Randoms> mockRandoms;

    private static final int STOP = Car.BASE_VALUE - 1;
    private static final int FORWARD = Car.BASE_VALUE + 1;

    @BeforeAll
    public static void beforeAll() {
        mockRandoms = mockStatic(Randoms.class);
        mockRandoms.when(() -> Randoms.pickNumberInRange(0, 9))
                .thenReturn(STOP,FORWARD,STOP,FORWARD,FORWARD);
    }

    @AfterAll
    public static void afterAll() {
        mockRandoms.close();
    }

    @Test
    @Order(0)
    void drive_정지_테스트() {
        car = new Car("stop");
        car.drive();
        assertThat(car.getCarName()).isEqualTo("stop");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @Order(1)
    void drive_이동_테스트() {
        car = new Car("move");
        car.drive();
        assertThat(car.getCarName()).isEqualTo("move");
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @Order(2)
    void drive_테스트() {
        car = new Car("drive");
        car.drive();
        car.drive();
        car.drive();
        assertThat(car.getCarName()).isEqualTo("drive");
        assertThat(car.getPosition()).isEqualTo(2);
    }
}