package mvc.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.group.GroupSequenceProvider;

import mvc.validators.ArticleSequenceProvider;
import mvc.validators.ContentSize;
import mvc.validators.ValidationGroupArticles;
import mvc.validators.ValidationGroupDrafts;

@Entity
@Table(name = "articles")
@GroupSequenceProvider(value = ArticleSequenceProvider.class)
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 200)
	@Size(min = 1, max = 200, groups = {ValidationGroupArticles.class, ValidationGroupDrafts.class})
	private String title;
	@ManyToOne (optional = true)
	@JoinColumn(name = "authors_id", nullable = true)
	private Author author;
	@ManyToMany(fetch = FetchType.EAGER)
	@NotEmpty (groups = {ValidationGroupArticles.class})
	private List<Category> category;
	// @Size(min = 500, max = 4000)
	@ContentSize(min = 20, max = 4000, groups = {ValidationGroupArticles.class, ValidationGroupDrafts.class})
	private String content;
	@Column(name = "created", columnDefinition = "DATETIME", updatable = false, nullable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	private Timestamp created;
	// private Date created;
	@Column(name = "updated", columnDefinition = "DATETIME")
	// @Temporal(TemporalType.TIMESTAMP)
	private Timestamp updated;
	// private Date updated;
	private boolean draft = false;

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + ", content="
				+ content + ", created=" + created + ", updated=" + updated + ", draft=" + draft + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public boolean isDraft() {
		return draft;
	}

	public void setDraft(boolean draft) {
		this.draft = draft;
	}

	// public Date getCreated() {
	// return created;
	// }

	// public void setCreated(Date created) {
	// this.created = created;
	// }

	// public Date getUpdated() {
	// return updated;
	// }

	// public void setUpdated(Date updated) {
	// this.updated = updated;
	// }

	// to do:
	//
	// to fix:
	// enable whole date and time to be able to save during update and creating new
	// instance of entity in db
}
