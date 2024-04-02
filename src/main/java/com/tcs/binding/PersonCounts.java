package com.tcs.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonCounts {

	private Integer maleCount;
	private Integer femaleCount;
	private Integer childrenCount;
	private Integer seniorCitizenCount;

}
