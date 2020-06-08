package ImageHoster.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@Autowired
	private ImageService imageService;
	
	// This controller method is called when the request pattern is of type
	// '/image/{imageId}/{imageTitle}/comments' and also the incoming request is of
	// POST type
	// The method receives all the details of the comment to be stored in the
	// database, and now the comment will be sent to the business logic to be
	// persisted in the database
	// After you get the imageID, set the image by calling 'getImage(id)' and set
	// the user of the image by getting the logged
	// in user from the Http Session
	// Set the local date on which the comment is posted
	// Set the test of the comment posted
	// After storing the comment, this method redirects to the 'showImage()
	// displaying all comments and the image

	// Get the 'text' request parameter using @RequestParam annotation which is just
	// a string
	@RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
	public String createComment(@PathVariable("imageId") int id, @PathVariable("imageTitle") String title,
			@RequestParam("comment") String text, HttpSession session, Model model) throws IOException {
		User user = (User) session.getAttribute("loggeduser");
		Image image = imageService.getImage(id);
		Comment comment = new Comment();
		comment.setText(text);
		comment.setCreatedDate(LocalDate.now());
		comment.setUser(user);
		comment.setImage(image);
		commentService.addComment(comment);

		return "redirect:/images/" + id + "/" + title;
	}

}
