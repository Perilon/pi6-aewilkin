
/* First created by JCasGen Fri Sep 25 13:32:17 EDT 2015 */
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

/** Stores all the questions and its associated answer candidates.
 * Updated by JCasGen Mon Oct 12 04:53:31 EDT 2015
 * @generated */
public class InputDocument_Type extends ComponentAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (InputDocument_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = InputDocument_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new InputDocument(addr, InputDocument_Type.this);
  			   InputDocument_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new InputDocument(addr, InputDocument_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = InputDocument.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.InputDocument");
 
  /** @generated */
  final Feature casFeat_QASet;
  /** @generated */
  final int     casFeatCode_QASet;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQASet(int addr) {
        if (featOkTst && casFeat_QASet == null)
      jcas.throwFeatMissing("QASet", "type.InputDocument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_QASet);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQASet(int addr, int v) {
        if (featOkTst && casFeat_QASet == null)
      jcas.throwFeatMissing("QASet", "type.InputDocument");
    ll_cas.ll_setRefValue(addr, casFeatCode_QASet, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public InputDocument_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_QASet = jcas.getRequiredFeatureDE(casType, "QASet", "type.QASet", featOkTst);
    casFeatCode_QASet  = (null == casFeat_QASet) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_QASet).getCode();

  }
}



    