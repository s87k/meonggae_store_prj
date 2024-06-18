package com.store.meonggae.product.domain;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SearchProductDomain {
	private String goodsNum, goodsName, goodsImgNum, imgName, price, priceFm, categoryNum, location, locationStr, timeAgo;
	private int memNumSell;
	private Date inputDate;
}
