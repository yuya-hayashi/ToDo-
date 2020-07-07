package jp.ac.kcg.E19C4019;

import java.time.LocalDateTime;

import javafx.util.converter.LocalDateTimeStringConverter;

public class ToDo {
	private String subject;
	private LocalDateTime deadline;
	private int priority;

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public LocalDateTime getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}
	public void setDeadline(String deadline) {
		LocalDateTimeStringConverter conv = new LocalDateTimeStringConverter();
		this.deadline = conv.fromString(deadline);
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}


}
