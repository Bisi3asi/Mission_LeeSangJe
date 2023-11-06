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


}
