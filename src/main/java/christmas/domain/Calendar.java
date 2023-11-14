package christmas.domain;

public class Calendar {
    private static final String[] DAYS_OF_THE_WEEK = {"월", "화", "수", "목", "금", "토", "일"};
    private static final String START_DAY_OF_DECEMBER = "금";
    private static int dayIndex;

    private static void setDayIndex() {
        for (int i = 0; i < DAYS_OF_THE_WEEK.length; i++) {
            if (DAYS_OF_THE_WEEK[i].equals(START_DAY_OF_DECEMBER)) {
                dayIndex = i;
            }
        }
    }

    public static String findDayOfWeek(int visitDate) {
        setDayIndex();
        String dayOfVisitDate = DAYS_OF_THE_WEEK[visitDate % 7 + dayIndex - 1];

        return dayOfVisitDate;
    }
}