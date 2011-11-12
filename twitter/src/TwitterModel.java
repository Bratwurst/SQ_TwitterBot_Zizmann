import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterModel extends Observable {

	private Twitter twitter;
	private String userName;
	private ArrayList<String> tweets = new ArrayList<String>();
	private String msg1 = " I'm spending some quality time with my pillow.ZZZzzzZZZzzz";
	private String msg2 = " Reden ist Silber, Schweigen ist Gold und Googeln ist Chrome.";

	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<String> getTweets() {
		return tweets;
	}

	public void setTweets(ArrayList<String> tweets) {
		this.tweets = tweets;
	}

	public TwitterModel() {
		super();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("vYsSLWs9wayxUhcg95jDKg")
				.setOAuthConsumerSecret(
						"M7ijjqNu5X4nGeGCZw0vt8w0vhudwkQalybOBJ11I")
				.setOAuthAccessToken(
						"405692167-rY3h5OOp3F2KBR915AiY38yTH8ZZwUP1XjMOtcly")
				.setOAuthAccessTokenSecret(
						"Wy3mrCq6QALyMapxxP1UfARISWms8QwXU9xbUuvc");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();

		Timer t = new Timer("Twitter Updater`", false);
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				getTimeline();

			}

		}, 1l, 15000l);
	}

	public void getTimeline() {
		try {
			String msg = msg1;
			Status lastMess = twitter.getUserTimeline().get(0);
			List<Status> mentions = twitter.getMentions();
			tweets = new ArrayList<String>();

			for (int i = 0; i< 5 ;i++) {
				tweets.add(mentions.get(i).getUser().getName() + ":" + mentions.get(i).getText());
			}
			
			if(lastMess.getCreatedAt().before(mentions.get(0).getCreatedAt()))
				 try {
					 if(lastMess.getText().contains(msg1)) msg = msg2;
					 twitter.updateStatus("@"
					 + mentions.get(0).getUser().getScreenName()+msg+" "+mentions.get(0).getCreatedAt());
				 } catch (TwitterException te) {
					 	te.printStackTrace();
				 }
			

		} catch (TwitterException te) {
			te.printStackTrace();
		}
		setChanged();
		notifyObservers();

	}
	

	public String addFriend(String name) {
		String ret = "";
		try {
			twitter.createFriendship(name);
			ret = "Following";
		} catch (Exception e) {
			ret = "Could not find User";
		}

		return ret;
	}
}
