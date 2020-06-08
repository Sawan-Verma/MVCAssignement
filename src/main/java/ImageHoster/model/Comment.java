package ImageHoster.model;

import java.time.LocalDate;

import javax.persistence.*;

/**
 * @author Sawan Verma This is a model class for comment This represents as a
 *         JPA Entity with the table name "comments"
 */
@Entity
@Table(name = "comments")
public class Comment {

	/**
	 * 'id' is the primary key of the comments table with an auto increment strategy
	 * Here the column name is explicitly mentioned as 'id'
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * 'text' column holds the comment posted on the image Here the column name is
	 * explicitly mentioned as 'text'
	 */
	@Column(name = "text")
	private String text;

	/**
	 * 'createdDate' holds the local date of the comment created Here the column
	 * name is explicitly mentioned as 'id'
	 */
	@Column(name = "createdDate")
	private LocalDate createdDate;

	/**
	 * The 'comments' table is mapped to 'users' table with Many:One mapping One comment
	 * can have only one user (owner) but one user can have multiple comments
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * The 'comments' table is mapped to 'images' table with One:One mapping One comment
	 * can belong to only one image
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	// Below annotation indicates that the name of the column in 'users' table
	// referring the primary key in 'user_profile' table will be 'profile_id'
	@JoinColumn(name = "image_id")
	private Image image;

	/**
	 * @return id
	 * getter for Id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 * setter method for Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return text
	 * getter method for text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 * setter method for text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return createdDate
	 * getter for created date
	 */
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 * setter method for created date
	 */
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return user
	 * getter method for user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 * setter method for user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return image
	 * getter method for image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image
	 * setter method for image
	 */
	public void setImage(Image image) {
		this.image = image;
	}

}
