package org.zwx.codedsite.zhihu.info;


import org.zwx.codedsite.core.annotation.Attribute;
import org.zwx.codedsite.core.annotation.Processor;
import org.zwx.codedsite.core.annotation.Source;
import org.zwx.codedsite.core.parse.JsonProcessor;

import static org.zwx.codedsite.zhihu.config.attribute.PeopleAttribute.*;
import static org.zwx.codedsite.zhihu.config.url.SourceUrl.*;

import java.util.Arrays;

/**
 * @author jony
 * @date 5/9
 *
 * Lack of account_status,badge,business,draft_count(me),activeDate(me),
 * createDate(me),gender性别,independentArticleCount,infinity值乎,isActive(me),
 * isEnableSignalment,isEnableWaterMark,marked_answers_text,type(People),
 * user_type(people),location,education,employment
 *
 */
@Source(value = PEOPLE_API, alternative = PEOPLE_V4)
@Processor(JsonProcessor.class)
public class PeopleInfo {

    @Attribute(IS_MY_FOLLOWER)
    private boolean isMyFollower;

    @Attribute(IS_ME_FOLLOW_HIM_OR_HER)
    private boolean isMyFollowing;

    @Attribute(ANSWERS_COUNT)
    private int answerCount;

    @Attribute(value = IS_ORGNIZATION, sourceClass = Badge.class)
    private boolean isOrgnization;

    @Attribute(value = ALLOW_MESSAGE_TO_ME, source = PEOPLE_V4)
    private boolean allowMessageToMe;

    @Attribute(value = IS_BANED_BY_ZHIHU, source = PEOPLE_API)
    private boolean isBanedByZhihu;

    @Attribute(ARTICLES_COUNT)
    private int articleCount;

    @Attribute(PROFILE_PICTURE_URL)
    private String profilePicUrl;

    @Attribute(COLUMNS_COUNT)
    private int columnCount;

    @Attribute(COVER_PICTURE_URL)
    private String coverPicUrl;

    @Attribute(DESCRIPTION)
    private String description;

    @Attribute(COLLECTIONS_COUNT)
    private int collectionCount;

    @Attribute(ANSWERS_BE_COLLECTED_COUNT)
    private int beCollectedCount;

    @Attribute(FOLLOWERS_COUNT)
    private int followerCount;

    @Attribute(FOLLOWINGS_COUNT)
    private int followPeopleCount;

    @Attribute(FOLLOW_COLUMNS_COUNT)
    private int followColumnCount;

    @Attribute(FOLLOW_COLLECTION_COUNT)
    private int followCollectionCount;

    @Attribute(FOLLOW_QUESTIONS_COUNT)
    private int followQuestionCount;

    @Attribute(FOLLOW_TOPICS_COUNT)
    private int followTopicCount;

    @Attribute(ZHIHU_ID)
    private String zhihuId;

    @Attribute(IS_ACTIVITIES_BLOCKED)
    private boolean isActivitiesBlocked;

    @Attribute(IS_BLOCKED_BY_ME)
    private boolean isBlockedByMe;

    @Attribute(IS_BIND_SINA)
    private boolean isBindSina;

    @Attribute(SINA_WEIBO_URL)
    private String sinaWeiboUrl;

    @Attribute(SINA_WEIBO_NAME)
    private String sinaWeiboName;

    @Attribute(IS_FORCE_RENAMED)
    private boolean isForceRenamed;

    @Attribute(IS_HANGED)
    private boolean isHanged;

    @Attribute(IS_LOCKED)
    private boolean isLocked;

    @Attribute(IS_UNICOM_FREE)
    private boolean isUnicomFree;

    @Attribute(HOSTED_LIVES_COUNT)
    private int hostedLiveCount;

    @Attribute(PARTICIPATED_LIVES_COUNT)
    private int participatedLiveCount;

    @Attribute(ZHIHU_NAME)
    private String zhihuName;

    @Attribute(PINS_COUNT)
    private int pinedIdeaCount;

    @Attribute(QUESTIONS_COUNT)
    private int questionCount;

    @Attribute(SHARED_COUNT)
    private int sharedCount;

    @Attribute(BE_THANKED_COUNT)
    private int thankedCount;

    @Attribute(ZHIHU_TOKEN)
    private String zhihuToken;

    @Attribute(VOTEUP_COUNT)
    private int voteUpCount;

    @Attribute(HEADLINE)
    private String headline;

    @Attribute(PEOPLE_URL)
    private String peopleUrl;
    
    @Attribute(TYPE)
    private String type;

    @Attribute(BUSINESS_CAREER)
    @Processor(TopicInfo.Processor.class)
    private TopicInfo[] business;

    // TODO: Fit to not Only for Java8 and after, but keep this

    @Attribute(value = LOCATION_API, source = PEOPLE_API)
    @Attribute(value = LOCATION_V4, source = PEOPLE_V4)
    @Processor(TopicInfo.Processor.class)
    private TopicInfo[] locations;


    public PeopleInfo() {

    }

    // Get Data Methods

    public int getAnswerCount() {
        return answerCount;
    }

    // Other Methods

    @Override
    public String toString() {
        return "People{" +
                "isMyFollower=" + isMyFollower +
                ", isMyFollowing=" + isMyFollowing +
                ", answerCount=" + answerCount +
                ", allowMessageToMe=" + allowMessageToMe +
                ", articleCount=" + articleCount +
                ", profilePicUrl='" + profilePicUrl + '\'' +
                ", columnCount=" + columnCount +
                ", coverPicUrl='" + coverPicUrl + '\'' +
                ", description='" + description + '\'' +
                ", collectionCount=" + collectionCount +
                ", beCollectedCount=" + beCollectedCount +
                ", followerCount=" + followerCount +
                ", followPeopleCount=" + followPeopleCount +
                ", followColumnCount=" + followColumnCount +
                ", followCollectionCount=" + followCollectionCount +
                ", followQuestionCount=" + followQuestionCount +
                ", followTopicCount=" + followTopicCount +
                ", zhihuId='" + zhihuId + '\'' +
                ", isActivitiesBlocked=" + isActivitiesBlocked +
                ", isBanedByZhihu=" + isBanedByZhihu +
                ", isBlockedByMe=" + isBlockedByMe +
                ", isBindSina=" + isBindSina +
                ", sinaWeiboUrl='" + sinaWeiboUrl + '\'' +
                ", sinaWeiboName='" + sinaWeiboName + '\'' +
                ", isForceRenamed=" + isForceRenamed +
                ", isHanged=" + isHanged +
                ", isLocked=" + isLocked +
                ", isUnicomFree=" + isUnicomFree +
                ", hostedLiveCount=" + hostedLiveCount +
                ", participatedLiveCount=" + participatedLiveCount +
                ", zhihuName='" + zhihuName + '\'' +
                ", pinedIdeaCount=" + pinedIdeaCount +
                ", questionCount=" + questionCount +
                ", sharedCount=" + sharedCount +
                ", thankedCount=" + thankedCount +
                ", zhihuToken='" + zhihuToken + '\'' +
                ", voteUpCount=" + voteUpCount +
                ", headline='" + headline + '\'' +
                ", peopleUrl=" + peopleUrl +
                ", type='" + type + '\'' +
                ", business=" + Arrays.toString(business) +
                ", locations=" + Arrays.toString(locations) +
                '}';
    }

    public class Badge {}
}
