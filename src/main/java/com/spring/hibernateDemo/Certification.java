package com.spring.hibernateDemo;

import javax.persistence.Embeddable;

@Embeddable
public class Certification {
	private String course;
	private String duration;
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Certification(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	
	public Certification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Certification [course=" + course + ", duration=" + duration + "]";
	}
	
	
	

}
