package com.kdn.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class Product implements Serializable {

	public Product(Long id, String description, double price, List<String> images) {
		this.id = id;
		this.description = description;
		this.images = images;
		this.price = price;
		this.status = "Y";
		this.createdTs = new Date();
	}

	private static final long serialVersionUID = 7675772413878110842L;
	private Long id;
	private String description;
	private double price;
	private List<String> images;
	private String status;
	//@JsonFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date createdTs;
	private Date updatedTs;

}
