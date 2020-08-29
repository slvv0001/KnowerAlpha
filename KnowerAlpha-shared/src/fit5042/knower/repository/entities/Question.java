package fit5042.knower.repository.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Shuang
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Question implements Serializable {

    private String questionTitle;
    private String questionDetail;
    private String type;

  

    public Question() {
    }

    public Question(String questionTitle, String questionDetail, String type) {
        this.questionDetail= questionDetail;
        this.questionTitle = questionTitle;
        this.type = type;
        
    }

    @Column(name = "question_title")
    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    //complete by adding annotation here for column name = "street_address"
    @Column(name="question_detail")
    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }
    //complete by adding annotation here for column name = "postcode"
    @Column(name="type")
      public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return questionTitle +" (" + type + ") ";
    }
}
