

/* First created by JCasGen Fri Sep 25 13:32:17 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** Stores the information about a question.
 * Updated by JCasGen Mon Oct 12 04:53:31 EDT 2015
 * XML source: /home/perilon/git/pi6-aewilkin/pi6-aewilkin/src/main/resources/descriptors/aaeDescriptor.xml
 * @generated */
public class Question extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Question.class);
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
  protected Question() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Question(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Question(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Question(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets The identifier for the question.
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets The identifier for the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: sentence

  /** getter for sentence - gets The text of the question.
   * @generated
   * @return value of the feature 
   */
  public String getSentence() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_sentence);}
    
  /** setter for sentence - sets The text of the question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentence(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_sentence, v);}    
   
    
  //*--------------*
  //* Feature: passages

  /** getter for passages - gets Passages associated with this question.
   * @generated
   * @return value of the feature 
   */
  public FSList getPassages() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.Question");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_passages)));}
    
  /** setter for passages - sets Passages associated with this question. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPassages(FSList v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_passages == null)
      jcasType.jcas.throwFeatMissing("passages", "type.Question");
    jcasType.ll_cas.ll_setRefValue(addr, ((Question_Type)jcasType).casFeatCode_passages, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: sentenceLemmatized

  /** getter for sentenceLemmatized - gets The text of the sentence, with each word lemmatized
   * @generated
   * @return value of the feature 
   */
  public String getSentenceLemmatized() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_sentenceLemmatized == null)
      jcasType.jcas.throwFeatMissing("sentenceLemmatized", "type.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_sentenceLemmatized);}
    
  /** setter for sentenceLemmatized - sets The text of the sentence, with each word lemmatized 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentenceLemmatized(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_sentenceLemmatized == null)
      jcasType.jcas.throwFeatMissing("sentenceLemmatized", "type.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_sentenceLemmatized, v);}    
  }

    