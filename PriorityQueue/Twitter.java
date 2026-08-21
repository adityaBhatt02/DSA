class Tweet implements Comparable<Tweet> {
    int tweetId;
    int time;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }

    public int compareTo(Tweet that) {
        return that.time - this.time;
    }
}

class User {
    int userId;
    Set<Integer> followees;
    List<Tweet> tweets;

    User(int userId) {
        this.userId = userId;
        followees = new HashSet<>();
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet tweet) {
        tweets.add(0, tweet);            // insertion at the head
    }

    public void addFollowee(int followeeId) {
        followees.add(followeeId);
    }

    public void removefollowee(int followeeId) {
        followees.remove(followeeId);
    }
}

class Twitter {
    int timeCounter;
    Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>(); 
        timeCounter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)) userMap.put(userId, new User(userId));

        User user = userMap.get(userId);
        user.addTweet(new Tweet(tweetId, timeCounter));    
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)) return new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        User user = userMap.get(userId);
        
        for(int followeeId : user.followees) {
            int count = 0;
            for(Tweet tweet : userMap.get(followeeId).tweets) {
                pq.offer(tweet);
                count++;

                if(count > 10) break;
            }
        }

        // user's own tweets
        int count = 0;
        for(Tweet tweet : user.tweets) {
            pq.offer(tweet);
            count++;

            if(count > 10) break;   
        }

        List<Integer> result = new ArrayList<>();
        int index = 0;
        
        while(!pq.isEmpty() && index < 10) {
            result.add(pq.poll().tweetId);
            index++;
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) userMap.put(followerId, new User(followerId));
        if(!userMap.containsKey(followeeId)) userMap.put(followeeId, new User(followeeId));

        User follower = userMap.get(followerId);
        follower.addFollowee(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;

        User follower = userMap.get(followerId);
        follower.removefollowee(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
