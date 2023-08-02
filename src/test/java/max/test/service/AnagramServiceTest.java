package max.test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static max.test.service.AnagramService.checkAnagram;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramServiceTest {

  @Test
  void whenEitherOneOrAllParameterAreNull_returnFalse() {

    assertAll("Assert returning false when parameters are null",
      () -> assertFalse(checkAnagram(null, "anagram")),
      () -> assertFalse(checkAnagram("subject", null)),
      () -> assertFalse(checkAnagram(null, null)));

  }

  @ParameterizedTest
  @CsvSource({
    "veryLongSubject, anagram",
    "subject, veryLongAnagram",
    "len+1, lenght+123"
  })
  void whenInputHasDiferentLengths_returnFalse(String subject, String anagram){
   assertFalse(checkAnagram(subject, anagram));
  }

  @ParameterizedTest
  @CsvSource({
    "\"\", \"\"",
    "Listen, silent",
    "forty five, over fifty",
    "Tom Marvolo Riddle, I am Lord Voldemort",
    "Listen, !Silent!",
    "Listen, !Silent123",
  })
  void whenInputIsAnagram_returnTrue(String subject, String anagram){
    assertTrue(checkAnagram(subject, anagram));
  }


  @ParameterizedTest
  @CsvSource({
    "Rat, Car",
    "Hello, World",
    "This is a, Test"
  })
  void whenInputIsNotAnagram_returnFalse(String subject, String anagram){
    assertFalse(checkAnagram(subject, anagram));
  }

}
