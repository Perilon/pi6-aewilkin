import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.fit.util.JCasUtil;

import type.Passage;
import type.Question;
import type.Token;
import type.QASet;
import type.InputDocument;
import type.Ngram;

public class InputDocumentAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    
    String[] stopwords = {"a", "as", "able", "about", "above", "according", "accordingly", "across", "actually", "after", "afterwards", "again", "against", "aint", "all", "allow", "allows", "almost", "alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway", "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask", "asking", "associated", "at", "available", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both", "brief", "but", "by", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes", "certain", "certainly", "changes", "clearly", "co", "com", "come", "comes", "concerning", "consequently", "consider", "considering", "contain", "containing", "contains", "corresponding", "could", "couldnt", "course", "currently", "definitely", "described", "despite", "did", "didnt", "different", "do", "does", "doesnt", "doing", "dont", "done", "down", "downwards", "during", "each", "edu", "eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "exactly", "example", "except", "far", "few", "ff", "fifth", "first", "five", "followed", "following", "follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", "however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself", "just", "keep", "keeps", "kept", "know", "knows", "known", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks", "ltd", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself", "name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere", "obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own", "particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides", "que", "quite", "qv", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure", "ts", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", "un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "value", "various", "very", "via", "viz", "vs", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "zero"};
    
    FSIndex passageIndex = aJCas.getAnnotationIndex(Passage.type);
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);
//    FSIndex tokenIndex = aJCas.getAnnotationIndex(Token.type);
    FSIndex inputDocumentIndex = aJCas.getAnnotationIndex(InputDocument.type);   
    
    
    FSIndex QASetIndex = aJCas.getAnnotationIndex(QASet.type);

    InputDocument inputDocument = new InputDocument(aJCas);
    
    Iterator qaIter = QASetIndex.iterator();
    
    
    while (qaIter.hasNext()) {   
      
      QASet qaSet = new QASet(aJCas);
      
      qaSet = (QASet) qaIter.next();
      
      Question question = qaSet.getQuestion();
      
//      Now get the tokens in the question, put their string versions in a string array.
      
      FSIndex tokenIndex = aJCas.getAnnotationIndex(Token.type);
      
      List<Token> tokenQuestionList = JCasUtil.selectCovered(aJCas, Token.class, question.getBegin() - 1, question.getEnd());
      
      int questionListLen = tokenQuestionList.size();
          
      String[] tokenQuestionStringArray = new String[questionListLen];

      for (int i = 0; i < questionListLen; i++) {
        tokenQuestionStringArray[i] = tokenQuestionList.get(i).getToStringValue();
      }
      
      
      /*Do the same thing for the ngrams.*/
      
      FSIndex nGramIndexQuestion = aJCas.getAnnotationIndex(Ngram.type);
      List<Ngram> nGramQuestionList = JCasUtil.selectCovered(aJCas, Ngram.class, question.getBegin() - 1, question.getEnd());
      int questionNgramLen = nGramQuestionList.size();
      String[] nGramQuestionStringArray = new String[questionNgramLen];
      for (int i = 0; i < questionNgramLen; i++) {
        nGramQuestionStringArray[i] = nGramQuestionList.get(i).getToStringValue();
      }
      
      
      
//      Now for each answer, get the tokens, put their string versions in a string array, and calculate the score.
      
      FSArray passageFSArray = qaSet.getPassageFSArray();
      
      
      int passageFSArrayLen = passageFSArray.size();
      
      for (int i = 0; i < passageFSArrayLen; i++) {
        Passage passage = (Passage) passageFSArray.get(i);
        
        List<Token> tokenPassageList = JCasUtil.selectCovered(aJCas, Token.class, passage.getBegin() - 1, passage.getEnd());
        
        int passageListLen = tokenPassageList.size();
        
        String[] tokenPassageStringArray = new String[passageListLen];
        
        for (int j = 0; j < passageListLen; j++) {
          tokenPassageStringArray[j] = tokenPassageList.get(j).getToStringValue();
        }
        
        
        
        /*Get the passage ngrams too.*/
        
        FSIndex nGramIndexPassage = aJCas.getAnnotationIndex(Ngram.type);
        List<Ngram> nGramPassageList = JCasUtil.selectCovered(aJCas, Ngram.class, passage.getBegin() - 1, passage.getEnd());
        int passageNgramLen = nGramPassageList.size();
        String[] nGramPassageStringArray = new String[passageNgramLen];
        for (int h = 0; h < passageNgramLen; h++) {
          nGramPassageStringArray[h] = nGramPassageList.get(h).getToStringValue();
        }
        
        
        /*Calculate score for tokens.*/

        int matchesCounter = 0;
        int worthyMatches = 0;
        
        for (int k = 0; k < tokenQuestionStringArray.length; k++) {

          for (int L = 0; L < tokenPassageStringArray.length; L++) {
            
            /*Precision is calculated with the numerator being the number of matches (naturally) and the denominator
            being the number of words that represent "real" tokens in the passage; i.e., this disincludes HTML
            tags and the words they enclose.*/
            
            if (!tokenPassageStringArray[L].equals("") &&
                    tokenPassageStringArray[L].charAt(0) != '<' && 
                    tokenPassageStringArray[L].charAt(tokenPassageStringArray[L].length() - 1) != '>') {
//                    !(Arrays.asList(stopwords).contains(tokenPassageStringArray[L])) &&
//                    !(Arrays.asList(stopwords).contains(tokenQuestionStringArray[k]))) {
              worthyMatches++;
              if (tokenQuestionStringArray[k].equals(tokenPassageStringArray[L])) {
                matchesCounter++;
              }
            }
          }
        }
        
        
        double precision = (double) matchesCounter / (double) worthyMatches;
        double recall = (double) matchesCounter / (double) tokenQuestionStringArray.length;
        double F1;
        
        if ((precision + recall) != 0) {
          F1 = 2 * ((precision * recall) / (precision + recall));
        } else
          F1 = 0;
        
        
        
        /*Calculate score for ngrams.*/
        
        int matchesCounterNG = 0;
        int worthyMatchesNG = 0;
        
        for (int m = 0; m < nGramQuestionStringArray.length; m++) {

          for (int n = 0; n < nGramPassageStringArray.length; n++) {
            
            /*Precision is calculated with the numerator being the number of matches (naturally) and the denominator
            being the number of words that represent "real" tokens in the passage; i.e., this disincludes HTML
            tags and the words they enclose.*/
            
            if (!nGramPassageStringArray[n].equals("") &&
                    nGramPassageStringArray[n].charAt(0) != '<' && 
                            nGramPassageStringArray[n].charAt(nGramPassageStringArray[n].length() - 1) != '>') {
              worthyMatchesNG++;
              if (nGramQuestionStringArray[m].equals(nGramPassageStringArray[n])) {
                matchesCounterNG++;
              }
            }
          }
        }
        
        
        double precisionNG = (double) matchesCounterNG / (double) worthyMatchesNG;
        double recallNG = (double) matchesCounterNG / (double) tokenQuestionStringArray.length;
        double F1NG;
        
        if ((precisionNG + recallNG) != 0) {
          F1NG = 2 * ((precisionNG * recallNG) / (precisionNG + recallNG));
        } else
          F1NG = 0;
        
        
        
        
        passage.setScore(F1NG);
        
//        passage.setScore(recall);
        
//        System.out.println("matchesCounter = " + matchesCounter);
//        System.out.println("passageListLen = " + passageListLen);
//        System.out.println("score = " + ((double) matchesCounter / (double) passageListLen));
        passage.addToIndexes();
        
//        System.out.println(passage);

      }
      
      
      /*Define a class for passages that is made comparable, in order to be able to sort the passages by score using a regular array instead of a 
      stupid FSArray that can't implement jack.  This array will then be turned back into an FSArray, which will appear ranked, and that will become the
      RankedPassageFSArray feature of the QASet type.*/
      
      class Psg implements Comparable {
        
        private int begin;
        private int end;
        private String sentence;
        private String sentLem;
        private double score;
        private boolean label;
        private String sourceDocID;
        private String id;
       
        public Psg() {
        }
        
        public void setBegin(int bg) {
          this.begin = bg;
        }
        
        public void setEnd(int e) {
          this.end = e;
        }
        
        public void setSentence(String sent) {
          this.sentence = sent;
        }
        
        public void setSentLem(String sentLem) {
          this.sentLem = sentLem;
        }
        
        public void setScore(double sc) {
          this.score = sc;
        }
        
        public void setLabel(boolean lb) {
          this.label = lb;
        }
        
        public void setSourceDocID(String sdi) {
          this.sourceDocID = sdi;
        }
        
        public void setID(String id) {
          this.id = id;
        }
        
        public int getBegin() {
          return this.begin;
        }
        
        public int getEnd() {
          return this.end;
        }
        
        public String getSentence() {
          return this.sentence;
        }
        
        public String getSentLem() {
          return this.sentLem;
        }
        
        public double getScore() {
          return this.score;
        }
        
        public boolean getLabel() {
          return this.label;
        }
        
        public String getSourceDocID() {
          return this.sourceDocID;
        }
        
        public String getId() {
          return this.id;
        }

        public int compareTo(Object anotherPsg) {
          if (!(anotherPsg instanceof Psg)) {
            throw new ClassCastException("A Passage object is expected.");
          }
          double anotherPsgScore = ((Psg) anotherPsg).getScore();
          return Double.compare(anotherPsgScore, this.score);
        }
      }
      
      /*Put each member of passageFSArray into a regular array; then sort the array*/
      
      Psg[] psgArray = new Psg[passageFSArrayLen];
      
      for (int i = 0; i < passageFSArrayLen; i++) {
        Passage passage = (Passage) passageFSArray.get(i);
        
        Psg psg = new Psg();
        
        psg.setBegin(passage.getBegin());
        psg.setEnd(passage.getEnd());
        psg.setScore(passage.getScore());
        psg.setSentence(passage.getSentence());
        psg.setSentence(passage.getSentenceLemmatized());
        psg.setLabel(passage.getLabel());
        psg.setSourceDocID(passage.getSourceDocId());
        psg.setID(passage.getId());
        
        psgArray[i] = psg;
      }
      
      Arrays.sort(psgArray);
      
      
      /*Then put the items in that array, which are now ordered by score, into a new FSArray.  That FSArray becomes the
      RankedPassageFSArray feature of the QASet*/
      
      
      FSArray RankedPassageFSArray = new FSArray(aJCas, passageFSArrayLen);
      
      for (int i = 0; i < passageFSArrayLen; i++) {
        Passage newPass = new Passage(aJCas);
        
        newPass.setBegin(psgArray[i].getBegin());
        newPass.setEnd(psgArray[i].getEnd());
        newPass.setScore(psgArray[i].getScore());
        newPass.setSentence(psgArray[i].getSentence());
        newPass.setSentenceLemmatized(psgArray[i].getSentLem());
        newPass.setLabel(psgArray[i].getLabel());
        newPass.setSourceDocId(psgArray[i].getSourceDocID());
        newPass.setId(psgArray[i].getId());
        
        /*We're still in the same question of the question iterator existing below the iterator of the QASet, so this should
        be the right one.*/
        
        newPass.setQuestion(question);
        
        RankedPassageFSArray.set(i, newPass);
      }
      
      
      /*Now we have the ranked passages, we can actually compute the various metrics that depend on it, and add those values as features of the
      passages and the QASet*/
      
      int totalNumCorrect = 0;
      
      for (int i = 0; i < passageFSArrayLen; i++) {
        if ((((Passage) RankedPassageFSArray.get(i)).getLabel()) == true) {
          totalNumCorrect++;
        }
      }
      
      /*Calculate precisionAt1*/
      
      double precisionAt1 = 0;
//      double denom1;
//      
//      if (totalNumCorrect > 0) {
//        denom1 = 1;
//      } else {
//        denom1 = Double.MIN_VALUE;
//      }
//      
//      int numAt1Correct = 0;
//      
//      if ((((Passage) RankedPassageFSArray.get(0)).getLabel()) == true) {
//        numAt1Correct++;
//      }
//      
//      precisionAt1 = numAt1Correct / denom1;
//      
//      qaSet.setPrecisionAt1(precisionAt1);
//      
//      Okay, I guess this can be less complicated.
      
      if (((((Passage) RankedPassageFSArray.get(0)).getLabel()) == true) && (totalNumCorrect > 0)) {
        precisionAt1 = 1;
      } else {
        precisionAt1 = 0;
      }
      
      qaSet.setPrecisionAt1(precisionAt1);
      
      
      /*Calculate precisionAt5*/
      
      double precisionAt5 = 0;
      int numAt5Correct = 0;

//      double denom5;
//      
//      if (totalNumCorrect > 5) {
//        denom5 = 5;
//      } else if (totalNumCorrect <= 5 && totalNumCorrect > 0) {
//        denom5 = totalNumCorrect;
//      } else {
//        denom5 = Double.MIN_VALUE;
//      }
//      
//      
//      for (int i = 0; i < 5; i++) {
//        if ((((Passage) RankedPassageFSArray.get(i)).getLabel()) == true) {
//          numAt5Correct++;
//        }
//      }
//      
//      precisionAt5 = numAt5Correct / denom5;
//      
//      qaSet.setPrecisionAt5(precisionAt5);
//      
//      This is also less complicated than I thought it was.
      
      if (totalNumCorrect > 0) {
        for (int i = 0; i < 5; i++) {
          if ((((Passage) RankedPassageFSArray.get(i)).getLabel()) == true) {
            numAt5Correct++;
          }
        }
        precisionAt5 = (double) numAt5Correct / (double) 5; 
      } else {
        precisionAt5 = 0;
      }
      
      qaSet.setPrecisionAt5(precisionAt5);
      
      
      /*Calculate Reciprocal Rank*/
      
//      I guess we're not doing it this way.
//
//      double mrrRunningTotal = 0;
//      
//      for (int i = 0; i < passageFSArrayLen; i++) {
//        if ((((Passage) RankedPassageFSArray.get(i)).getLabel()) == true ) {
//          double rr = (double) (1/(double) (i+1));
//          mrrRunningTotal += rr;
//          
////          (qaSet.getRankedPassageFSArray(i)).setReciprocalRank(rr);
//          
//        }
//      }
      
//      double MRR;
//        
//      if (totalNumCorrect > 0) {
//        MRR = mrrRunningTotal / (double) totalNumCorrect;
//      } else {
//        MRR = Double.MIN_VALUE;
//      }
//      
//      qaSet.setMeanReciprocalRank(MRR);
      
      
//      We're doing it this way!  Here's your reciprocal rank:
      
      double RR = 0;
      
      for (int i = 0; i < passageFSArrayLen; i++) {
        if ((((Passage) RankedPassageFSArray.get(i)).getLabel()) == true ) {
          RR = (1 / (double) (i + 1));
          break;
         }
       }      
      
      qaSet.setReciprocalRank(RR);
      
      
      /*Calculate Average Precision*/
      
      double apRunningTotal = 0;
      double numCorrectRunningTotal = 0;
      
      for (int i = 0; i < passageFSArrayLen; i++) {
        if ((((Passage) RankedPassageFSArray.get(i)).getLabel()) == true ) {
          numCorrectRunningTotal++;
          apRunningTotal += (numCorrectRunningTotal / (double) (i+1));
        }
      }
          
      double AP;
      
      if (totalNumCorrect > 0) {
        AP = apRunningTotal / (double) totalNumCorrect;
      } else {
        AP = 0;
      }
      
      /*Calculate TP, FP, TN, FN*/
      
      qaSet.setRankThreshold(5);
      double rankThreshold = qaSet.getRankThreshold();
      
      int TP = 0;
      int FP = 0;
      int TN = 0;
      int FN = 0;
      
      for (int i = 0; i < passageFSArrayLen; i++) {
        if (((((Passage) RankedPassageFSArray.get(i)).getLabel()) == true) && i < rankThreshold) {
          TP++;
        } else if (((((Passage) RankedPassageFSArray.get(i)).getLabel()) == false) && i < rankThreshold) {
          FP++;
        } else if (((((Passage) RankedPassageFSArray.get(i)).getLabel()) == true) && i >= rankThreshold) {
          FN++;
        } else if (((((Passage) RankedPassageFSArray.get(i)).getLabel()) == false) && i >= rankThreshold) {
          TN++;
        }
      }
      
      /*Calculate precision, recall, accuracy, error, and F1*/
      
      double tp = (double) TP;
      double fp = (double) FP;
      double tn = (double) TN;
      double fn = (double) FN;
      double precision = 0;
      double recall = 0;
      double accuracy = 0;
      double error = 0;
      double f1 = 0;     
      
      if ((tp + fp) != 0) {
        precision = tp / (tp + fp);
      } else {
        precision = 0;
      }
      
      if ((tp + fn) != 0) {
        recall = tp / (tp + fn);
      } else {
        recall = 0;
      }
      
      if ((tp + fp + tn + fn) != 0) {
        accuracy = (tp + tn) / (tp + fp + tn + fn);
        error = (fp + fn) / (tp + fp + tn + fn);
      } else {
        accuracy = 0;
        error = 0;
      }

      if ((precision + recall) != 0) {
        f1 = (2 * ((precision * recall) / (precision + recall)));
      } else {
        f1 = 0;
      }
      
      /*Set all the various values*/
      
      qaSet.setTP(TP);
      qaSet.setFP(FP);
      qaSet.setFN(FN);
      qaSet.setTN(TN);
      
      qaSet.setPrecision(precision);
      qaSet.setRecall(recall);
      qaSet.setAccuracy(accuracy);
      qaSet.setError(error);
      qaSet.setF1(f1);
      
      qaSet.setAveragePrecision(AP);      
      
      qaSet.setSize(passageFSArrayLen);
      
      qaSet.setNumCorrect(totalNumCorrect);
      
      qaSet.setRankedPassageFSArray(RankedPassageFSArray);
      
      inputDocument.setQASet(qaSet);
      

          
      inputDocument.addToIndexes();
    }
  }
}