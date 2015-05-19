package com.shamison;

import twitter4j.Status;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.UserStreamAdapter;

/**
 * Created by shamison on 15/05/19.
 */
public class Main {
	public static void main(String[] args) {
		TwitterStream twitter = new TwitterStreamFactory().getInstance();
		twitter.addListener(new Listener());
		twitter.user();
	}

	static class Listener extends UserStreamAdapter {
		@Override
		public void onStatus(Status status) {
			super.onStatus(status);
			System.out.println(
					status.getUser().getName()
							+ "(@" + status.getUser().getScreenName() + ")"
							+ ": "
							+ status.getText()
			);
		}
	}
}
