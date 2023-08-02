class Twitter {

    private static int timeStamp=0;
    private Map<Integer, User> userMap;

    private class Tweet{
        public int id;
        public int time;
        public Tweet next;
        public Tweet(int id){
            this.id= id;
            time= timeStamp++;
            next=null;
        }
    }
    public class User{
        public Integer id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(Integer id){
            this.id=id;
            followed= new HashSet<>();
            follow(id); // first follow itself
            tweet_head=null;
        }
        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            followed.remove(id);
        }
        public void post(int id){
            Tweet temp=new Tweet(id);
            temp.next=tweet_head;
            tweet_head=temp;
        }
    }

    public Twitter() {
        userMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User user=new User(userId);
            userMap.put(userId,user);
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new LinkedList<>();

        if(!userMap.containsKey(userId)) return result;

        Set<Integer> followerSet= userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>
        (followerSet.size(), (a,b)->(b.time-a.time));
        
        for(int follower: followerSet){
            Tweet temp=userMap.get(follower).tweet_head;
            if(temp!=null){
                pq.add(temp);
            }
        }
        int n=0;
        while(!pq.isEmpty() && n<10){
            Tweet temp=pq.poll();
            result.add(temp.id);
            n++;
            if(temp.next!=null){
                pq.add(temp.next);
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User user= new User(followerId);
            userMap.put(followerId,user);
        }
        if(!userMap.containsKey(followeeId)){
            User user= new User(followeeId);
            userMap.put(followeeId,user);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId) 
            || followerId==followeeId ){
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
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