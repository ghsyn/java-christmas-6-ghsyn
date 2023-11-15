package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    @DisplayName("날짜가 정수형이 아닐 경우")
    void 날짜_예외_테스트_1() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    @DisplayName("날짜가 1이상, 31이하가 아닐 경우")
    void 날짜_예외_테스트_2() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
        assertSimpleTest(() -> {
            runException("32");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        });
        assertSimpleTest(() -> {
            runException("31");
            assertThat(output()).contains("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        });
    }

    @Test
    @DisplayName("메뉴의 개수가 정수가 아닐 경우")
    void 주문_예외_테스트_1() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 메뉴의 개수는 1 이상의 정수여야 합니다.");
        });
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴를 입력 받은 경우")
    void 주문_예외_테스트_2() {
        assertSimpleTest(() -> {
            runException("3", "화이트와인-2");
            assertThat(output()).contains("[ERROR] 화이트와인은(는) 없는 메뉴 입니다.");
        });
    }

    @Test
    @DisplayName("메뉴 형식이 예시와 다른 경우")
    void 주문_예외_테스트_3() {
        assertSimpleTest(() -> {
            runException("3", "해산물파스타:2개,레드와인:1개,초코케이크:1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    @DisplayName("메뉴의 개수가 1 이상이 아닐 경우")
    void 주문_예외_테스트_4() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-0");
            assertThat(output()).contains("[ERROR] 메뉴의 개수는 1 이상의 정수여야 합니다.");
        });
    }

    @Test
    @DisplayName("메뉴의 전체 개수가 20개가 넘었을 경우")
    void 주문_예외_테스트_5() {
        assertSimpleTest(() -> {
            runException("3", "양송이수프-20");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "<할인 전 총주문 금액>",
                    "<증정 메뉴>",
                    "<혜택 내역>",
                    "<총혜택 금액>",
                    "<할인 후 예상 결제 금액>",
                    "<12월 이벤트 배지>"
            );
        });
        assertSimpleTest(() -> {
            runException("3", "제로콜라-10,티본스테이크-11");
            assertThat(output()).contains("[ERROR] 메뉴는 한 번에 최대 20개까지 가능합니다.");
        });
    }

    @Test
    @DisplayName("음료만 주문했을 경우")
    void 주문_예외_테스트_6() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-1,레드와인-1");
            assertThat(output()).contains("[ERROR] 음료만 주문할 수는 없습니다.");
        });
    }

    @Test
    @DisplayName("주문 형식에 공백이 포함될 경우")
    void 주문_예외_테스트_7() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크 - 1,바비큐립 -1,초코케이크-2 ,제로콜라-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "<할인 전 총주문 금액>",
                    "<증정 메뉴>",
                    "<혜택 내역>",
                    "<총혜택 금액>",
                    "<할인 후 예상 결제 금액>",
                    "<12월 이벤트 배지>"
            );
        });
        assertSimpleTest(() -> {
            run("26", "타파스 -1,제로콜라- 1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
