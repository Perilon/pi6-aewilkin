import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import type.Passage;
import type.Question;
import type.Token;


public class TokenAnnotator extends JCasAnnotator_ImplBase {
  
  private Pattern mTokenPattern = 
          Pattern.compile("([^\\s]+)");

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    
    StanfordLemmatizer lemmatizer = new StanfordLemmatizer();    

    FSIndex passageIndex = aJCas.getAnnotationIndex(Passage.type);
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);

    
    Iterator passageIter = passageIndex.iterator();
    
    while (passageIter.hasNext()) {
      Passage passage = (Passage) passageIter.next();
      
//      String lemmasString = passage.getSentenceLemmatized();
      
//      System.out.println("lemmasString (passage) = " + lemmasString);
      
//      String[] lemmasArray = lemmasString.split("([\\s]+)");
      
//      System.out.println("lemmasArray (passage) = " + Arrays.toString(lemmasArray));
//      System.out.println("lemmasArrayLen (passage) = " + Integer.toString(lemmasArray.length));
      
      Matcher matcher = mTokenPattern.matcher(passage.getSentence());
      int pos = 0;
//      int index = 0;
      while (matcher.find(pos)) {
        
        Token token = new Token(aJCas);
        
        token.setBegin(passage.getBegin() + matcher.start(1));
        token.setEnd(passage.getBegin() + matcher.end(1));
        
//        String whatisthistoken = token.getCoveredText();
//        System.out.println("token = " + whatisthistoken);
        
        String ts = token.getCoveredText();
        
//        String lemma = lemmasArray[index];
        
//        System.out.println("lemma = " + lemma);
        
        StringBuilder builder = new StringBuilder();
       
        for (char c : ts.toCharArray()) {
          if (Character.isLetterOrDigit(c) || c == '<' || c == '>') {
            builder.append(Character.isLowerCase(c) ? c: Character.toLowerCase(c));
          }
        }
        
        String finalToken = builder.toString();
        
        String finalTokenLemmatized = lemmatizer.lemmatize(finalToken);
        
        token.setToStringValue(finalTokenLemmatized);
        
        token.addToIndexes();
        pos = matcher.end();
        
//        index++;
        
      }
    }
    
    Iterator questionIter = questionIndex.iterator();
    
    while (questionIter.hasNext()) {
      Question question = (Question) questionIter.next();
      
//      String lemmasString = question.getSentenceLemmatized();
//      String[] lemmasArray = lemmasString.split(" ");
      
      Matcher matcher = mTokenPattern.matcher(question.getSentence());
      int pos = 0;
      int index = 0;
      while (matcher.find(pos)) {
        Token token = new Token(aJCas);
        token.setBegin(question.getBegin() + matcher.start(1));
        token.setEnd(question.getBegin() + matcher.end(1));
        
        String ts = token.getCoveredText();
        
//        String ts = lemmasArray[index];
      
        StringBuilder builder = new StringBuilder();
       
        for (char c : ts.toCharArray()) {
          
          /*Get rid of all punctuation here except the angle brackets that set off HTML tags; these, since they
          enclose words that we also want to not count as proper tokens, are left in here so that the whole
          tokens they enclose can be ignored later in InputDocumentAnnotator.*/
          
          if (Character.isLetterOrDigit(c) || c == '<' || c == '>') {
            builder.append(Character.isLowerCase(c) ? c: Character.toLowerCase(c));
          }
        }
        
        String finalToken = builder.toString();
        
        String finalTokenLemmatized = lemmatizer.lemmatize(finalToken);
        
        token.setToStringValue(finalTokenLemmatized);

        
        token.setToStringValue(finalToken);        
        
        token.addToIndexes();
        pos = matcher.end();
        
        index++;
      }
    }
  }
}

