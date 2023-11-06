package com.ll;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    @DisplayName("1단계 : 종료")
    void t1() {
        Scanner sc = TestUtil.genScanner("""
                종료
                """.stripIndent());
        new WiseController(sc).start();
        sc.close();
    }

    @Test
    @DisplayName("2단계 : 등록")
    void t2() {
        Scanner sc = TestUtil.genScanner("""
                등록
                현재를 사랑하라.
                작자미상
                종료
                """.stripIndent());
        new WiseController(sc).start();
        sc.close();
    }

    @Test
    @DisplayName("3단계 : 등록시 생성된 명언번호 노출")
    void t3() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        Scanner sc = TestUtil.genScanner("""
                등록
                현재를 사랑하라.
                작자미상
                종료
                """.stripIndent());
        new WiseController(sc).start();
        sc.close();

        String out = byteArrayOutputStream.toString();
        assertThat(out).contains("1번 명언이 등록되었습니다.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }

    @Test
    @DisplayName("4단계 : 등록할때 마다 생성되는 명언번호가 증가")
    void t4() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        Scanner sc = TestUtil.genScanner("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                종료
                """.stripIndent());
        new WiseController(sc).start();
        sc.close();

        String out = byteArrayOutputStream.toString();
        assertThat(out).contains("1번 명언이 등록되었습니다.", "2번 명언이 등록되었습니다.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }

    @Test
    @DisplayName("5단계 : 목록")
    void t5() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        Scanner sc = TestUtil.genScanner("""
                등록
                현재를 사랑해라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                종료
                """.stripIndent());
        new WiseController(sc).start();
        sc.close();

        String out = byteArrayOutputStream.toString();
        assertThat(out).contains("번호 / 작가 / 명언", "----------------------",
                "2 / 작자미상 / 과거에 집착하지 마라.", "1 / 작자미상 / 현재를 사랑해라.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }

    @Test
    @DisplayName("6단계 : 명언삭제")
    void t6() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        Scanner sc = TestUtil.genScanner("""
                등록
                현재를 사랑해라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                삭제?id=1
                종료
                """.stripIndent());
        new WiseController(sc).start();
        sc.close();

        String out = byteArrayOutputStream.toString();
        assertThat(out).contains("1번 명언이 삭제되었습니다.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }

    @Test
    @DisplayName("7단계 : 존재하지 않는 명언삭제에 대한 예외처리")
    void t7() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        Scanner sc = TestUtil.genScanner("""
                등록
                현재를 사랑해라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                삭제?id=1
                삭제?id=1
                종료
                """.stripIndent());
        new WiseController(sc).start();
        sc.close();

        String out = byteArrayOutputStream.toString();
        assertThat(out).contains("1번 명언이 삭제되었습니다.", "1번 명언은 존재하지 않습니다.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }
}
