package com.hanains.mysite.vo;

public class PageVo {
	long listSize=10;	// 한 페이지에 표시할 게시글 수
	long blockSize=10;	// 한 블록에 표시할 페이지 수
	long totalCount;	// (검색된)전체 게시글 수
	long pageCount;		// (검색된)전체 페이지 수
	long blockCount;	// (검색된)전체 블록 수
	long currentBlock;	// 현재 블록
	long beginPage;		// 현재 블록 시작 페이지
	long endPage;		// 현재 블록 끝 페이지
	long page=1;			// 현재 페이지
	long prevBlock;		// 이전 블록
	long nextBlock;		// 다음 블록
	String keyword;		// 검색어
	
	public PageVo() {
		super();
	}

	public PageVo(long listSize, long blockSize, long totalCount, long pageCount, long blockCount, long currentBlock,
			long beginPage, long endPage, long currentpage, long prevBlock, long nextBlock, String keyword) {
		super();
		this.listSize = listSize;
		this.blockSize = blockSize;
		this.totalCount = totalCount;
		this.pageCount = pageCount;
		this.blockCount = blockCount;
		this.currentBlock = currentBlock;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.page = currentpage;
		this.prevBlock = prevBlock;
		this.nextBlock = nextBlock;
		this.keyword = keyword;
	}

	public long getListSize() {
		return listSize;
	}

	public void setListSize(long listSize) {
		this.listSize = listSize;
	}

	public long getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(long blockSize) {
		this.blockSize = blockSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public long getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(long blockCount) {
		this.blockCount = blockCount;
	}

	public long getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(long currentBlock) {
		this.currentBlock = currentBlock;
	}

	public long getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(long beginPage) {
		this.beginPage = beginPage;
	}

	public long getEndPage() {
		return endPage;
	}

	public void setEndPage(long endPage) {
		this.endPage = endPage;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(long prevBlock) {
		this.prevBlock = prevBlock;
	}

	public long getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(long nextBlock) {
		this.nextBlock = nextBlock;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageVo [listSize=");
		builder.append(listSize);
		builder.append(", blockSize=");
		builder.append(blockSize);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append(", pageCount=");
		builder.append(pageCount);
		builder.append(", blockCount=");
		builder.append(blockCount);
		builder.append(", currentBlock=");
		builder.append(currentBlock);
		builder.append(", beginPage=");
		builder.append(beginPage);
		builder.append(", endPage=");
		builder.append(endPage);
		builder.append(", page=");
		builder.append(page);
		builder.append(", prevBlock=");
		builder.append(prevBlock);
		builder.append(", nextBlock=");
		builder.append(nextBlock);
		builder.append(", keyword=");
		builder.append(keyword);
		builder.append("]");
		return builder.toString();
	}
}
