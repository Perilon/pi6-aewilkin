import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
     
     Random rand = new Random(123456789);
     
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
            
            int questionCounter = 0;
            double apRunningTotal = 0;
            double rrRunningTotal = 0;
            
            bw.write("Question ID,Precision at 1,Precision at 5,Reciprocal rank,Average precision\n");
            
            while (QASetIter.hasNext()) {
              
              
              QASet qaSet = (QASet) QASetIter.next();
                                          
              String ID = ((Question) qaSet.getQuestion()).getId();
              
              if (subset.contains(Integer.parseInt(ID))) {
                
                questionCounter++;
              
                double Pat1 = qaSet.getPrecisionAt1();
                double Pat5 = qaSet.getPrecisionAt5();
                double RR = qaSet.getReciprocalRank();
                
                rrRunningTotal += RR;
                
                double AP = qaSet.getAveragePrecision();
                
                apRunningTotal += AP;
                              
                bw.write(ID + "," + Double.toString(Pat1) + "," + Double.toString(Pat5) + "," + 
                        Double.toString(RR) + "," + Double.toString(AP) + "\n");
              }
            }
            
            double MAP = apRunningTotal / (double) questionCounter;
            double MRR = rrRunningTotal / (double) questionCounter;
            
            System.out.println("Mean average precision: " + Double.toString(MAP));
            System.out.println("Mean reciprocal rank: " + Double.toString(MRR));
            
            bw.close();
            System.out.println("Done");
       }
          
      catch (IOException e) {
        e.printStackTrace();
      }
     }
  }
}
