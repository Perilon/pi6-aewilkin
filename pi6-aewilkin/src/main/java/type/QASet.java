

/* First created by JCasGen Sat Sep 26 17:18:45 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



import org.apache.uima.jcas.cas.FSArray;


/** Keeps track of which questions go with which answers
 * Updated by JCasGen Sun Oct 04 23:30:32 EDT 2015
 * XML source: /home/perilon/git/pi5-aewilkin/pi5-aewilkin/src/main/resources/descriptors/typeSystem.xml
 * @generated */
public class QASet extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(QASet.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected QASet() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public QASet(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public QASet(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public QASet(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
  //*--------------*
  //* Feature: Question

  /** getter for Question - gets The question in a QASet
   * @generated
   * @return value of the feature 
   */
  public Question getQuestion() {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_Question == null)
      jcasType.jcas.throwFeatMissing("Question", "type.QASet");
    return (Question)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_Question)));}
    
  /** setter for Question - sets The question in a QASet 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestion(Question v) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_Question == null)
      jcasType.jcas.throwFeatMissing("Question", "type.QASet");
    jcasType.ll_cas.ll_setRefValue(addr, ((QASet_Type)jcasType).casFeatCode_Question, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: PassageFSArray

  /** getter for PassageFSArray - gets An FSArray of the passages purporting to answer a question in a QASet
   * @generated
   * @return value of the feature 
   */
  public FSArray getPassageFSArray() {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_PassageFSArray == null)
      jcasType.jcas.throwFeatMissing("PassageFSArray", "type.QASet");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_PassageFSArray)));}
    
  /** setter for PassageFSArray - sets An FSArray of the passages purporting to answer a question in a QASet 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPassageFSArray(FSArray v) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_PassageFSArray == null)
      jcasType.jcas.throwFeatMissing("PassageFSArray", "type.QASet");
    jcasType.ll_cas.ll_setRefValue(addr, ((QASet_Type)jcasType).casFeatCode_PassageFSArray, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for PassageFSArray - gets an indexed value - An FSArray of the passages purporting to answer a question in a QASet
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Passage getPassageFSArray(int i) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_PassageFSArray == null)
      jcasType.jcas.throwFeatMissing("PassageFSArray", "type.QASet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_PassageFSArray), i);
    return (Passage)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_PassageFSArray), i)));}

  /** indexed setter for PassageFSArray - sets an indexed value - An FSArray of the passages purporting to answer a question in a QASet
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setPassageFSArray(int i, Passage v) { 
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_PassageFSArray == null)
      jcasType.jcas.throwFeatMissing("PassageFSArray", "type.QASet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_PassageFSArray), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_PassageFSArray), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: RankedPassageFSArray

  /** getter for RankedPassageFSArray - gets The passages for each question, like in PassageFSArray, but ranked in descending order of score
   * @generated
   * @return value of the feature 
   */
  public FSArray getRankedPassageFSArray() {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_RankedPassageFSArray == null)
      jcasType.jcas.throwFeatMissing("RankedPassageFSArray", "type.QASet");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_RankedPassageFSArray)));}
    
  /** setter for RankedPassageFSArray - sets The passages for each question, like in PassageFSArray, but ranked in descending order of score 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRankedPassageFSArray(FSArray v) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_RankedPassageFSArray == null)
      jcasType.jcas.throwFeatMissing("RankedPassageFSArray", "type.QASet");
    jcasType.ll_cas.ll_setRefValue(addr, ((QASet_Type)jcasType).casFeatCode_RankedPassageFSArray, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for RankedPassageFSArray - gets an indexed value - The passages for each question, like in PassageFSArray, but ranked in descending order of score
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Passage getRankedPassageFSArray(int i) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_RankedPassageFSArray == null)
      jcasType.jcas.throwFeatMissing("RankedPassageFSArray", "type.QASet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_RankedPassageFSArray), i);
    return (Passage)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_RankedPassageFSArray), i)));}

  /** indexed setter for RankedPassageFSArray - sets an indexed value - The passages for each question, like in PassageFSArray, but ranked in descending order of score
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setRankedPassageFSArray(int i, Passage v) { 
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_RankedPassageFSArray == null)
      jcasType.jcas.throwFeatMissing("RankedPassageFSArray", "type.QASet");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_RankedPassageFSArray), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((QASet_Type)jcasType).casFeatCode_RankedPassageFSArray), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: size

  /** getter for size - gets The number of passages in a QASet; the size of the PassageFSArray and RankedPassageFSArray
   * @generated
   * @return value of the feature 
   */
  public int getSize() {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_size == null)
      jcasType.jcas.throwFeatMissing("size", "type.QASet");
    return jcasType.ll_cas.ll_getIntValue(addr, ((QASet_Type)jcasType).casFeatCode_size);}
    
  /** setter for size - sets The number of passages in a QASet; the size of the PassageFSArray and RankedPassageFSArray 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSize(int v) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_size == null)
      jcasType.jcas.throwFeatMissing("size", "type.QASet");
    jcasType.ll_cas.ll_setIntValue(addr, ((QASet_Type)jcasType).casFeatCode_size, v);}    
   
    
  //*--------------*
  //* Feature: precisionAt1

  /** getter for precisionAt1 - gets The precision at 1 for the passages in the QASet
   * @generated
   * @return value of the feature 
   */
  public double getPrecisionAt1() {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_precisionAt1 == null)
      jcasType.jcas.throwFeatMissing("precisionAt1", "type.QASet");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((QASet_Type)jcasType).casFeatCode_precisionAt1);}
    
  /** setter for precisionAt1 - sets The precision at 1 for the passages in the QASet 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPrecisionAt1(double v) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_precisionAt1 == null)
      jcasType.jcas.throwFeatMissing("precisionAt1", "type.QASet");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((QASet_Type)jcasType).casFeatCode_precisionAt1, v);}    
   
    
  //*--------------*
  //* Feature: precisionAt5

  /** getter for precisionAt5 - gets The precision at 5 of the passages in the QASet
   * @generated
   * @return value of the feature 
   */
  public double getPrecisionAt5() {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_precisionAt5 == null)
      jcasType.jcas.throwFeatMissing("precisionAt5", "type.QASet");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((QASet_Type)jcasType).casFeatCode_precisionAt5);}
    
  /** setter for precisionAt5 - sets The precision at 5 of the passages in the QASet 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPrecisionAt5(double v) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_precisionAt5 == null)
      jcasType.jcas.throwFeatMissing("precisionAt5", "type.QASet");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((QASet_Type)jcasType).casFeatCode_precisionAt5, v);}    
   
    
  //*--------------*
  //* Feature: reciprocalRank

  /** getter for reciprocalRank - gets The reciprocal rank of the first correct answer of the ranked passages in a QASet
   * @generated
   * @return value of the feature 
   */
  public double getReciprocalRank() {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_reciprocalRank == null)
      jcasType.jcas.throwFeatMissing("reciprocalRank", "type.QASet");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((QASet_Type)jcasType).casFeatCode_reciprocalRank);}
    
  /** setter for reciprocalRank - sets The reciprocal rank of the first correct answer of the ranked passages in a QASet 
   * @generated
   * @param v value to set into the feature 
   */
  public void setReciprocalRank(double v) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_reciprocalRank == null)
      jcasType.jcas.throwFeatMissing("reciprocalRank", "type.QASet");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((QASet_Type)jcasType).casFeatCode_reciprocalRank, v);}    
   
    
  //*--------------*
  //* Feature: averagePrecision

  /** getter for averagePrecision - gets The average precision of the questions in a QASet
   * @generated
   * @return value of the feature 
   */
  public double getAveragePrecision() {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_averagePrecision == null)
      jcasType.jcas.throwFeatMissing("averagePrecision", "type.QASet");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((QASet_Type)jcasType).casFeatCode_averagePrecision);}
    
  /** setter for averagePrecision - sets The average precision of the questions in a QASet 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAveragePrecision(double v) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_averagePrecision == null)
      jcasType.jcas.throwFeatMissing("averagePrecision", "type.QASet");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((QASet_Type)jcasType).casFeatCode_averagePrecision, v);}    
   
    
  //*--------------*
  //* Feature: numCorrect

  /** getter for numCorrect - gets Number of passages for a question that are correct answers
   * @generated
   * @return value of the feature 
   */
  public int getNumCorrect() {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_numCorrect == null)
      jcasType.jcas.throwFeatMissing("numCorrect", "type.QASet");
    return jcasType.ll_cas.ll_getIntValue(addr, ((QASet_Type)jcasType).casFeatCode_numCorrect);}
    
  /** setter for numCorrect - sets Number of passages for a question that are correct answers 
   * @generated
   * @param v value to set into the feature 
   */
  public void setNumCorrect(int v) {
    if (QASet_Type.featOkTst && ((QASet_Type)jcasType).casFeat_numCorrect == null)
      jcasType.jcas.throwFeatMissing("numCorrect", "type.QASet");
    jcasType.ll_cas.ll_setIntValue(addr, ((QASet_Type)jcasType).casFeatCode_numCorrect, v);}    
  }

    