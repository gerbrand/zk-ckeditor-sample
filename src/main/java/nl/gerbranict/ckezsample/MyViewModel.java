package nl.gerbranict.ckezsample;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

public class MyViewModel {
	
	private String editableText;

	private int changes;
	@Init
	public void init() {
		editableText = "Some <b>editable</b> text.";
		changes = 0;
	}

	@Command
	@NotifyChange("changes")
	public void changed() {
		++changes;
	}

	public String getEditableText() {
		return editableText;
	}

	public void setEditableText(String editableText) {
		this.editableText = editableText;
	}

	public int getChanges() {
		return changes;
	}

	public void setChanges(int changes) {
		this.changes = changes;
	}
	
	@Command
	public void finishedEditing() {
		Clients.showNotification("You have entered the following text:<div>"+editableText+"</div>", null, null, null, 25000, true);
	}
	
}
