import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.XMLSerializer;
import org.xml.sax.SAXException;

import type.Question;
import type.Passage;
import type.InputDocument;
import type.QASet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PassageRankingWriter extends CasConsumer_ImplBase {
    
  /**
   * Name of configuration parameter that must be set to the path of a directory into which the
   * output files will be written.
   */
  
  public static final String PARAM_OUTPUTDIR = "OutputDir";
    
  public static final String PARAM_INPUTDIR = "InputDir";
  

  private File mOutputDir;

  private int mDocNum;

  public void initialize() throws ResourceInitializationException {
    mDocNum = 0;
    mOutputDir = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
//    mOutputDir = new File("/home/perilon/git/pi4-aewilkin/pi4-aewilkin/src/main/resources/outputData");
    if (!mOutputDir.exists()) {
      mOutputDir.mkdirs();
    }

  }


  public void processCas(CAS aCAS) throws ResourceProcessException {
    
    String modelFileName = null;

    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    
    String writeToFileName = "RankingMetrics.csv";

 // retreive the filename of the input file from the CAS
    FSIterator it = jcas.getAnnotationIndex(SourceDocumentInformation.type).iterator();
    File outFile = null;
    if (it.hasNext()) {
      SourceDocumentInformation fileLoc = (SourceDocumentInformation) it.next();
      File inFile;
      try {
        inFile = new File(new URL(fileLoc.getUri()).getPath());

        
        outFile = new File(mOutputDir, writeToFileName);
        modelFileName = mOutputDir.getAbsolutePath() + "/" + inFile.getName() + ".ecore";
      } catch (MalformedURLException e1) {
        // invalid URL, use default processing below
      }
    }
    
    
    if (outFile == null) {
      outFile = new File(mOutputDir, "doc" + mDocNum++);
    }
    
          
     String filenameString = (String) getConfigParameterValue(PARAM_OUTPUTDIR) + writeToFileName;
     
     System.out.println("filenameString = " + filenameString);
          
//     --------------------------------------------------------------------------------------------
     
     
     /*Get a list of all the question IDs that exist*/
     
     FSIndex inputDocumentIndex0 = jcas.getAnnotationIndex(InputDocument.type);
     FSIterator inputDocumentIter0 = inputDocumentIndex0.iterator();
     
     ArrayList<Integer> questionIDs = new ArrayList<Integer>();
     
     while (inputDocumentIter0.hasNext()) {
       InputDocument inputDocument = (InputDocument) inputDocumentIter0.next();

       FSIndex QASetIndex0 = jcas.getAnnotationIndex(QASet.type);
       FSIterator QASetIter0 = QASetIndex0.iterator();
       
       while (QASetIter0.hasNext()) {
         QASet qaSet0 = (QASet) QASetIter0.next();
         int id = Integer.parseInt(((Question) qaSet0.getQuestion()).getId());
         questionIDs.add(id);
       }
     }
     
     /*Get a list of 10 pseudorandom question IDs from the list of all question IDs*/
     
     Random rand = new Random(169719);
     
     int num = 10;
     int size = questionIDs.size();
     
     ArrayList<Integer> subset = new ArrayList<Integer>();
     
     Set<Integer> ints = new HashSet<Integer>();
     
     while (subset.size() < num) {
       int randInt = rand.nextInt(size);
       if (!ints.contains(randInt)) {
         ints.add(randInt);
         subset.add(questionIDs.get(randInt));
       }
     }
         
     FSIndex inputDocumentIndex = jcas.getAnnotationIndex(InputDocument.type);
     
     FSIterator inputDocumentIter = inputDocumentIndex.iterator();
     
     
     while (inputDocumentIter.hasNext()) {
     
       try {
         File file = new File(filenameString);
    
          // if file doesn't exist, then create it
          if (!file.exists()) {
//            System.out.println("!file.exists");
            file.createNewFile();
//            System.out.println("file created");
          }
    
          FileWriter fw = new FileWriter(file.getAbsoluteFile());
          BufferedWriter bw = new BufferedWriter(fw);
            
            InputDocument inputDocument = new InputDocument(jcas);
            inputDocument = (InputDocument) inputDocumentIter.next();
            
            FSIndex QASetIndex = jcas.getAnnotationIndex(QASet.type);
            FSIterator QASetIter = QASetIndex.iterator();
            
            /*Initialize various values to be calculated*/
            
            int questionCounter = 0;
            double apRunningTotal = 0;
            double rrRunningTotal = 0;
            double microAverageF1RunningTotal = 0;
            double tpRunningTotal = 0;
            double fpRunningTotal = 0;
            double fnRunningTotal = 0;
            
            /*Write header line of csv document*/
            
            bw.write("Question ID,Precision at 1,Precision at 5,Reciprocal rank,Average precision,,TP,FN,FP,TN,Precision,"
                    + "Recall,Accuracy,Error,F1\n");
            
            while (QASetIter.hasNext()) {
              
              QASet qaSet = (QASet) QASetIter.next();
                                          
              String ID = ((Question) qaSet.getQuestion()).getId();
              
              /*Do these calculations and print the results for only those QASets the question IDs of which have
              been pseudorandomly selected to be part of the test set*/
              
              if (subset.contains(Integer.parseInt(ID))) {
                
                questionCounter++;
              
                double Pat1 = qaSet.getPrecisionAt1();
                double Pat5 = qaSet.getPrecisionAt5();
                double RR = qaSet.getReciprocalRank();
                double AP = qaSet.getAveragePrecision();
                
                double TP = qaSet.getTP();
                double FP = qaSet.getFP();
                double TN = qaSet.getTN();
                double FN = qaSet.getFN();
                
                double Precision = qaSet.getPrecision();
                double Recall = qaSet.getRecall();
                double Accuracy = qaSet.getAccuracy();
                double Error = qaSet.getError();
                double F1 = qaSet.getF1();
                
                rrRunningTotal += RR;
                apRunningTotal += AP;
                microAverageF1RunningTotal += F1;
                
                tpRunningTotal += TP;
                fpRunningTotal += FP;
                fnRunningTotal += FN;
                
                /*Round the version of the answers that will be printed to the nearest thousandth,
                in cases where the decimal expansion goes beyond that place (I prefer this to truncating)*/
                
                BigDecimal bd = new BigDecimal(Pat5).setScale(3, RoundingMode.HALF_EVEN);
                Pat5 = bd.doubleValue();
                BigDecimal bd1 = new BigDecimal(RR).setScale(3, RoundingMode.HALF_EVEN);
                RR = bd1.doubleValue();
                BigDecimal bd2 = new BigDecimal(AP).setScale(3, RoundingMode.HALF_EVEN);
                AP = bd2.doubleValue();
                BigDecimal bd3 = new BigDecimal(Precision).setScale(3, RoundingMode.HALF_EVEN);
                Precision = bd3.doubleValue();
                BigDecimal bd4 = new BigDecimal(Recall).setScale(3, RoundingMode.HALF_EVEN);
                Recall = bd4.doubleValue();
                BigDecimal bd5 = new BigDecimal(Accuracy).setScale(3, RoundingMode.HALF_EVEN);
                Accuracy = bd5.doubleValue();
                BigDecimal bd6 = new BigDecimal(Error).setScale(3, RoundingMode.HALF_EVEN);
                Error = bd6.doubleValue();
                BigDecimal bd7 = new BigDecimal(F1).setScale(3, RoundingMode.HALF_EVEN);
                F1 = bd7.doubleValue();
                                              
                bw.write(ID + "," + Double.toString(Pat1) + "," + Double.toString(Pat5) + "," + 
                        Double.toString(RR) + "," + Double.toString(AP) + "," + "," + 
                        
                        Double.toString(TP) + "," + Double.toString(FN) + "," + 
                        Double.toString(FP) + "," + Double.toString(TN) + "," + 
                        Double.toString(Precision) + "," + Double.toString(Recall) + "," +
                        Double.toString(Accuracy) + "," + Double.toString(Error) + "," +
                        Double.toString(F1) + "\n");
              }
            }
            
            /*Calculate more values, round more values, print more values*/
            
            double MAP = apRunningTotal / (double) questionCounter;
            double MRR = rrRunningTotal / (double) questionCounter;
            double microAverageF1 = microAverageF1RunningTotal / (double) questionCounter;
            double macroPrecision = 0;
            double macroRecall = 0;
            double macroF1 = 0;
            
            if ((tpRunningTotal + fpRunningTotal) != 0) {
              macroPrecision = tpRunningTotal / (tpRunningTotal + fpRunningTotal);
            } else {
              macroPrecision = 0;
            }
            
            if ((tpRunningTotal + fnRunningTotal) != 0) {
              macroRecall = tpRunningTotal / (tpRunningTotal + fnRunningTotal);
            } else {
              macroRecall = 0;
            }       
            
            if ((macroPrecision + macroRecall) != 0) {
              macroF1 = (2 * ((macroPrecision * macroRecall) / (macroPrecision + macroRecall)));
            } else {
              macroF1 = 0;
            }
            
            BigDecimal bd8 = new BigDecimal(MAP).setScale(3, RoundingMode.HALF_EVEN);
            MAP = bd8.doubleValue();
            BigDecimal bd9 = new BigDecimal(MRR).setScale(3, RoundingMode.HALF_EVEN);
            MRR = bd9.doubleValue();
            BigDecimal bd10 = new BigDecimal(microAverageF1).setScale(3, RoundingMode.HALF_EVEN);
            microAverageF1 = bd10.doubleValue();
            BigDecimal bd11 = new BigDecimal(macroF1).setScale(3, RoundingMode.HALF_EVEN);
            macroF1 = bd11.doubleValue();
            
            System.out.println("Mean average precision: " + Double.toString(MAP));
            System.out.println("Mean reciprocal rank: " + Double.toString(MRR));
            System.out.println("Micro-average F1 score: " + Double.toString(microAverageF1));
            System.out.println("Macro-average F1 score: " + Double.toString(macroF1));
            System.out.println("TP total: " + Double.toString(tpRunningTotal));
            System.out.println("FP total: " + Double.toString(fpRunningTotal));
            System.out.println("FN total: " + Double.toString(fnRunningTotal));
            
            bw.write("\n\nMAP = " + Double.toString(MAP));
            bw.write("\nMRR = " + Double.toString(MRR));
            bw.write("\nMicro-average F1 = " + Double.toString(microAverageF1));
            bw.write("\nMacro-average F1 = " + Double.toString(macroF1));
            bw.write("\nTP total = " + Double.toString(tpRunningTotal));
            bw.write("\nFP total = " + Double.toString(fpRunningTotal));
            bw.write("\nFN total = " + Double.toString(fnRunningTotal));
            
            bw.close();
            System.out.println("Done");
       }
          
      catch (IOException e) {
        e.printStackTrace();
      }
     }
  }
}
