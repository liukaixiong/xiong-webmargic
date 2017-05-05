package com.model;

import java.util.List;

/**
 * @author Liukx
 * @create 2017-04-21 9:41
 * @email liukx@elab-plus.com
 **/
public class Test {

    /**
     * paging : {"is_end":false,"totals":3121,"previous":"http://www.zhihu.com/api/v4/questions/33178973/answers?sort_by=default&include=data%5B%2A%5D.is_normal%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Cmark_infos%2Ccreated_time%2Cupdated_time%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cupvoted_followees%3Bdata%5B%2A%5D.author.is_blocking%2Cis_blocked%2Cis_followed%2Cvoteup_count%2Cmessage_thread_token%2Cbadge%5B%3F%28type%3Dbest_answerer%29%5D.topics&limit=20&offset=0","is_start":true,"next":"http://www.zhihu.com/api/v4/questions/33178973/answers?sort_by=default&include=data%5B%2A%5D.is_normal%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Cmark_infos%2Ccreated_time%2Cupdated_time%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cupvoted_followees%3Bdata%5B%2A%5D.author.is_blocking%2Cis_blocked%2Cis_followed%2Cvoteup_count%2Cmessage_thread_token%2Cbadge%5B%3F%28type%3Dbest_answerer%29%5D.topics&limit=20&offset=20"}
     * data : [{"editable_content":"你不知道三年二班的同学多幸福。","mark_infos":[],"excerpt":"你不知道三年二班的同学多幸福。","thumbnail":"","created_time":1437959051,"id":56584856,"voteup_count":4229,"author":{"is_followed":false,"avatar_url_template":"https://pic2.zhimg.com/7c184a86aeb4a935fe73097e5e0522ad_{size}.jpg","type":"people","name":"子不语","is_advertiser":false,"headline":"我的志愿是做一个校长，每天，收集了学生的学费后，就去吃火锅","badge":[],"user_type":"people","url":"http://www.zhihu.com/api/v4/people/ee60cd274ba5899f2087cfb8dc35e7f7","avatar_url":"https://pic2.zhimg.com/7c184a86aeb4a935fe73097e5e0522ad_is.jpg","is_following":false,"is_org":false,"gender":1,"url_token":"zi-bu-yu-57-84","id":"ee60cd274ba5899f2087cfb8dc35e7f7"},"question":{"author":{"is_followed":false,"avatar_url_template":"https://pic2.zhimg.com/aadd7b895_{size}.jpg","type":"people","name":"匿名用户","is_advertiser":false,"headline":"","badge":[],"user_type":"people","url":"http://www.zhihu.com/api/v4/people/0","avatar_url":"https://pic2.zhimg.com/aadd7b895_is.jpg","is_following":false,"is_org":false,"gender":1,"url_token":"","id":"0"},"created":1437531310,"url":"http://www.zhihu.com/api/v4/questions/33178973","title":"周杰伦巅峰时期有多火？","updated_time":1460697436,"question_type":"normal","type":"question","id":33178973},"content":"你不知道三年二班的同学多幸福。","comment_count":421,"reshipment_settings":"allowed","is_copyable":true,"type":"answer","suggest_edit":{"status":false,"title":"","url":"","tip":"","reason":"","unnormal_details":{}},"relationship":{"upvoted_followees":[],"voting":0,"is_nothelp":false,"is_authorized":false,"is_author":false,"is_thanked":false},"collapsed_by":"nobody","thanks_count":357,"is_collapsed":false,"url":"http://www.zhihu.com/api/v4/answers/56584856","comment_permission":"all","is_sticky":null,"updated_time":1437959051,"extras":"","can_comment":{"status":true,"reason":""},"is_normal":true}]
     */

    private PagingBean paging;
    private List<DataBean> data;

