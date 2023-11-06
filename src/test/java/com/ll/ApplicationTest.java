package com.ll;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
        String input = sc.nextLine();

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        String out = byteArrayOutputStream.toString();

        assertThat(input).isEqualTo("종료");
        assertThat(out).isEqualTo("");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
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
        ArrayList<String> input = new ArrayList<>(){{
            for (int i = 0; i < 4; i++){
                add(sc.nextLine());
            }
        }};

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        String out = byteArrayOutputStream.toString();

        assertThat(input).isEqualTo(Arrays.asList("등록", "현재를 사랑하라.", "작자미상", "종료"));
        assertThat(out).isEqualTo("");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }
}

