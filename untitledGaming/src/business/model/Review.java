package business.model;

/**
 * Created by Davide on 04/06/2017.
 */
public class Review {

    int reviewId, user_id;
    String text;
    double vote;
    boolean approvata;

    public Review (int reviewId, int user_id, String text, double vote, boolean approvata) {

        this.reviewId = reviewId;
        this.user_id = user_id;
        this.text = text;
        this.vote = vote;
    }

    public double getVote() {
        return vote;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getText() {
        return text;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public boolean isApprovata() {
        return approvata;
    }

    public void setApprovata(boolean approvata) {
        this.approvata = approvata;
    }
}
