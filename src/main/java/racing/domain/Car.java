package racing.domain;

public class Car {

    private static final int INITIAL_VALUE = 0;
    private static final int MOVING_CONDITION = 4;
    private static final int MINIMUM_LENGTH_OF_CAR_NAME = 1;
    private static final int MAXIMUM_LENGTH_OF_CAR_NAME = 5;
    private static final String LENGTH_OF_CAR_NAME_ERROR = "[ERROR] 자동차이름의 길이는 1-5자까지 가능합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validateLengthOfName(name);
        this.name = name;
        this.position = INITIAL_VALUE;
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVING_CONDITION) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateLengthOfName(String name) {
        if (name.length() < MINIMUM_LENGTH_OF_CAR_NAME || name.length() > MAXIMUM_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(LENGTH_OF_CAR_NAME_ERROR);
        }
    }
}
