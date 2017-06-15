package business.model;

public class Review {

    int reviewId, user_id;
    String text;
    double vote;
    boolean approvata;
    int game_id;

    public Review (int reviewId, int user_id, String text, double vote, boolean approvata, int game) {

        this.reviewId = reviewId;
        this.user_id = user_id;
        this.text = text;
        this.vote = vote;
        this.game_id = game;
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

    public int getGame_id() { return game_id; }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setGame_id(int gam) { this.game_id = gam; }

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