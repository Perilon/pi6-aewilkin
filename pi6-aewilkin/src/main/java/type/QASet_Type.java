
/* First created by JCasGen Sat Sep 26 17:18:45 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;

import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** Keeps track of which questions go with which answers
 * Updated by JCasGen Sun Oct 11 23:59:26 EDT 2015
 * @generated */
public class QASet_Type extends ComponentAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (QASet_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = QASet_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new QASet(addr, QASet_Type.this);
  			   QASet_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new QASet(addr, QASet_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = QASet.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.QASet");



  /** @generated */
  final Feature casFeat_Question;
  /** @generated */
  final int     casFeatCode_Question;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQuestion(int addr) {
        if (featOkTst && casFeat_Question == null)
      jcas.throwFeatMissing("Question", "type.QASet");
    return ll_cas.ll_getRefValue(addr, casFeatCode_Question);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuestion(int addr, int v) {
        if (featOkTst && casFeat_Question == null)
      jcas.throwFeatMissing("Question", "type.QASet");
    ll_cas.ll_setRefValue(addr, casFeatCode_Question, v);}
    
  
 
  /** @generated */
  final Feature casFeat_PassageFSArray;
  /** @generated */
  final int     casFeatCode_PassageFSArray;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getPassageFSArray(int addr) {
        if (featOkTst && casFeat_PassageFSArray == null)
      jcas.throwFeatMissing("PassageFSArray", "type.QASet");
    return ll_cas.ll_getRefValue(addr, casFeatCode_PassageFSArray);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPassageFSArray(int addr, int v) {
        if (featOkTst && casFeat_PassageFSArray == null)
      jcas.throwFeatMissing("PassageFSArray", "type.QASet");
    ll_cas.ll_setRefValue(addr, casFeatCode_PassageFSArray, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getPassageFSArray(int addr, int i) {
        if (featOkTst && casFeat_PassageFSArray == null)
      jcas.throwFeatMissing("PassageFSArray", "type.QASet");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_PassageFSArray), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_PassageFSArray), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_PassageFSArray), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setPassageFSArray(int addr, int i, int v) {
        if (featOkTst && casFeat_PassageFSArray == null)
      jcas.throwFeatMissing("PassageFSArray", "type.QASet");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_PassageFSArray), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_PassageFSArray), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_PassageFSArray), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_RankedPassageFSArray;
  /** @generated */
  final int     casFeatCode_RankedPassageFSArray;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getRankedPassageFSArray(int addr) {
        if (featOkTst && casFeat_RankedPassageFSArray == null)
      jcas.throwFeatMissing("RankedPassageFSArray", "type.QASet");
    return ll_cas.ll_getRefValue(addr, casFeatCode_RankedPassageFSArray);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRankedPassageFSArray(int addr, int v) {
        if (featOkTst && casFeat_RankedPassageFSArray == null)
      jcas.throwFeatMissing("RankedPassageFSArray", "type.QASet");
    ll_cas.ll_setRefValue(addr, casFeatCode_RankedPassageFSArray, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getRankedPassageFSArray(int addr, int i) {
        if (featOkTst && casFeat_RankedPassageFSArray == null)
      jcas.throwFeatMissing("RankedPassageFSArray", "type.QASet");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_RankedPassageFSArray), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_RankedPassageFSArray), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_RankedPassageFSArray), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setRankedPassageFSArray(int addr, int i, int v) {
        if (featOkTst && casFeat_RankedPassageFSArray == null)
      jcas.throwFeatMissing("RankedPassageFSArray", "type.QASet");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_RankedPassageFSArray), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_RankedPassageFSArray), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_RankedPassageFSArray), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_size;
  /** @generated */
  final int     casFeatCode_size;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSize(int addr) {
        if (featOkTst && casFeat_size == null)
      jcas.throwFeatMissing("size", "type.QASet");
    return ll_cas.ll_getIntValue(addr, casFeatCode_size);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSize(int addr, int v) {
        if (featOkTst && casFeat_size == null)
      jcas.throwFeatMissing("size", "type.QASet");
    ll_cas.ll_setIntValue(addr, casFeatCode_size, v);}
    
  
 
  /** @generated */
  final Feature casFeat_precisionAt1;
  /** @generated */
  final int     casFeatCode_precisionAt1;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getPrecisionAt1(int addr) {
        if (featOkTst && casFeat_precisionAt1 == null)
      jcas.throwFeatMissing("precisionAt1", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_precisionAt1);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPrecisionAt1(int addr, double v) {
        if (featOkTst && casFeat_precisionAt1 == null)
      jcas.throwFeatMissing("precisionAt1", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_precisionAt1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_precisionAt5;
  /** @generated */
  final int     casFeatCode_precisionAt5;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getPrecisionAt5(int addr) {
        if (featOkTst && casFeat_precisionAt5 == null)
      jcas.throwFeatMissing("precisionAt5", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_precisionAt5);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPrecisionAt5(int addr, double v) {
        if (featOkTst && casFeat_precisionAt5 == null)
      jcas.throwFeatMissing("precisionAt5", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_precisionAt5, v);}
    
  
 
  /** @generated */
  final Feature casFeat_reciprocalRank;
  /** @generated */
  final int     casFeatCode_reciprocalRank;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getReciprocalRank(int addr) {
        if (featOkTst && casFeat_reciprocalRank == null)
      jcas.throwFeatMissing("reciprocalRank", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_reciprocalRank);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setReciprocalRank(int addr, double v) {
        if (featOkTst && casFeat_reciprocalRank == null)
      jcas.throwFeatMissing("reciprocalRank", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_reciprocalRank, v);}
    
  
 
  /** @generated */
  final Feature casFeat_averagePrecision;
  /** @generated */
  final int     casFeatCode_averagePrecision;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getAveragePrecision(int addr) {
        if (featOkTst && casFeat_averagePrecision == null)
      jcas.throwFeatMissing("averagePrecision", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_averagePrecision);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAveragePrecision(int addr, double v) {
        if (featOkTst && casFeat_averagePrecision == null)
      jcas.throwFeatMissing("averagePrecision", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_averagePrecision, v);}
    
  
 
  /** @generated */
  final Feature casFeat_numCorrect;
  /** @generated */
  final int     casFeatCode_numCorrect;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getNumCorrect(int addr) {
        if (featOkTst && casFeat_numCorrect == null)
      jcas.throwFeatMissing("numCorrect", "type.QASet");
    return ll_cas.ll_getIntValue(addr, casFeatCode_numCorrect);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNumCorrect(int addr, int v) {
        if (featOkTst && casFeat_numCorrect == null)
      jcas.throwFeatMissing("numCorrect", "type.QASet");
    ll_cas.ll_setIntValue(addr, casFeatCode_numCorrect, v);}
    
  
 
  /** @generated */
  final Feature casFeat_TP;
  /** @generated */
  final int     casFeatCode_TP;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTP(int addr) {
        if (featOkTst && casFeat_TP == null)
      jcas.throwFeatMissing("TP", "type.QASet");
    return ll_cas.ll_getIntValue(addr, casFeatCode_TP);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTP(int addr, int v) {
        if (featOkTst && casFeat_TP == null)
      jcas.throwFeatMissing("TP", "type.QASet");
    ll_cas.ll_setIntValue(addr, casFeatCode_TP, v);}
    
  
 
  /** @generated */
  final Feature casFeat_FP;
  /** @generated */
  final int     casFeatCode_FP;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getFP(int addr) {
        if (featOkTst && casFeat_FP == null)
      jcas.throwFeatMissing("FP", "type.QASet");
    return ll_cas.ll_getIntValue(addr, casFeatCode_FP);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFP(int addr, int v) {
        if (featOkTst && casFeat_FP == null)
      jcas.throwFeatMissing("FP", "type.QASet");
    ll_cas.ll_setIntValue(addr, casFeatCode_FP, v);}
    
  
 
  /** @generated */
  final Feature casFeat_TN;
  /** @generated */
  final int     casFeatCode_TN;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTN(int addr) {
        if (featOkTst && casFeat_TN == null)
      jcas.throwFeatMissing("TN", "type.QASet");
    return ll_cas.ll_getIntValue(addr, casFeatCode_TN);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTN(int addr, int v) {
        if (featOkTst && casFeat_TN == null)
      jcas.throwFeatMissing("TN", "type.QASet");
    ll_cas.ll_setIntValue(addr, casFeatCode_TN, v);}
    
  
 
  /** @generated */
  final Feature casFeat_FN;
  /** @generated */
  final int     casFeatCode_FN;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getFN(int addr) {
        if (featOkTst && casFeat_FN == null)
      jcas.throwFeatMissing("FN", "type.QASet");
    return ll_cas.ll_getIntValue(addr, casFeatCode_FN);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFN(int addr, int v) {
        if (featOkTst && casFeat_FN == null)
      jcas.throwFeatMissing("FN", "type.QASet");
    ll_cas.ll_setIntValue(addr, casFeatCode_FN, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rankThreshold;
  /** @generated */
  final int     casFeatCode_rankThreshold;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getRankThreshold(int addr) {
        if (featOkTst && casFeat_rankThreshold == null)
      jcas.throwFeatMissing("rankThreshold", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_rankThreshold);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRankThreshold(int addr, double v) {
        if (featOkTst && casFeat_rankThreshold == null)
      jcas.throwFeatMissing("rankThreshold", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_rankThreshold, v);}
    
  
 
  /** @generated */
  final Feature casFeat_precision;
  /** @generated */
  final int     casFeatCode_precision;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getPrecision(int addr) {
        if (featOkTst && casFeat_precision == null)
      jcas.throwFeatMissing("precision", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_precision);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPrecision(int addr, double v) {
        if (featOkTst && casFeat_precision == null)
      jcas.throwFeatMissing("precision", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_precision, v);}
    
  
 
  /** @generated */
  final Feature casFeat_recall;
  /** @generated */
  final int     casFeatCode_recall;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getRecall(int addr) {
        if (featOkTst && casFeat_recall == null)
      jcas.throwFeatMissing("recall", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_recall);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRecall(int addr, double v) {
        if (featOkTst && casFeat_recall == null)
      jcas.throwFeatMissing("recall", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_recall, v);}
    
  
 
  /** @generated */
  final Feature casFeat_accuracy;
  /** @generated */
  final int     casFeatCode_accuracy;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getAccuracy(int addr) {
        if (featOkTst && casFeat_accuracy == null)
      jcas.throwFeatMissing("accuracy", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_accuracy);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAccuracy(int addr, double v) {
        if (featOkTst && casFeat_accuracy == null)
      jcas.throwFeatMissing("accuracy", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_accuracy, v);}
    
  
 
  /** @generated */
  final Feature casFeat_error;
  /** @generated */
  final int     casFeatCode_error;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getError(int addr) {
        if (featOkTst && casFeat_error == null)
      jcas.throwFeatMissing("error", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_error);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setError(int addr, double v) {
        if (featOkTst && casFeat_error == null)
      jcas.throwFeatMissing("error", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_error, v);}
    
  
 
  /** @generated */
  final Feature casFeat_F1;
  /** @generated */
  final int     casFeatCode_F1;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getF1(int addr) {
        if (featOkTst && casFeat_F1 == null)
      jcas.throwFeatMissing("F1", "type.QASet");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_F1);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setF1(int addr, double v) {
        if (featOkTst && casFeat_F1 == null)
      jcas.throwFeatMissing("F1", "type.QASet");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_F1, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public QASet_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Question = jcas.getRequiredFeatureDE(casType, "Question", "type.Question", featOkTst);
    casFeatCode_Question  = (null == casFeat_Question) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Question).getCode();

 
    casFeat_PassageFSArray = jcas.getRequiredFeatureDE(casType, "PassageFSArray", "uima.cas.FSArray", featOkTst);
    casFeatCode_PassageFSArray  = (null == casFeat_PassageFSArray) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_PassageFSArray).getCode();

 
    casFeat_RankedPassageFSArray = jcas.getRequiredFeatureDE(casType, "RankedPassageFSArray", "uima.cas.FSArray", featOkTst);
    casFeatCode_RankedPassageFSArray  = (null == casFeat_RankedPassageFSArray) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_RankedPassageFSArray).getCode();

 
    casFeat_size = jcas.getRequiredFeatureDE(casType, "size", "uima.cas.Integer", featOkTst);
    casFeatCode_size  = (null == casFeat_size) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_size).getCode();

 
    casFeat_precisionAt1 = jcas.getRequiredFeatureDE(casType, "precisionAt1", "uima.cas.Double", featOkTst);
    casFeatCode_precisionAt1  = (null == casFeat_precisionAt1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_precisionAt1).getCode();

 
    casFeat_precisionAt5 = jcas.getRequiredFeatureDE(casType, "precisionAt5", "uima.cas.Double", featOkTst);
    casFeatCode_precisionAt5  = (null == casFeat_precisionAt5) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_precisionAt5).getCode();

 
    casFeat_reciprocalRank = jcas.getRequiredFeatureDE(casType, "reciprocalRank", "uima.cas.Double", featOkTst);
    casFeatCode_reciprocalRank  = (null == casFeat_reciprocalRank) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_reciprocalRank).getCode();

 
    casFeat_averagePrecision = jcas.getRequiredFeatureDE(casType, "averagePrecision", "uima.cas.Double", featOkTst);
    casFeatCode_averagePrecision  = (null == casFeat_averagePrecision) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_averagePrecision).getCode();

 
    casFeat_numCorrect = jcas.getRequiredFeatureDE(casType, "numCorrect", "uima.cas.Integer", featOkTst);
    casFeatCode_numCorrect  = (null == casFeat_numCorrect) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_numCorrect).getCode();

 
    casFeat_TP = jcas.getRequiredFeatureDE(casType, "TP", "uima.cas.Integer", featOkTst);
    casFeatCode_TP  = (null == casFeat_TP) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_TP).getCode();

 
    casFeat_FP = jcas.getRequiredFeatureDE(casType, "FP", "uima.cas.Integer", featOkTst);
    casFeatCode_FP  = (null == casFeat_FP) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_FP).getCode();

 
    casFeat_TN = jcas.getRequiredFeatureDE(casType, "TN", "uima.cas.Integer", featOkTst);
    casFeatCode_TN  = (null == casFeat_TN) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_TN).getCode();

 
    casFeat_FN = jcas.getRequiredFeatureDE(casType, "FN", "uima.cas.Integer", featOkTst);
    casFeatCode_FN  = (null == casFeat_FN) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_FN).getCode();

 
    casFeat_rankThreshold = jcas.getRequiredFeatureDE(casType, "rankThreshold", "uima.cas.Double", featOkTst);
    casFeatCode_rankThreshold  = (null == casFeat_rankThreshold) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rankThreshold).getCode();

 
    casFeat_precision = jcas.getRequiredFeatureDE(casType, "precision", "uima.cas.Double", featOkTst);
    casFeatCode_precision  = (null == casFeat_precision) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_precision).getCode();

 
    casFeat_recall = jcas.getRequiredFeatureDE(casType, "recall", "uima.cas.Double", featOkTst);
    casFeatCode_recall  = (null == casFeat_recall) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_recall).getCode();

 
    casFeat_accuracy = jcas.getRequiredFeatureDE(casType, "accuracy", "uima.cas.Double", featOkTst);
    casFeatCode_accuracy  = (null == casFeat_accuracy) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_accuracy).getCode();

 
    casFeat_error = jcas.getRequiredFeatureDE(casType, "error", "uima.cas.Double", featOkTst);
    casFeatCode_error  = (null == casFeat_error) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_error).getCode();

 
    casFeat_F1 = jcas.getRequiredFeatureDE(casType, "F1", "uima.cas.Double", featOkTst);
    casFeatCode_F1  = (null == casFeat_F1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_F1).getCode();

  }
}



    