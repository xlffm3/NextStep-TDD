package racing.domain;

public class RacingGameBuildingException extends RuntimeException {
    public static final String INVALID_CAR_NAME = "자동차 이름이 null이거나 빈 문자열이거나 5글자를 초과할 수 없습니다.";
    public static final String INVALID_GAME_TRY_COUNTS = "게임 시도 회수는 1이상이어야합니다.";
    public static final String RUN_OUT_GAME_TRY_COUNTS = "플레이 가능한 게임 시도 회수가 없습니다.";

    public RacingGameBuildingException() {
        super();
    }

    public RacingGameBuildingException(String message) {
        super(message);
    }
}
