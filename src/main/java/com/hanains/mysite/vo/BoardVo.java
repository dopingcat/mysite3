package com.hanains.mysite.vo;

public class BoardVo {
	private Long no;
	private String title;
	private String content;
	private Long memberNo;
	private String memberName;
	private Long viewCount;
	private String regDate;
	private Long groupNo;
	private Long orderNo;
	private Long depth;
	
	public BoardVo() {
		super();
	}

	public BoardVo(Long no, String title, String content, Long memberNo, String memberName, Long viewCount,
			String regDate, Long groupNo, Long orderNo, Long depth) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.viewCount = viewCount;
		this.regDate = regDate;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Long getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardVo [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", memberNo=");
		builder.append(memberNo);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", viewCount=");
		builder.append(viewCount);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", groupNo=");
		builder.append(groupNo);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", depth=");
		builder.append(depth);
		builder.append("]");
		return builder.toString();
	}

}
