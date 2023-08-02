package max.test;

import max.test.service.AnagramChecker;
public class Main {
  public static void main(String[] args) {

    if(args.length<2){
      throw new IllegalArgumentException("required argument is " + "missing");
    }

    var subject = args[0];
    var anagram = args[1];

    var isAnagram = AnagramChecker.checkAnagram(subject, anagram);

    if (isAnagram) {
      System.out.println("Congratulations the words are anagrams!");
    } else {
      System.out.println("Unfortunately these are not anagrams!");

    }
  }

}