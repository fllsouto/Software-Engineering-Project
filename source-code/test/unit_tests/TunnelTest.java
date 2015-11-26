package unit_tests;

import services.Tunnel;
import models.User;
import com.avaje.ebean.Model;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

public class TunnelTest {

  @Test
  public void testDig_1() {
    //Regular user (not a member)
    String result = new Tunnel().dig("https://www.playframework.com/documentation/2.4.x/JavaTest", "");
    assertEquals(result.length(), 6);
    assertTrue((result.charAt(0) >= (int)'0' && result.charAt(0) <= (int)'9') ||
               (result.charAt(0) >= (int)'A' && result.charAt(0) <= (int)'Z') ||
               (result.charAt(0) >= (int)'a' && result.charAt(0) <= (int)'z'));

  }

  public void testDig_2() {
    //With a user "test_user"
    User u = new User(); u.set_username("testuser"); u.set_password("testuser"); u.save();
    String result = new Tunnel().dig("https://www.playframework.com/documentation/2.4.x/JavaTest", "testuser");
    assertEquals(result.length(), 6);
    assertTrue((result.charAt(0) >= (int)'0' && result.charAt(0) <= (int)'9') ||
              (result.charAt(0) >= (int)'A' && result.charAt(0) <= (int)'Z') ||
              (result.charAt(0) >= (int)'a' && result.charAt(0) <= (int)'z'));
  }
}
