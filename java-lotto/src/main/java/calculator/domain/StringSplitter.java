package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int INDEX_FIRST = 1;
    private static final int INDEX_SECOND = 2;

    public static String[] split(String calculationExpression) {
        Matcher matcher = PATTERN.matcher(calculationExpression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(INDEX_FIRST);
            return matcher.group(INDEX_SECOND).split(customDelimiter);
        }
        return calculationExpression.split(DEFAULT_DELIMITER);
    }
}
