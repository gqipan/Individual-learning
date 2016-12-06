package org.pan.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Created by QiPan on 2016/12/6.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private String userName;

    private int age;

    private String classes;

}
