import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Triangle");
  }

  @Test
  public void triangleTestIsAnEquilateralTriangle() {
    goTo("http://localhost:4567/");
    fill("#side1").with("5");
    fill("#side2").with("5");
    fill("#side3").with("5");
    submit(".btn");
    assertThat(pageSource()).contains("This is an Equilateral triangle!");
  }

  @Test
  public void triangleTestIsAnIsoscelesTriangle() {
    goTo("http://localhost:4567/");
    fill("#side1").with("5");
    fill("#side2").with("5");
    fill("#side3").with("7");
    submit(".btn");
    assertThat(pageSource()).contains("This is an Isosceles triangle!");
  }

  @Test
  public void triangleTestIsAScaleneTriangle() {
    goTo("http://localhost:4567/");
    fill("#side1").with("5");
    fill("#side2").with("6");
    fill("#side3").with("7");
    submit(".btn");
    assertThat(pageSource()).contains("This is a Scalene triangle!");
  }

  @Test
  public void triangleTestIsNotATriangle() {
    goTo("http://localhost:4567/");
    fill("#side1").with("2");
    fill("#side2").with("2");
    fill("#side3").with("7");
    submit(".btn");
    assertThat(pageSource()).contains("This is not even a triangle! Don't play.");
  }

}
