package max.test.service;

import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 *
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * For example, the word anagram itself can be rearranged into
 * nag a ram; which is an Easter egg in Google when searching for the word "anagram"; the word binary-into brainy
 * and the word adobe-into abode.
 * The original word or phrase is known as the <b>subject</b> of the anagram. Any word or phrase that exactly reproduces
 * the letters in another order is an <b>anagram</b>. Someone who creates anagrams may be called an "anagrammatist", and the goal of a serious
 * or skilled
 * anagrammatist is to produce anagrams that reflect or comment on their subject.
 */
public class AnagramService {

  public static final String NOT_A_LETTER = "[^a-zA-Z]";
  public static final String EMPTY_STRING = "";

  private AnagramService() {}

  public static boolean checkAnagram(String subject, String anagram) {

    if (subject == null || anagram == null) {
      return false;
    }

    var subjectToProcess = removeAll(NOT_A_LETTER, subject).toLowerCase();
    var anagramToProcess = removeAll(NOT_A_LETTER, anagram).toLowerCase();

    if (hasDifferentLength(subjectToProcess, anagramToProcess)) {
      return false;
    }

    int[] charCounts = new int[26];

    //Personally I don't like for loop written in the old style
    //but for the sake of this solution this is ok
    for (int index = 0; index < subjectToProcess.length(); index++) {

      incrementLetterCounter(subjectToProcess, charCounts, index);
      decrementLetterCounter(anagramToProcess, charCounts, index);

    }

    return Arrays.stream(charCounts).noneMatch(valueDifferentFromZero());

  }

  private static boolean hasDifferentLength(String subjectToProcess, String anagramToProcess) {
    return subjectToProcess.length() != anagramToProcess.length();
  }

  private static IntPredicate valueDifferentFromZero() {
    return i -> i != 0;
  }

  private static void decrementLetterCounter(String anagramToProcess, int[] charCounts, int i) {
    charCounts[findAsciiIndex(anagramToProcess, i)]--;
  }

  private static void incrementLetterCounter(String subjectToProcess, int[] charCounts, int i) {
    charCounts[findAsciiIndex(subjectToProcess, i)]++;
  }

  private static int findAsciiIndex(String subjectToProcess, int i) {
    return subjectToProcess.charAt(i) - 'a';
  }

  private static String removeAll(String regex, String subject) {
    return subject.replaceAll(regex, EMPTY_STRING).toLowerCase();
  }
}
