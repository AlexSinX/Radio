package Domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class RadioTest {

    // ===== Тесты радиостанций =====

    @Test
    void shouldSwitchToZeroAfterLastStation() {
        Radio radio = new Radio(3);
        radio.setCurrentStation(2);

        radio.next();

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToLastStationFromZero() {
        Radio radio = new Radio(3);
        radio.setCurrentStation(0);

        radio.prev();

        Assertions.assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveCustomMax() {
        Radio radio = new Radio(3);

        radio.setCurrentStation(3);

        Assertions.assertEquals(0, radio.getCurrentStation());
    }


    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(5);

        int expected = 5;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationBelowZero() {
        Radio radio = new Radio();

        radio.setCurrentStation(-1);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(4);

        radio.next();

        int expected = 5;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchFromNineToZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.prev();

        int expected = 4;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchFromZeroToNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    // ===== Тесты громкости =====

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setVolume(50);

        radio.increaseVolume();

        int expected = 51;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setVolume(10);

        radio.decreaseVolume();

        int expected = 9;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotDecreaseVolumeBelowZero() {
        Radio radio = new Radio();
        radio.setVolume(0);

        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetVolumeBelowZero() {
        Radio radio = new Radio();

        radio.setVolume(-1);

        int expected = 0;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();

        radio.setVolume(101);

        int expected = 0;
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }
}
