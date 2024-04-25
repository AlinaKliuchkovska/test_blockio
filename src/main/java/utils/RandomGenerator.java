package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {
  public static String createRandomString() {
    String loverCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String upperCharacters = "abcdefghijklmnopqrstuvwxyz";
    return RandomStringUtils.random(2, loverCharacters) + RandomStringUtils.random(2, upperCharacters) + System.currentTimeMillis();
  }
}
