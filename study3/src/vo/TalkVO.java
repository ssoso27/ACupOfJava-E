package vo;

public class TalkVO {
	private Integer talkNo = null;
	private Integer roomNo = null;
	private String content = null;
	
	public Integer getTalkNo() {
		return talkNo;
	}
	public void setTalkNo(Integer talkNo) {
		this.talkNo = talkNo;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "[talkNo=" + talkNo + ", roomNo=" + roomNo + ", content=" + content + "]";
	}
}
