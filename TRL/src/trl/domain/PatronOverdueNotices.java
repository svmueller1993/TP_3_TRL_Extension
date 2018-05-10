package trl.domain;
/**
 * This class holds patron's overdue notice information 
 */
public class PatronOverdueNotices {

	String id;
	String patronId;
	String overdueNoticeId;

	public PatronOverdueNotices(String id, String patronId, String overdueNoticeId) {
		super();
		this.id = id;
		this.patronId = patronId;
		this.overdueNoticeId = overdueNoticeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatronId() {
		return patronId;
	}

	public void setPatronId(String patronId) {
		this.patronId = patronId;
	}

	public String getOverdueNoticeId() {
		return overdueNoticeId;
	}

	public void setOverdueNoticeId(String overdueNoticeId) {
		this.overdueNoticeId = overdueNoticeId;
	}

}
