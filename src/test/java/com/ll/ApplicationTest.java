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
        String input = sc.nextLine();

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        String out = byteArrayOutputStream.toString();

        assertThat(input).isEqualTo("종료");
        assertThat(out).isEqualTo("");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }
}

