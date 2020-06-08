package ImageHoster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRespository;

@Service
public class CommentService {

	@Autowired
	private CommentRespository commentRepository;

	// The method calls the create comment() method in the Repository and passes the
	// image to be persisted in the database
	public void addComment(Comment comment) {
		commentRepository.addComment(comment);
	}
}
