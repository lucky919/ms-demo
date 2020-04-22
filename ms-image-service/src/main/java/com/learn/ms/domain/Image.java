package com.learn.ms.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image implements Serializable {
	private static final long serialVersionUID = 1144763810460174792L;

	private Long id;
	
	private String title;
	
	private String url;
}
