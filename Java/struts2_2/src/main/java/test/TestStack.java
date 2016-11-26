package test;

import java.util.ArrayList;

/**
 * Created by Pan on 2016/11/26.
 */
public class TestStack {


    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();

        arrayList.add(0, "index_1");
        arrayList.add(0, "index_2");
        arrayList.add(0, "index_3");
        arrayList.add(0, "index_4");
        arrayList.add(0, "index_5");


        for (int i = 0; i < arrayList.size() ; i++){
            System.out.println(arrayList.get(0));
        }



    }

}
