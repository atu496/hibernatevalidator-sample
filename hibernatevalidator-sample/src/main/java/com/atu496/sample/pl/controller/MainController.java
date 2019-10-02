package com.atu496.sample.pl.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atu496.sample.pl.form.SampleForm;

@Controller
public class MainController {

	@GetMapping("/")
	public ModelAndView get(@ModelAttribute SampleForm form, ModelAndView mav) {
		mav.addObject("form", form);
		mav.setViewName("index");
		return mav;
	}

	@PostMapping("/exe/validation")
	public String exe(@ModelAttribute @Valid SampleForm form, BindingResult result, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				attribute.addFlashAttribute(((FieldError) error).getField() + "errormsg", error.getDefaultMessage());
			}
		}
		return "redirect:/";
	}
}
