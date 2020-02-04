package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.domain.Book;


@Controller

public class BookController {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	@ResponseBody
    public String books(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }
}
