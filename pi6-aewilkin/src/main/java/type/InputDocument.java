

/* First created by JCasGen Fri Sep 25 13:32:17 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** Stores all the questions and its associated answer candidates.
 * Updated by JCasGen Sun Oct 11 18:56:45 EDT 2015
 * XML source: /home/perilon/git/pi6-aewilkin/pi6-aewilkin/src/main/resources/descriptors/aaeDescriptor.xml
 * @generated */
public class InputDocument extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(InputDocument.class);
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
  protected InputDocument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public InputDocument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public InputDocument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public InputDocument(JCas jcas, int begin, int end) {
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
  //* Feature: QASet

  /** getter for QASet - gets The QASet type feature for the InputDocument type
   * @generated
   * @return value of the feature 
   */
  public QASet getQASet() {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_QASet == null)
      jcasType.jcas.throwFeatMissing("QASet", "type.InputDocument");
    return (QASet)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_QASet)));}
    
  /** setter for QASet - sets The QASet type feature for the InputDocument type 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQASet(QASet v) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_QASet == null)
      jcasType.jcas.throwFeatMissing("QASet", "type.InputDocument");
    jcasType.ll_cas.ll_setRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_QASet, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    