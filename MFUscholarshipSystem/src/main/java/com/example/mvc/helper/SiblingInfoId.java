package com.example.mvc.helper;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiblingInfoId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long student_id;
    private int sibling_order;

}
