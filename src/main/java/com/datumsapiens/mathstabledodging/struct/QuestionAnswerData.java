package com.datumsapiens.mathstabledodging.struct;
import lombok.Value;

@Value
public class QuestionAnswerData {
    private Integer sequenceNum;
    private Question question;
    private Answer answer;
    private Result result;
    private Double timeTaken;

}
