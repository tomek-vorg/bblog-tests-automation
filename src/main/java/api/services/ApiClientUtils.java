package api.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.Supplier;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static io.restassured.http.ContentType.JSON;

public class ApiClientUtils {

  public static Supplier<RequestSpecBuilder> supplier() {
    return () -> new RequestSpecBuilder()
      .setContentType(JSON)
      .setAccept(JSON)
      .setConfig(config().objectMapperConfig(
        objectMapperConfig()
          .defaultObjectMapper(JsonObjectMapper.create())))
      .addFilter(new RequestLoggingFilter(LogDetail.ALL, true, new SystemOutStreamCollectableByReport()))
      .addFilter(new ResponseLoggingFilter(LogDetail.ALL, true, new SystemOutStreamCollectableByReport()));
  }

  /**
   * Sends whole {@code System.out} to TestNg {@code Reporter}
   *
   * @see Reporter
   */
  static class SystemOutStreamCollectableByReport extends PrintStream {

    SystemOutStreamCollectableByReport() {
      super(System.out);
    }

    void printToReport(String s, boolean newLine) {
      Reporter.log(newLine ? s + System.lineSeparator() : s);
    }

    @Override
    public void print(boolean b) {
      printToReport(String.valueOf(b), false);
      super.print(b);
    }

    @Override
    public void print(char c) {
      printToReport(String.valueOf(c), false);
      super.print(c);
    }

    @Override
    public void print(int i) {
      printToReport(String.valueOf(i), false);
      super.print(i);
    }

    @Override
    public void print(long l) {
      printToReport(String.valueOf(l), false);
      super.print(l);
    }

    @Override
    public void print(float f) {
      printToReport(String.valueOf(f), false);
      super.print(f);
    }

    @Override
    public void print(double d) {
      printToReport(String.valueOf(d), false);
      super.print(d);
    }

    @Override
    public void print(char[] s) {
      printToReport(Arrays.toString(s), false);
      super.print(s);
    }

    @Override
    public void print(String s) {
      printToReport(s, false);
      super.print(s);
    }

    @Override
    public void print(Object obj) {
      printToReport(String.valueOf(obj), false);
      super.print(obj);
    }

    @Override
    public void println() {
      printToReport(StringUtils.EMPTY, true);
      super.println();
    }

    @Override
    public void println(boolean x) {
      printToReport(String.valueOf(x), true);
      super.println(x);
    }

    @Override
    public void println(char x) {
      printToReport(String.valueOf(x), true);
      super.println(x);
    }

    @Override
    public void println(int x) {
      printToReport(String.valueOf(x), true);
      super.println(x);
    }

    @Override
    public void println(long x) {
      printToReport(String.valueOf(x), true);
      super.println(x);
    }

    @Override
    public void println(float x) {
      printToReport(String.valueOf(x), true);
      super.println(x);
    }

    @Override
    public void println(double x) {
      printToReport(String.valueOf(x), true);
      super.println(x);
    }

    @Override
    public void println(char[] x) {
      printToReport(Arrays.toString(x), true);
      super.println(x);
    }

    @Override
    public void println(String x) {
      printToReport(x, true);
      super.println(x);
    }

    @Override
    public void println(Object x) {
      printToReport(String.valueOf(x), true);
      super.println(x);
    }

    @Override
    public PrintStream printf(String format, Object... args) {
      printToReport(String.format(format, args), false);
      return super.printf(format, args);
    }

    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
      printToReport(String.format(l, format, args), false);
      return super.printf(l, format, args);
    }
  }
}
