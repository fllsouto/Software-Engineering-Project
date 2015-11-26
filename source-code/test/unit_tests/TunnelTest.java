package unit_tests;

import services.Tunnel;
import org.junit.Test;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

public class TunnelTest {

  @Test
  public void testDig() throws Exception {
    //Regular user (not a member)
    String result = new Tunnel().dig("https://www.playframework.com/documentation/2.4.x/JavaTest", "");
    assertEquals(result.length(), 6);
    assertTrue((result.charAt(0) >= (int)'0' && result.charAt(0) <= (int)'9') ||
               (result.charAt(0) >= (int)'A' && result.charAt(0) <= (int)'Z') ||
               (result.charAt(0) >= (int)'a' && result.charAt(0) <= (int)'z'));
    assertTrue((result.charAt(1) >= (int)'0' && result.charAt(1) <= (int)'9') ||
               (result.charAt(1) >= (int)'A' && result.charAt(1) <= (int)'Z') ||
               (result.charAt(1) >= (int)'a' && result.charAt(1) <= (int)'z'));
    assertTrue((result.charAt(2) >= (int)'0' && result.charAt(2) <= (int)'9') ||
               (result.charAt(2) >= (int)'A' && result.charAt(2) <= (int)'Z') ||
               (result.charAt(2) >= (int)'a' && result.charAt(2) <= (int)'z'));
    assertTrue((result.charAt(3) >= (int)'0' && result.charAt(3) <= (int)'9') ||
               (result.charAt(3) >= (int)'A' && result.charAt(3) <= (int)'Z') ||
               (result.charAt(3) >= (int)'a' && result.charAt(3) <= (int)'z'));
    assertTrue((result.charAt(4) >= (int)'0' && result.charAt(4) <= (int)'9') ||
               (result.charAt(4) >= (int)'A' && result.charAt(4) <= (int)'Z') ||
               (result.charAt(4) >= (int)'a' && result.charAt(4) <= (int)'z'));
    assertTrue((result.charAt(5) >= (int)'0' && result.charAt(5) <= (int)'9') ||
               (result.charAt(5) >= (int)'A' && result.charAt(5) <= (int)'Z') ||
               (result.charAt(5) >= (int)'a' && result.charAt(5) <= (int)'z'));


     //With a user "test_user"
     running(fakeApplication(), new Runnable() {
       public void run() {
       String result = new Tunnel().dig("https://www.playframework.com/documentation/2.4.x/JavaTest", "testuser");

       assertEquals(result.length(), 6);
       assertTrue((result.charAt(0) >= (int)'0' && result.charAt(0) <= (int)'9') ||
                  (result.charAt(0) >= (int)'A' && result.charAt(0) <= (int)'Z') ||
                  (result.charAt(0) >= (int)'a' && result.charAt(0) <= (int)'z'));
       assertTrue((result.charAt(1) >= (int)'0' && result.charAt(1) <= (int)'9') ||
                  (result.charAt(1) >= (int)'A' && result.charAt(1) <= (int)'Z') ||
                  (result.charAt(1) >= (int)'a' && result.charAt(1) <= (int)'z'));
       assertTrue((result.charAt(2) >= (int)'0' && result.charAt(2) <= (int)'9') ||
                  (result.charAt(2) >= (int)'A' && result.charAt(2) <= (int)'Z') ||
                  (result.charAt(2) >= (int)'a' && result.charAt(2) <= (int)'z'));
       assertTrue((result.charAt(3) >= (int)'0' && result.charAt(3) <= (int)'9') ||
                  (result.charAt(3) >= (int)'A' && result.charAt(3) <= (int)'Z') ||
                  (result.charAt(3) >= (int)'a' && result.charAt(3) <= (int)'z'));
       assertTrue((result.charAt(4) >= (int)'0' && result.charAt(4) <= (int)'9') ||
                  (result.charAt(4) >= (int)'A' && result.charAt(4) <= (int)'Z') ||
                  (result.charAt(4) >= (int)'a' && result.charAt(4) <= (int)'z'));
       assertTrue((result.charAt(5) >= (int)'0' && result.charAt(5) <= (int)'9') ||
                  (result.charAt(5) >= (int)'A' && result.charAt(5) <= (int)'Z') ||
                  (result.charAt(5) >= (int)'a' && result.charAt(5) <= (int)'z'));
      }
    });
  }
}
