package cn.edu.tjut.model;

import cn.edu.tjut.util.Const;

public class Page {

	// 总条数
	private int totalNumber;
	// 总页数
	private int totalPage;
	// 当前页码
	private int currentPage;
	// 一页显示几条
	private int pageShowNumber = Const.DEFAULT_PAGESHOWNUMBER;
	// 显示条数
	private int showNumber;
	// 从第几条取
	private int showIndex;

	private void calculate() {
		int temp = this.totalNumber / pageShowNumber;
		if (this.totalNumber % pageShowNumber != 0) {
			temp += 1;
		}
		this.totalPage = temp;
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		} else if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		this.showIndex = (this.currentPage - 1) * this.pageShowNumber;
		this.showNumber = this.pageShowNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		calculate();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageShowNumber() {
		return pageShowNumber;
	}

	public void setPageShowNumber(int pageShowNumber) {
		this.pageShowNumber = pageShowNumber;
	}

	public int getShowNumber() {
		return showNumber;
	}

	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
	}

	public int getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(int showIndex) {
		this.showIndex = showIndex;
	}

}
