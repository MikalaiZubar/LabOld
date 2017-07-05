package com.epam.domain;

import java.time.Year;

public class Book {

	private int id;
	private String title;
	private String brief;
	private Year publish_year;
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Year getPublish_year() {
		return publish_year;
	}

	public void setPublish_year(Year publish_year) {
		this.publish_year = publish_year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(int id, String title, String brief, Year publish_year, String author) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.publish_year = publish_year;
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + id;
		result = prime * result + ((publish_year == null) ? 0 : publish_year.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Book) {
			Book book = (Book) obj;
			return (book.getId() == this.getId()) || (book.getTitle().equals(this.getTitle())
					&& book.getBrief().equals(this.getBrief()) && book.getPublish_year() == this.getPublish_year()
					&& book.getAuthor().equals(this.getAuthor()));
		} else {
			return false;
		}
	}
}