    public PagingBean getPaging() {
        return paging;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PagingBean {
        /**
         * is_end : false
         * totals : 3121
         * previous : http://www.zhihu.com/api/v4/questions/33178973/answers?sort_by=default&include=data%5B%2A%5D.is_normal%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Cmark_infos%2Ccreated_time%2Cupdated_time%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cupvoted_followees%3Bdata%5B%2A%5D.author.is_blocking%2Cis_blocked%2Cis_followed%2Cvoteup_count%2Cmessage_thread_token%2Cbadge%5B%3F%28type%3Dbest_answerer%29%5D.topics&limit=20&offset=0
         * is_start : true
         * next : http://www.zhihu.com/api/v4/questions/33178973/answers?sort_by=default&include=data%5B%2A%5D.is_normal%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Cmark_infos%2Ccreated_time%2Cupdated_time%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cupvoted_followees%3Bdata%5B%2A%5D.author.is_blocking%2Cis_blocked%2Cis_followed%2Cvoteup_count%2Cmessage_thread_token%2Cbadge%5B%3F%28type%3Dbest_answerer%29%5D.topics&limit=20&offset=20
         */

        private boolean is_end;
        private int totals;
        private String previous;
        private boolean is_start;
        private String next;

        public boolean isIs_end() {
            return is_end;
        }

        public void setIs_end(boolean is_end) {
            this.is_end = is_end;
        }

        public int getTotals() {
            return totals;
        }

        public void setTotals(int totals) {
            this.totals = totals;
        }

        public String getPrevious() {
            return previous;
        }

        public void setPrevious(String previous) {
            this.previous = previous;
        }

        public boolean isIs_start() {
            return is_start;
        }

        public void setIs_start(boolean is_start) {
            this.is_start = is_start;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }
    }

    public static class DataBean {
        /**
         * editable_content : 你不知道三年二班的同学多幸福。
         * mark_infos : []
         * excerpt : 你不知道三年二班的同学多幸福。
         * thumbnail :
         * created_time : 1437959051
         * id : 56584856
         * voteup_count : 4229
         * author : {"is_followed":false,"avatar_url_template":"https://pic2.zhimg.com/7c184a86aeb4a935fe73097e5e0522ad_{size}.jpg","type":"people","name":"子不语","is_advertiser":false,"headline":"我的志愿是做一个校长，每天，收集了学生的学费后，就去吃火锅","badge":[],"user_type":"people","url":"http://www.zhihu.com/api/v4/people/ee60cd274ba5899f2087cfb8dc35e7f7","avatar_url":"https://pic2.zhimg.com/7c184a86aeb4a935fe73097e5e0522ad_is.jpg","is_following":false,"is_org":false,"gender":1,"url_token":"zi-bu-yu-57-84","id":"ee60cd274ba5899f2087cfb8dc35e7f7"}
         * question : {"author":{"is_followed":false,"avatar_url_template":"https://pic2.zhimg.com/aadd7b895_{size}.jpg","type":"people","name":"匿名用户","is_advertiser":false,"headline":"","badge":[],"user_type":"people","url":"http://www.zhihu.com/api/v4/people/0","avatar_url":"https://pic2.zhimg.com/aadd7b895_is.jpg","is_following":false,"is_org":false,"gender":1,"url_token":"","id":"0"},"created":1437531310,"url":"http://www.zhihu.com/api/v4/questions/33178973","title":"周杰伦巅峰时期有多火？","updated_time":1460697436,"question_type":"normal","type":"question","id":33178973}
         * content : 你不知道三年二班的同学多幸福。
         * comment_count : 421
         * reshipment_settings : allowed
         * is_copyable : true
         * type : answer
         * suggest_edit : {"status":false,"title":"","url":"","tip":"","reason":"","unnormal_details":{}}
         * relationship : {"upvoted_followees":[],"voting":0,"is_nothelp":false,"is_authorized":false,"is_author":false,"is_thanked":false}
         * collapsed_by : nobody
         * thanks_count : 357
         * is_collapsed : false
         * url : http://www.zhihu.com/api/v4/answers/56584856
         * comment_permission : all
         * is_sticky : null
         * updated_time : 1437959051
         * extras :
         * can_comment : {"status":true,"reason":""}
         * is_normal : true
         */

        private String editable_content;
        private String excerpt;
        private String thumbnail;
        private int created_time;
        private int id;
        private int voteup_count;
        private AuthorBean author;
        private QuestionBean question;
        private String content;
        private int comment_count;
        private String reshipment_settings;
        private boolean is_copyable;
        private String type;
        private SuggestEditBean suggest_edit;
        private RelationshipBean relationship;
        private String collapsed_by;
        private int thanks_count;
        private boolean is_collapsed;
        private String url;
        private String comment_permission;
        private Object is_sticky;
        private int updated_time;
        private String extras;
        private CanCommentBean can_comment;
        private boolean is_normal;
        private List<?> mark_infos;

        public String getEditable_content() {
            return editable_content;
        }

        public void setEditable_content(String editable_content) {
            this.editable_content = editable_content;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public int getCreated_time() {
            return created_time;
        }

        public void setCreated_time(int created_time) {
            this.created_time = created_time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getVoteup_count() {
            return voteup_count;
        }

        public void setVoteup_count(int voteup_count) {
            this.voteup_count = voteup_count;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public QuestionBean getQuestion() {
            return question;
        }

        public void setQuestion(QuestionBean question) {
            this.question = question;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public String getReshipment_settings() {
            return reshipment_settings;
        }

        public void setReshipment_settings(String reshipment_settings) {
            this.reshipment_settings = reshipment_settings;
        }

        public boolean isIs_copyable() {
            return is_copyable;
        }

        public void setIs_copyable(boolean is_copyable) {
            this.is_copyable = is_copyable;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public SuggestEditBean getSuggest_edit() {
            return suggest_edit;
        }

        public void setSuggest_edit(SuggestEditBean suggest_edit) {
            this.suggest_edit = suggest_edit;
        }

        public RelationshipBean getRelationship() {
            return relationship;
        }

        public void setRelationship(RelationshipBean relationship) {
            this.relationship = relationship;
        }

        public String getCollapsed_by() {
            return collapsed_by;
        }

        public void setCollapsed_by(String collapsed_by) {
            this.collapsed_by = collapsed_by;
        }

        public int getThanks_count() {
            return thanks_count;
        }

        public void setThanks_count(int thanks_count) {
            this.thanks_count = thanks_count;
        }

        public boolean isIs_collapsed() {
            return is_collapsed;
        }

        public void setIs_collapsed(boolean is_collapsed) {
            this.is_collapsed = is_collapsed;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getComment_permission() {
            return comment_permission;
        }

        public void setComment_permission(String comment_permission) {
            this.comment_permission = comment_permission;
        }

        public Object getIs_sticky() {
            return is_sticky;
        }

        public void setIs_sticky(Object is_sticky) {
            this.is_sticky = is_sticky;
        }

        public int getUpdated_time() {
            return updated_time;
        }

        public void setUpdated_time(int updated_time) {
            this.updated_time = updated_time;
        }

        public String getExtras() {
            return extras;
        }

        public void setExtras(String extras) {
            this.extras = extras;
        }

        public CanCommentBean getCan_comment() {
            return can_comment;
        }

        public void setCan_comment(CanCommentBean can_comment) {
            this.can_comment = can_comment;
        }

        public boolean isIs_normal() {
            return is_normal;
        }

        public void setIs_normal(boolean is_normal) {
            this.is_normal = is_normal;
        }

        public List<?> getMark_infos() {
            return mark_infos;
        }

        public void setMark_infos(List<?> mark_infos) {
            this.mark_infos = mark_infos;
        }

        public static class AuthorBean {
            /**
             * is_followed : false
             * avatar_url_template : https://pic2.zhimg.com/7c184a86aeb4a935fe73097e5e0522ad_{size}.jpg
             * type : people
             * name : 子不语
             * is_advertiser : false
             * headline : 我的志愿是做一个校长，每天，收集了学生的学费后，就去吃火锅
             * badge : []
             * user_type : people
             * url : http://www.zhihu.com/api/v4/people/ee60cd274ba5899f2087cfb8dc35e7f7
             * avatar_url : https://pic2.zhimg.com/7c184a86aeb4a935fe73097e5e0522ad_is.jpg
             * is_following : false
             * is_org : false
             * gender : 1
             * url_token : zi-bu-yu-57-84
             * id : ee60cd274ba5899f2087cfb8dc35e7f7
             */

            private boolean is_followed;
            private String avatar_url_template;
            private String type;
            private String name;
            private boolean is_advertiser;
            private String headline;
            private String user_type;
            private String url;
            private String avatar_url;
            private boolean is_following;
            private boolean is_org;
            private int gender;
            private String url_token;
            private String id;
            private List<?> badge;

            public boolean isIs_followed() {
                return is_followed;
            }

            public void setIs_followed(boolean is_followed) {
                this.is_followed = is_followed;
            }

            public String getAvatar_url_template() {
                return avatar_url_template;
            }

            public void setAvatar_url_template(String avatar_url_template) {
                this.avatar_url_template = avatar_url_template;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isIs_advertiser() {
                return is_advertiser;
            }

            public void setIs_advertiser(boolean is_advertiser) {
                this.is_advertiser = is_advertiser;
            }

            public String getHeadline() {
                return headline;
            }

            public void setHeadline(String headline) {
                this.headline = headline;
            }

            public String getUser_type() {
                return user_type;
            }

            public void setUser_type(String user_type) {
                this.user_type = user_type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public boolean isIs_following() {
                return is_following;
            }

            public void setIs_following(boolean is_following) {
                this.is_following = is_following;
            }

            public boolean isIs_org() {
                return is_org;
            }

            public void setIs_org(boolean is_org) {
                this.is_org = is_org;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getUrl_token() {
                return url_token;
            }

            public void setUrl_token(String url_token) {
                this.url_token = url_token;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<?> getBadge() {
                return badge;
            }

            public void setBadge(List<?> badge) {
                this.badge = badge;
            }
        }

        public static class QuestionBean {
            /**
             * author : {"is_followed":false,"avatar_url_template":"https://pic2.zhimg.com/aadd7b895_{size}.jpg","type":"people","name":"匿名用户","is_advertiser":false,"headline":"","badge":[],"user_type":"people","url":"http://www.zhihu.com/api/v4/people/0","avatar_url":"https://pic2.zhimg.com/aadd7b895_is.jpg","is_following":false,"is_org":false,"gender":1,"url_token":"","id":"0"}
             * created : 1437531310
             * url : http://www.zhihu.com/api/v4/questions/33178973
             * title : 周杰伦巅峰时期有多火？
             * updated_time : 1460697436
             * question_type : normal
             * type : question
             * id : 33178973
             */

            private AuthorBeanX author;
            private int created;
            private String url;
            private String title;
            private int updated_time;
            private String question_type;
            private String type;
            private int id;

            public AuthorBeanX getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBeanX author) {
                this.author = author;
            }

            public int getCreated() {
                return created;
            }

            public void setCreated(int created) {
                this.created = created;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_time() {
                return updated_time;
            }

            public void setUpdated_time(int updated_time) {
                this.updated_time = updated_time;
            }

            public String getQuestion_type() {
                return question_type;
            }

            public void setQuestion_type(String question_type) {
                this.question_type = question_type;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public static class AuthorBeanX {
                /**
                 * is_followed : false
                 * avatar_url_template : https://pic2.zhimg.com/aadd7b895_{size}.jpg
                 * type : people
                 * name : 匿名用户
                 * is_advertiser : false
                 * headline :
                 * badge : []
                 * user_type : people
                 * url : http://www.zhihu.com/api/v4/people/0
                 * avatar_url : https://pic2.zhimg.com/aadd7b895_is.jpg
                 * is_following : false
                 * is_org : false
                 * gender : 1
                 * url_token :
                 * id : 0
                 */

                private boolean is_followed;
                private String avatar_url_template;
                private String type;
                private String name;
                private boolean is_advertiser;
                private String headline;
                private String user_type;
                private String url;
                private String avatar_url;
                private boolean is_following;
                private boolean is_org;
                private int gender;
                private String url_token;
                private String id;
                private List<?> badge;

                public boolean isIs_followed() {
                    return is_followed;
                }

                public void setIs_followed(boolean is_followed) {
                    this.is_followed = is_followed;
                }

                public String getAvatar_url_template() {
                    return avatar_url_template;
                }

                public void setAvatar_url_template(String avatar_url_template) {
                    this.avatar_url_template = avatar_url_template;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public boolean isIs_advertiser() {
                    return is_advertiser;
                }

                public void setIs_advertiser(boolean is_advertiser) {
                    this.is_advertiser = is_advertiser;
                }

                public String getHeadline() {
                    return headline;
                }

                public void setHeadline(String headline) {
                    this.headline = headline;
                }

                public String getUser_type() {
                    return user_type;
                }

                public void setUser_type(String user_type) {
                    this.user_type = user_type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public boolean isIs_following() {
                    return is_following;
                }

                public void setIs_following(boolean is_following) {
                    this.is_following = is_following;
                }

                public boolean isIs_org() {
                    return is_org;
                }

                public void setIs_org(boolean is_org) {
                    this.is_org = is_org;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public String getUrl_token() {
                    return url_token;
                }

                public void setUrl_token(String url_token) {
                    this.url_token = url_token;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public List<?> getBadge() {
                    return badge;
                }

                public void setBadge(List<?> badge) {
                    this.badge = badge;
                }
            }
        }

        public static class SuggestEditBean {
            /**
             * status : false
             * title :
             * url :
             * tip :
             * reason :
             * unnormal_details : {}
             */

            private boolean status;
            private String title;
            private String url;
            private String tip;
            private String reason;
            private UnnormalDetailsBean unnormal_details;

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTip() {
                return tip;
            }

            public void setTip(String tip) {
                this.tip = tip;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public UnnormalDetailsBean getUnnormal_details() {
                return unnormal_details;
            }

            public void setUnnormal_details(UnnormalDetailsBean unnormal_details) {
                this.unnormal_details = unnormal_details;
            }

            public static class UnnormalDetailsBean {
            }
        }

        public static class RelationshipBean {
            /**
             * upvoted_followees : []
             * voting : 0
             * is_nothelp : false
             * is_authorized : false
             * is_author : false
             * is_thanked : false
             */

            private int voting;
            private boolean is_nothelp;
            private boolean is_authorized;
            private boolean is_author;
            private boolean is_thanked;
            private List<?> upvoted_followees;

            public int getVoting() {
                return voting;
            }

            public void setVoting(int voting) {
                this.voting = voting;
            }

            public boolean isIs_nothelp() {
                return is_nothelp;
            }

            public void setIs_nothelp(boolean is_nothelp) {
                this.is_nothelp = is_nothelp;
            }

            public boolean isIs_authorized() {
                return is_authorized;
            }

            public void setIs_authorized(boolean is_authorized) {
                this.is_authorized = is_authorized;
            }

            public boolean isIs_author() {
                return is_author;
            }

            public void setIs_author(boolean is_author) {
                this.is_author = is_author;
            }

            public boolean isIs_thanked() {
                return is_thanked;
            }

            public void setIs_thanked(boolean is_thanked) {
                this.is_thanked = is_thanked;
            }

            public List<?> getUpvoted_followees() {
                return upvoted_followees;
            }

            public void setUpvoted_followees(List<?> upvoted_followees) {
                this.upvoted_followees = upvoted_followees;
            }
        }

        public static class CanCommentBean {
            /**
             * status : true
             * reason :
             */

            private boolean status;
            private String reason;

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }
        }
    }
}
