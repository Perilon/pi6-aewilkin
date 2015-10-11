
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
 * Updated by JCasGen Sun Oct 04 23:30:32 EDT 2015
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

  }
}



    