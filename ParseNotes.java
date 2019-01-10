//**************************************************************************//
//  File that parses doctor's notes
//  Gayatri Rajan
//**************************************************************************//
import java.io.*;
import java.util.*;
public class ParseNotes
{
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter the doctor's note.");
    String original = sc.nextLine();
    sc.close();
    String[] tokenized = tokenizeNote(original);
    String[] respelled = fixSpelling(tokenized);
    /* String[] formed = recognizeForms(respelled);
    String[] categorized = categorizeString(formed);
    String[] final = expandAbbreviations(categorized);*/
  }
  public static String[] tokenizeNote(String original)
  {
    String[] tokenized=original.split(".");
    return tokenized;
  }
  public static String[] fixSpelling(String[] tokenized)
  {
    JLanguageTool langTool = new JLanguageTool(Language.AMERICAN_ENGLISH);
    langTool.activateDefaultPatternRules();
    for(int i=0; i<tokenized.length; i++){
    List<RuleMatch> matches = langTool.check(tokenized[i]);
    for (RuleMatch match : matches) {
        System.out.println("Potential error at line " +
            match.getEndLine() + ", column " +
            match.getColumn() + ": " + match.getMessage());
        System.out.println("Suggested correction: " +
            match.getSuggestedReplacements());
    }}
    return tokenized;
  }
  /*
  public static String recognizeForms(String[] respelled)
  {
//TODO: implement neural network for forms w/ NACC database 
  }
  public static String categorizeString(String[] formed)
  {

  }
  public static String expandAbbreviations(String[] categorized)
  {

  }*/
}
