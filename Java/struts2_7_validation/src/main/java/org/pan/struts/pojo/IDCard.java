package org.pan.struts.pojo;

/**
 * Created by PanPan on 2016/12/4.
 */
public class IDCard {

    private String cardNo;


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public boolean Verify(String cardNo){

        return false;
    }
}
