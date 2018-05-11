package trl.domain;

import java.util.List;

public class OverdueNotice {

	String id;
	List<String> copyId;
	boolean resolved;

	public OverdueNotice(String id, List<String> copyId, boolean resolved) {
		super();
		this.id = id;
		this.copyId = copyId;
		this.resolved = resolved;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getCopyId() {
		return copyId;
	}

	public void setCopyId(List<String> copyId) {
		this.copyId = copyId;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

}
