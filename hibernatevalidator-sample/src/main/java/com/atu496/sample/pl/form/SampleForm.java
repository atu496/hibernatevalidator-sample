package com.atu496.sample.pl.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class SampleForm {

	@Length(min = 8, max = 20)
	private String length;

	@NotBlank
	private String notblank;

	@NotEmpty
	private String notempty;

	@Email
	private String email;
}
