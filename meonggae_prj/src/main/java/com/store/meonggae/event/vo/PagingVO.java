package com.store.meonggae.event.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PagingVO {
	private int startPageNum, endPageNum;
	private String field, keyword, currentPage;

	public PagingVO() {
	}

	public PagingVO(int startPageNum, int endPageNum, String field, String keyword, String currentPage) {
		super();
		this.startPageNum = startPageNum;
		this.endPageNum = endPageNum;
		this.field = field;
		this.keyword = keyword;
		this.currentPage = currentPage;
	}
	
	

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "PagingVO [startPageNum=" + startPageNum + ", endPageNum=" + endPageNum + ", field=" + field
				+ ", keyword=" + keyword + ", currentPage=" + currentPage + "]";
	}
}
