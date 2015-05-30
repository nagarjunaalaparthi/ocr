//**************************************************************************************************
//**************************************************************************************************
//                                     Copyright (c) 2014 by 
//                                            ALL RIGHTS RESERVED
//**************************************************************************************************
//**************************************************************************************************
//
//        Project name                        : Cuckuu
//        Class Name                          : CloudConstants
//        Date                                : 
//        Author                              : [x]cube LABS
//        Version                             : 1.0
//
//***************************************************************************************************
//        Class Description: applications constants related to api calls with server 
//						
//***************************************************************************************************
//        Update history:
//        Date :                            Developer Name :     Modification Comments :
package com.ocr.model;

public interface CloudConstants {
	public final int CONNECTION_TIMEOUT = 60000; // 1 Minute
	public final String APPLICATION_TOKEN = "528374b093f40";
	public static final int HTTP_PORTNO = 8080;
	public static final int HTTPS_PORTNO = 443;
	public static final String KEY_RANDOM_ALARM_YES = "yes";
	public static final String KEY_RANDOM_ALARM_NO = "no";

	public interface IFAQConstants {
		public static final String KEY_FAQ = "faqs";
		public static final String KEY_THEME = "theme_name";
	}

	/*
	 * network error constants
	 */
	public interface INetworkErrorConstants {
		public final byte HTTP_SUCCESS = 0;
		public final byte HTTP_NO_NETWORK = 1;
		public final byte HTTP_TIMEOUT = 2;
		public final byte HTTP_ERROR = 3;
		public final byte HTTP_RESP_JSON_ERROR = 4;
		public final byte SERVICE_ERROR = 5;

		public final byte API_SUCCESS = 100;
		public final byte API_FAILED = 101;
		public final byte API_RESP_DELETE = 102;
		public final byte API_RESP_FULL = 103;
	}

	/*
	 * content type strings
	 */
	public interface IContentType {
		public final String CONTENT_JSON = "application.json";
		public final String CONTENT_XML = "application/xml";
	}

	/*
	 * facebook keys that will come from facebook
	 */
	public interface IFacebookKeys {
		public final String FB_NAME = "name";
		public final String FB_EMAIL = "email";
		public final String FB_GENDER = "gender";
		public final String FB_ID = "id";
		public final String FB_LOC = "location";
		public final String FB_BDAY = "birthday";
	}

	/*
	 * signup keys to post request
	 */
	public interface ISignUpKeys {
		public final String SIGNUP_KEY_TYPE = "type";
		public final String SIGNUP_KEY_EMAIL = "email";
		public final String SIGNUP_KEY_DATA_POLICY = "data_policy";
		public final String SIGNUP_KEY_PRIVACY_POLICY = "privacy_policy";
		public final String SIGNUP_KEY_TERMS_AND_CONDTIONS = "terms_conditions";
		public final String SIGNUP_KEY_FQAS = "faqs";
	}

	/*
	 * login keys to log in the user
	 */
	public interface ILogInKeys {
		public final String TYPE_ANDROID = "android";
		public final String LOGIN_KEY_USERNAME = "username";
		public final String LOGIN_KEY_PASSWORD = "password";
		public final String LOGIN_KEY_DEVICE_TOKEN = "device_token";
		public final String LOGIN_KEY_DEVICE_TYPE = "device_type";
		public final String LOGIN_RESET_PWD = "reset_password";
		public final String FORGOT_PASS_KEY_EMAIL = "email";

	}

	/*
	 * registration keys
	 */
	public interface IRegistrationKeys {
		public final String REGISTER_KEY_ACC_TYPE = "account_type";
		public final String REGISTER_KEY_USER_NAME = "username";
		public final String REGISTER_KEY_PASSWORD = "password";
		public final String REGISTER_KEY_NAME = "name";
		public final String REGISTER_KEY_DOB = "dob";
		public final String REGISTER_KEY_GENDER = "gender";
		public final String REGISTER_KEY_IMG_PATH = "image_path";
		public final String REGISTER_KEY_CITY = "city";
		public final String REGISTER_KEY_EMAIL = "email";
		public final String REGISTER_KEY_COUNTRY = "country";
		public final String REGISTER_KEY_TIMEZONE = "time_zone";
		public final String REGISTER_KEY_DEVICE_TOKEN = "device_token";
		public final String REGISTER_KEY_DEVICE_TYPE = "device_type";

	}

	/**
	 * apply profiles
	 */
	public interface IApplyProfileKeys {
		public final String APPLY_PROFILE_USER_ID = "user_id";
		public final String APPLY_PROFILE_NAME = "name";
		public final String APPLY_PROFILE_CATEGORY = "categories";
		public final String APPLY_PROFILE_EMAIL = "email";
		public final String APPLY_PROFILE_WORK = "work";
		public final String APPLY_PROFILE_ABOUT = "about";
	}

	/**
	 * update profiles keys
	 * 
	 */
	public interface IUpdateProfileKeys {
		public final String KEY_USER_ID = "user_id";
		public final String UPDATE_PROFILE_NAME = "name";
		public final String UPDATE_PROFILE_USERNAME = "username";
		public final String UPDATE_PROFILE_DOB = "dob";
		public final String UPDATE_PROFILE_GENDER = "gender";
		public final String UPDATE_PROFILE_CITY = "city";
		public final String UPDATE_PROFILE_COUNTRY = "country";
		public final String UPDATE_OLD_PASSWORD = "old_password";
		public final String UPDATE_NEW_PASSWORD = "password";
		public final String UPDATE_IMAGE_PATH = "image_path";
	}

	/**
	 * update settings keys
	 * 
	 */
	public interface ICuckuusettingsKeys {
		public final String KEY_USER_ID = "user_id";
		public final String UPDATE_RINGTONE_ID = "ringtone_id";
		public final String UPDATE_SNOOZE_INTERVAL = "snooze_interval";
		public final String UPDATE_THEME = "theme";
	}

	/**
	 * update privacy keys
	 * 
	 */
	public interface IPrivacysettingsKeys {
		public final String KEY_USER_ID = "user_id";
		public final String UPDATE_MY_ALARM = "my_alarms";
		public final String UPDATE_DAILY_PICS = "daily_pics";
		public final String UPDATE_BUDDIES = "buddies";
		public final String UPDATE_STUFF = "stuff";
		public final String UPDATE_REVIEWS = "reviews";
	}

	/**
	 * get profiles
	 * 
	 */
	public interface IProfileKeys {
		public final String GET_PROFILE_USER_ID = "user_id";
		public final String GET_PROFILE_OTHER_USER_ID = "other_user_id";
	}

	/*
	 * asset keys to dowmload from server
	 */
	public interface IAssetKeys {
		public final String DOODLE = "doodle";
		public final String MULTIPLIER = "multiplier";
		public final String EMOTIONS = "emotions";
		public final String CATEGORY = "category";
		public final String USER_ID = "user_id";
		public final String ASSET_ID = "asset_id";
		public final String START = "start";
		public final String NUMRECORDS = "numRecords";
		public final String LAST_MODIFIED_DATE = "last_modified_date";

		public final String KEY_RESPONSE_ASSETS = "assets";
		public final String KEY_ASSET_ID = "id";
		public final String KEY_ASSET_PARENT_ID = "parent_id";
		public final String KEY_ASSET_NAME = "name";
		public final String KEY_ASSET_FILE_PATH = "file_path";
		public final String KEY_ASSET_IS_DEFAULT = "is_default";
		public final String KEY_ASSET_STATUS = "status";
		public final String KEY_ASSET_CATEGORY = "category";
		public final String KEY_ASSET_SUB_CATEGORY = "sub_category";
		public final String KEY_ASSET_TYPE_OPEN = "type";
		public final String KEY_ASSET_LEVEL_ID = "level_id";
		public final String KEY_ASSET_ACHIEVEMENT_ID = "achievement_id";
		public final String KEY_ASSET_LAST_MODIFIED_DATE = "last_modified_date";
	}

	/*
	 * keys to create alarm of various categories
	 */
	public interface ICreateAlarmKeys {
		public final String ALARM_USER_ID = "user_id";
		public final String ALARM_DATE = "alarm_date";
		public final String ALARM_NAME = "name";
		public final String ALARM_DESC = "description";

		public final String ALARM_FREQUENCY = "frequency";
		public final String ALARM_SNOOZ_FREQ = "snooze_frequency";
		public final String ALARM_DOODLE_ID = " doodle_id";
		public final String ALARM_RINGTONE_ID = " ringtone_id";
		public final String ALARM_CATEGORY = " category";

		public final String ALARM_NO_OF_PEOPLE = "no_of_people";
		public final String ALARM_BUDDIES = "buddies";
		public final String ALARM_PRIVACY = "privacy";
		public final String ALARM_TOLERANCE = "tolerance";

		public final String ALARM_CONTENT_TYPE = "content_type";
		public final String ALARM_CONTENT_TEXT = "content_text";

		public final String URL = "url";
		public final String THUMBNAIL = "thumbnail_path";
		public final String ALARM_CREATED_DATE = "created_date";

	}

	/*
	 * change password key
	 */
	public interface IChangePasswordKeys {
		public final String CHANGE_PASS_KEY_USER_ID = "user_id";
		public final String CHANGE_PASS_KEY_PASSWORD = "password";
		public final String CHANGE_PASS_KEY_STATUS = "status";

	}

	/*
	 * api call response keys
	 */
	public interface IResponseKeys {
		public final String KEY_SUCCESS = "success";
		public final String KEY_DELETE = "deleted";
		public final String KEY_FAILED = "failed";
		public final String KEY_EXPIRE_SESSION = "session_expire";
		public final String KEY_MESSAGE = "message";
		public final String KEY_TYPE = "type";
		public final String KEY_DESCRIPTION = "description";
		public final String KEY_NAME = "name";
		public final String KEY_ERROR = "error";
		public final String KEY_STATUS = "status";
		public final String KEY_CONTENT_DETAILS = "ContentDetails";
		public final String KEY_THEME = "theme";
		public final String KEY_RESPONCE = "response";
		public final String KEY_CURRENT_TIME = "current_time";
		public final String KEY_PAGE = "page";
		public final String KEY_PAGE_SIZE = "size";
		public final String KEY_DETAILS = "details";
	}

	public interface IDailyPics {
		public final String KEY_USER_ID = "user_id";
		public final String KEY_OTHER_USER_ID = "other_user_id";
		public final String KEY_LIST = "list";
		public final String KEY_PIC_ID = "shared_pic_id";
		public final String KEY_PIC_THUMB_PATH = "pic_thumb_path";
		public final String KEY_PIC_PATH = "pic_path";
		public final String KEY_POSTED_BY = "posted_by";
		public final String KEY_DESC = "description";
		public final String KEY_CREATED_DATE = "created_date";
		public final String KEY_PIC = "pic";
		public final String KEY_IS_USER_LIKED = "is_user_liked";
		public final String KEY_THUMBD_PATH = "image_thumb_path";
		public final String KEY_LOAD_TYPE = "load_type";// comments
		public final String COMMENTS = "comments";
		public final String KEY_NAME = "name";
		public final String KEY_SHARED_PIC_DETAILS = "sharedPicDetails";
		public final String KEY_BOOST_COUNT = "boost_count";
		public final String KEY_IMAGE_THUMB_PATH = "image_thumb_path";
		public final String KEY_COMMENT_ID = "comment_id";
		public final String KEY_ALARM_COMMENT_ID = "alarm_comment_id";

		public final String KEY_TIMESTAMP = "timestamp";
		public final String KEY_ORDER = "order";// previous or next
		public final String KEY_NEXT = "next";
		public final String KEY_PREVIOUS = "previous";
		public final String KEY_CATEGORY = "category";
		public final String KEY_BOOST = "boost";
		public final String KEY_UN_BOOST = "unboost";
	}

	public interface IReviews {
		public final String KEY_USER_ID = "user_id";
		public final String KEY_SPECIAL_USER_ID = "special_user_id";
		public final String KEY_LIST = "list";
		public final String KEY_PIC_ID = "shared_pic_id";
		public final String KEY_CREATED_DATE = "created_date";
		public final String KEY_REVIEW_TEXT = "reviewer_text";
		public final String KEY_REVIEW_BY = "reviewed_by";
		public final String KEY_LOAD_TYPE = "load_type";
		public final String KEY_SIZE = "size";
		public final String KEY_REVIEWS = "reviews";
		public final String KEY_REVIEW_ID = "review_id";
		public final String KEY_REVIEW_INFO = "reviewerInfo";

	}

	public interface IChatKeys {
		public final String KEY_USER_ID = "user_id";
		public final String KEY_TIME_STAMP = "timestamp";
		public final String KEY_MEDIA_PATH = "media_path";
		public final String KEY_MEDIA_URL = "media_url";
		public final String KEY_CHAT_BUDDY_ID = "chat_buddy_id";
		public final String KEY_PAGE = "page";
		public final String KEY_LIST = "list";
		public final String KEY_BODY = "body";
		public final String KEY_CHAT_ID = "chat_id";

		public final String TYPE = "type";
		public final String MESSAGE = "text";
		public final String SENDER_ID = "sid";
		public final String SENDER_IMAGE_PATH = "simagepath";
		public final String MEDIA_URL = "murl";
		public final String SENDER_NAME = "sname";
		public final String ALARM_ID = "alarmid";
		public final String RECEIVER_ID = "rid";
		public final String TIME_STAMP = "ts";
		public final String CHAT_TYPE = "ctype";
		public final String SENDER_GENDER = "sgender";
		public final String BLOCKED_BY_ME = "blockbyme";
		public final String WHOM_I_BLOCKED = "whomiblock";

		public final String SERVER_TIME_STAMP = "timestamp";
		public final String CHAT_IDS = "chat_ids";
		public final String TIMESTAMPS = "timestamps";
		public final String DELETE_CONVERSATION = "delete_conversation";
	}

	/*
	 * keys of login responce
	 */
	public interface ILogInResponseKeys {
		public final String KEY_IMAGE_PATH = "image_path";
		public final String KEY_SESSION_KEY = "session_key";
		public final String KEY_GAME_MODE = "game_mode";

		public final String KEY_IMAGE_THUMB_PATH = "image_thumb_path";
		public final String KEY_DOB = "dob";
		public final String KEY_GENDER = "gender";
		public final String KEY_SPECIAL_PROFILER = "special_profile";
		public final String KEY_ACC_TYPE = "account_type";
		public final String KEY_USER_NAME = "username";
		public final String KEY_CHAT_USER_NAME = "chat_username";
		public final String KEY_CHAT_USER_PASSWORD = "chat_password";
		public final String KEY_CITY = "city";
		public final String KEY_CONTRY = "country";
		public final String KEY_TIME_ZONE = "time_zone";
		public final String KEY_PROFILE_DESC = "profile_description";
		public final String KEY_BANNED_DESC = "banned_description";
		public final String KEY_POINTS = "points";
		public final String KEY_CASH = "cash";
		public final String KEY_SPECIAL_PROF = "special_profile";
		public final String KEY_TUTORIAL_COMP = "is_tutorial_completed";
		public final String KEY_STATUS = "status";
		public final String KEY_NAME = "name";
		public final String KEY_IS_SHYBIRD = "is_shybird";
		public final String KEY_NOTIFICATION_COUNT = "notification_count";

		public final String KEY_MESSAGE = "message";
		public final String KEY_LOGIN_LIST = "userDetails";
		public final String KEY_USER_ID = "user_id";
		public final String KEY_PASSWORD = "password";
		public final String KEY_IS_BUDDY = "is_buddy";
		public final String KEY_USER_DETAILS_LIST = "userDetails";
		public final String KEY_BLOCKED_USER_COUNT = "blocked_users_count";
		public final String KEY_MYALARMS = "my_alarms";
		public final String KEY_DAILY_PICS = "daily_pics";
		public final String KEY_BUDDIES_COUNT = "buddies_count";
		public final String KEY_CHAT_BUDDIES_COUNT = "chat_buddies_count";
		public final String KEY_REVIEWS = "reviews";
		public final String KEY_RINGTONE_ID = "ringtone_id";
		public final String KEY_SNOOZE_INTERVAL = "snooze_interval";
		public final String KEY_THEME = "theme";
		public final String KEY_BUDDIES = "buddies";
		public final String KEY_STUFF = "stuff";
		public final String KEY_LEVEL_NUMBER = "level_number";
		public final String KEY_LEVEL_NAME = "level_name";
		public final String KEY_NO_OF_TICTACS = "no_of_tictacs";
		public final String KEY_MUTUAL_BUDDIES = "mutual_buddies";
		public final String KEY_IS_CHAT_BUDDY = "is_chat_buddy";

		public final String KEY_CURRENT_TICTACS = "tictocs";
		public final String KEY_NEXT_LEVEL_TICTACS = "next_level_tictocs";
		public final String KEY_CURRENT_LEVEL_TICTACS = "current_level_tictocs";

		public final String KEY_CUCKUU_ID = "cuckuu_user_id";
		public final String KEY_CUCKUU_LOGO = "cuckuu_logo";

		public final String KEY_TUTORIAL_ALARM_STEP = "is_alarm_completed";
		public final String KEY_TUTORIAL_BUZZ_STEP = "is_buzz_completed";
		public final String KEY_TUTORIAL_CHAT_STEP = "is_chat_completed";
		public final String KEY_TUTORIAL_PROFILE_STEP = "is_profile_completed";
		public final String KEY_TUTORIAL_PUBLICITY_STEP = "is_publicity_completed";
		public final String KEY_TUTORIAL_APP_LAUNCH = "is_first_completed";
		public final String KEY_TUTORIAL_SEARCH = "is_search_cuckuu_completed";

		public final String KEY_BLOCKED_USERS = "blocked_users";
		public final String KEY_BLOCKED_BY_USERS = "blocked_me_users";
		public final String KEY_MY_BUDDIES = "my_buddies";

		public final String KEY_IS_BLOCKED = "is_blocked";
		public final String KEY_TICTOCS = "tictocs";

		public final String KEY_CHAT_SERVER_DOMAIN = "chat_server_domain";
		public final String KEY_CHAT_SERVER_PORT = "chatserver_port";
		public final String KEY_TERMS_N_CONDITIONS = "terms_n_conditions";

	}

	/*
	 * keys to know account type
	 */
	public interface IAccountTypes {
		public final String TYPE_CUCKUU = "cuckuu";
		public final String TYPE_FB = "facebook";
		public final String TYPE_GOOGLE = "google";
	}

	/*
	 * keys for alarm response coming from server
	 */
	public interface IAlarmResponseKeys {
		public final String KEY_ALARM_DET = "alarmDetails";
		public final String KEY_ALARM_ID = "alarm_id";
		public final String KEY_RING_ID = "ringtone_id";
		public final String KEY_DOODLE_ID = "doodle_id";
		public final String KEY_CATEGORY = "category";
		public final String KEY_ALARM_NAME = "name";
		public final String KEY_DESC = "description";
		public final String KEY_ALARM_DATE = "alarm_date";
		public final String KEY_NEXT_ALARM_DATE = "next_alarm_date";
		public final String KEY_FREQ = "frequency";
		public final String KEY_SNZ_FRE = "snooze_frequency";
		public final String KEY_NO_PPL = "no_of_people";
		public final String KEY_NO_PPL_JOINED = "no_of_people_joined";
		public final String KEY_PRIVACY = "privacy";
		public final String KEY_URL = "url";
		public final String KEY_THUMB_PATH = "thumbnail_path";
		public final String KEY_ALARM_STATUS = "status";
		public final String KEY_USER_ALARM_STATUS = "user_status";
		public final String KEY_CREATEDBY = "created_by";
		public final String KEY_CREATED_DATE = "created_date";
		public final String KEY_USERS = "users";
		public final String KEY_GENDER = "gender";
		public final String KEY_SPECIAL_PROF = "special_profile";
		public final String KEY_SURPRISE_DETAILS = "surprise_details";
		public final String KEY_CREATE_INFO = "creator_info";
		public final String KEY_CREATER_NAME = "name";
		public final String KEY_CREATER_IMAGE = "image_thumb_path";
		public final String KEY_CREATER_ID = "user_id";
		public final String KEY_IS_RANDOM = "is_surprise";
		public final String KEY_IS_CREATER = "is_creator";
		public final String KEY_CONTENT_TYPE = "content_type";
		public final String KEY_IS_SHYBIRD = "is_shybird";
		public final String KEY_CONTENT_TEXT = "content_text";

		public final String KEY_ALARM_ATTENDED_POS = "attended_position";
		public final String KEY_ALARM_ATTENDED_TICTOCS = "tictocs";

	}

	public interface ITrackResponseKeys {
		public final String KEY_ALARM_USERS_COUNT = "alarm_users_count";
		public final String KEY_RECEIVED_TICTOCS = "received_tictocs";
		public final String KEY_FINAL_SCREEN_IMAGE = "final_screen_image";
	}

	/*
	 * keys to create an alarm
	 */
	public interface IMyAlarmKeys {
		public final String MY_ALARM_KEY_USER_ID = "user_id";
		public final String MY_ALARM_KEY_START = "start";
		public final String TYPE = "type";
		public final String MY_ALARM_KEY_NUM_RECORD = "numRecords";
		public final String MY_ALARM_PAGINATION = "pagination";

		public final String MY_ALARM_TO_USER = "toUserName";
	}

	/*
	 * keys to get an alarm
	 */
	public interface IAlarmDetails {
		public final String KEY_USER_ID = "user_id";
		public final String KEY_ALARM_ID = "alarm_id";
		public final String KEY_ALARM_DETAILS = "alarmDetails";
	}

	/*
	 * buddy keys
	 */
	public interface IBuddyKeys {
		public final String KEY_USER_ID = "user_id";
		public final String KEY_TYPE = "type";
		public final String KEY_BUDDY_ID = "buddy_id";
		public final String KEY_SEARCH_TEXT = "search_text";
		public final String KEY_LAST_BUDDY_ID = "last_user_id";
		public final String KEY_LAST_MUTUAL_BUDDY_ID = "last_buddy_id";
		public final String KEY_PAGINATION = "pagination";
		public final String KEY_PAGE = "page";
		public final String KEY_SIZE = "size";

		public final String KEY_STATUS = "status";
		public final String KEY_BUDDY = "buddy";
		public final String KEY_CHAT_BUDDY = "chat_buddy";
		public final String KEY_IS_BUDDY = "is_buddy";
		public final String KEY_IS_CHAT_BUDDY = "is_chat_buddy";
		public final String KEY_LIST = "list";
		public final String KEY_CHAT_USERNAME = "chat_username";
		public final String KEY_NOTIFICATION_ID = "notification_id";
		public final String KEY_TICTACS = "tictocs";
		public final String KEY_RANK = "rank";

		public final String KEY_LAST_TICTACS = "last_tictocs";
		public final String KEY_LAST_SNOOZE_COUNT = "last_snooze_count";
		public final String KEY_LAST_RANK = "last_rank";
		public final String KEY_MUTUAL = "mutual";

	}

	/*
	 * buddy keys
	 */
	public interface ITutorialKeys {
		public final String KEY_TUTORIAL_KEY = "key";
		public final String KEY_TUTORIAL_VALUE = "value";

		public final String ALARM_TUTORIAL = "is_alarm_completed";
		public final String CHAT_TUTORIAL = "is_chat_completed";
		public final String BUZZ_TUTORIAL = "is_buzz_completed";
		public final String PROFILE_TUTORIAL = "is_profile_completed";
		public final String SKIP_TUTORIAL = "is_skip_completed";
		public final String PUBLICITY = "is_publicity_completed";

		public final String RESET_TUTORIAL = "reset_tutorial";

		public final String STATUS = "status";

	}

	/*
	 * block user keys
	 */
	public interface IBlockKeys {
		public final String KEY_USER_ID = "user_id";
		public final String KEY_BLOCK_USER_ID = " blocked_user_id";
		public final String KEY_STATUS = " status";

		public final String UNBLOCK = "unblock";
		public final String BLOCK = "block";
	}

	/*
	 * notify keys
	 */
	public interface INotifyKeys {
		public final String kEY_REPORTER_ID = "reported_by";
		public final String KEY_TYPE = "type";
		public final String KEY_SUBJECT = "subject";
		public final String kEY_DESCRIPTION = "description";
		public final String kEY_USER_ID = "user_id";
		public final String kEY_ALARM_ID = "alarm_id";
		public final String kEY_REPORT = "report";
		public final String kEY_CONTACT = "contact";
		public final String kEY_ALARM = "alarm";
		public final String kEY_ALARM_ABUSE = "alarm_abuse";
	}

	/*
	 * logout key
	 */

	public interface ILogoutKey {
		public final String KEY_USER_ID = "user_id";
	}

	/*
	 * keys to delete alarm
	 */
	public interface IDeleteAlarmKeys {
		public final String KEY_USER_ID = "user_id";
		public final String ALARM_ID = "alarm_id";
	}

	/*
	 * keys to deactivate alarm
	 */
	public interface IDeactivateAlarmKeys {
		public final String KEY_USER_ID = "user_id";
		public final String ALARM_ID = "alarm_id";
		public final String ALARM_CATEGORY = "category";
	}

	public interface IAlarmCommentKeys {
		public final String KEY_DESCRIPTION = "description";
		public final String KEY_ALARM_ID = "alarm_id";
		public final String KEY_USER_ID = "user_id";
		public final String KEY_CREATED_DATE = "timestamp";
		public final String KEY_ORDER = "load_type";
		public final String KEY_PAGE = "page";
	}

	/*
	 * alarm pojo keys
	 */
	public interface IAlarmKeys {
		public final String ALARM_KEY_CATEGORY = "category";
		public final String ALARM_KEY_ALARM_ID = "alarm_id";
		public final String ALARM_KEY_USER_ID = "user_id";
		public final String ALARM_KEY_IS_JOINED = "is_joined";

		public final String ALARM_KEY_ALARM_DATE = "alarm_date";
		public final String ALARM_KEY_STATUS = "status";
		public final String ALARM_KEY_IS_SHYBIRD = "is_shybird";
		public final String ALARM_KEY_PRIVACY = "privacy";
		public final String ALARM_KEY_CONTENT = "content_type";
		public final String ALARM_KEY_NO_OF_PERSONS = "no_of_people";
		public final String ALARM_KEY_TOLERANCE = "tolerance";
		public final String ALARM_KEY_AVAILABILITY = "availability";
		public final String ALARM_KEY_KEYWORD = "keyword";
		public final String ALARM_KEY_CREATED_BY = "created_by";
		public final String ALARM_KEY_ATTENDED_TIME = "attended_duration";
		public final String ALARM_KEY_IS_SURPRISE = "is_surprise";
		public final String ALARM_KEY_IS_ALARM_OVER = "is_alarm_over";

		public static final String ALARM_ID = "alarmId";
		public static final String ALARM_NAME = "alarmname";
		public static final String ALARM_DATE = "alarmDate";

		public static final String KEY_ALARM_NAME = "alarm_name";
		public static final String KEY_ALARM_DATE = "alarm_date";

		public static final String ALARM_DESC = "description";
		public static final String ALARM_CATEGORY = "category";
		public static final String ALARM_CONTENT_TYPE = "contenttype";

		public final String KEY_TIME = "time";

		public final String ALARM_KEY_VERIFY_SYNCING = "verify_syncing";

	}

	/*
	 * alarm responce keys
	 */
	public interface IMyAlarmResponseKeys {
		public final String KEY_LIST = "list";
		public final String KEY_USERS_IMAGE_PATH = "image_path";
		public final String KEY_USERS = "users";
		public final String KEY_USERS_NAME = "name";
	}

	/**
	 * noficiations
	 */
	public interface INotificationKeys {
		public final String KEY_USER_ID = "user_id";
		public final String KEY_TYPE = "type";
		public final String KEY_LOAD_TYPE = "load_type";
		public final String KEY_NOTIFICAION_ID = "notification_id";
		public final String KEY_NOTIFIER_ID = "notifier_id";
		public final String KEY_NOTIFIER_INFO = "notifier_info";
		public final String KEY_ALARM_INFO = "alarm_info";
		public final String KEY_COMMENT_INFO = "comment_info";
		public final String KEY_LEVEL_INFO = "level_info";

		public final String KEY_NOTIFICAION_TYPE = "type";
		public final String KEY_BUDDIES_COUNT = "mutual_buddies_count";
		public final String KEY_BOOST_COUNT = "boosts_count";
		public final String KEY_READ_STATUS = "read_status";
		public final String KEY_NAME = "name";
		public final String KEY_IMAGE_PATH = "image_path";
		public final String KEY_NOTIFICATION_DATE = "notified_date";
		public final String KEY_IMG_THUMB_PATH = "image_thumb_path";
		public final String KEY_DOB = "dob";
		public final String KEY_NOTIFICAION_DET = "notificationDetails";
		public final String KEY_ALARM_NAME = "alarm_name";
		public final String KEY_ALARM_DATE = "alarm_date";
		public final String KEY_ALARM_ID = "alarm_id";
		public final String KEY_ALARM_ACCEPT_STATUS = "alarm_status";
		public final String KEY_CATEGORY = "category";
		public final String KEY_OLD = "old";
		public final String KEY_NEW = "new";
		public final String KEY_KEY = "key";
		public final String KEY_VALUE = "value";
		public final String KEY_BUZZ_TYPE = "buzz_notification";
		public final String KEY_NOTIFICATION_TYPE = "notification";
		public final String KEY_BUDDY_INFO = "buddy_info";
		public final String KEY_CHAT_BUDDY_INFO = "chat_buddy_info";
		public final String KEY_CHAT_ALARM_DATE = "alarm_date";
		public final String KEY_ALRM_ACCEPTED = "alarm_invite_accepted";

	}

	public interface IAchievementKeys {
		public final String NAME = "name";
		public final String DESCRIPTION = "description";
		public final String KEY_ID = "id";
		public final String DAYS = "days";
		public final String NOOFTIMES = "no_of_times";
		public final String POSITION = "position";
		public final String TICTOCS = "tictocs";
		public final String COMPLETED = "completed";
		public final String ACHIEVEMENTS = "achievements";
		public final String REWARD = "reward";
		public final String COUNT = "count";
	}

	public interface IVersionKeys {
		public final String USERID = "user_id";
		public final String VERSION = "version";
		public final String DEVICE_TYPE = "device_type";
	}

	String EXTENSION = ".json";

	/*
	 * url's for all api calls
	 */
	public interface IUrls {

		// public final String BASE_URL =
		// "http://api.cuckuu.com/cuckuu-ug/api/v1.2";// second production

		public final String BASE_URL = "http://ec2-54-86-124-8.compute-1.amazonaws.com/cuckuu_ug/api/v1.2";// cuckuu
																											// upgrade
																											// development
																											// url

		public final String URL_TERMS_AND_COND = BASE_URL + "/content/getData"
				+ EXTENSION;
		public final String URL_FORGOT_PWD = BASE_URL + "/user/forgotPassword"
				+ EXTENSION;
		public final String URL_LOGIN = BASE_URL + "/user/login" + EXTENSION;
		public final String URL_CREATE_ALARM = BASE_URL + "/alarm/create"
				+ EXTENSION;
		public final String URL_MY_ALARMS = BASE_URL + "/alarm/me" + EXTENSION;
		public final String URL_SEARCH_ALARMS = BASE_URL + "/alarm/search"
				+ EXTENSION;
		public final String URL_UPDATE_ALARMS = BASE_URL + "/alarm/update"
				+ EXTENSION;
		public final String URL_DELTE_ALARM = BASE_URL + "/alarm/delete"
				+ EXTENSION;
		public final String URL_GET_ALARM = BASE_URL + "/alarm/details"
				+ EXTENSION;
		public final String URL_ALARM_SERVER_TIME = BASE_URL
				+ "/alarm/servertime" + EXTENSION;
		// public final String URL_DEACTIVATE_ALARM = BASE_URL +
		// "/alarm/toggleStatus" + EXTENSION;
		public final String URL_ASSETS = BASE_URL + "/asset/getAssets"
				+ EXTENSION;
		// public final String URL_JOIN_ALARM = BASE_URL + "/alarm/join" +
		// EXTENSION;
		public final String URL_APPROVE_BUDDY = BASE_URL + "/buddy/approve"
				+ EXTENSION;
		public final String URL_BLOCK_OR_UNBLOCK = BASE_URL
				+ "/blockUser/toggle" + EXTENSION;

		public final String URL_ALARM_TOGGLE_JOIN = BASE_URL
				+ "/alarm/toggleJoin" + EXTENSION;

		public final String URL_ATTEND_ALARM = BASE_URL
				+ "/alarm/TrackActivities" + EXTENSION;

		// gets all buddies or search buddies
		public final String URL_BUDDY_URL = BASE_URL + "/buddy/me" + EXTENSION;
		public final String URL_SNOOZE_URL = BASE_URL + "/user/snoozersList"
				+ EXTENSION;
		public final String URL_NOTIFY = BASE_URL + "/helpCenter/notifyUs"
				+ EXTENSION;
		public final String URL_GET_ASSETS = BASE_URL + "/asset/list"
				+ EXTENSION;
		public final String URL_TUTORIAL_URL = BASE_URL + "/user/updateByKey"
				+ EXTENSION;
		public final String URL_USER_REACTIVATE = BASE_URL + "/user/reactivate"
				+ EXTENSION;

		public final String URL_ALARM_ADD_COMMENT = BASE_URL
				+ "/alarmComment/add" + EXTENSION;
		public final String URL_ALARM_DELETE_COMMENT = BASE_URL
				+ "/alarmComment/delete" + EXTENSION;
		public final String URL_ALARM_COMMENTS = BASE_URL
				+ "/alarmComment/List" + EXTENSION;

		// User Services
		public final String URL_CHANGE_PASS = BASE_URL + "/user/changePassword"
				+ EXTENSION;
		public final String URL_USER_EXISTS = BASE_URL + "/user/exists"
				+ EXTENSION;
		public final String URL_REGISTRATION = BASE_URL + "/user/register"
				+ EXTENSION;
		public final String URL_LOGOUT = BASE_URL + "/user/logout" + EXTENSION;
		public final String URL_APPLY_NOW = BASE_URL
				+ "/user/applySpecialProfile" + EXTENSION;
		public final String URL_PROFILE_DETAILS = BASE_URL
				+ "/user/profileDetails" + EXTENSION;
		public final String URL_SEARCH_PROFILE_BUDDY = BASE_URL + "/user/list"
				+ EXTENSION;
		public final String URL_INVITE_BUDDY = BASE_URL + "/buddy/invite"
				+ EXTENSION;
		public final String URL_REMOVE_BUDDY = BASE_URL + "/buddy/remove"
				+ EXTENSION;
		public final String URL_UPDATE_PROFILE_PIC = BASE_URL
				+ "/user/updateProfilePicture" + EXTENSION;
		public final String URL_SHARE_DAILY_PIC = BASE_URL
				+ "/userSharedPic/share" + EXTENSION;
		public final String URL_UPDATE_PROFILE = BASE_URL
				+ "/user/updateProfile" + EXTENSION;
		public final String URL_UPDATE_CUCKUU_SETTINGS = BASE_URL
				+ "/user/updateAppSettings" + EXTENSION;
		public final String URL_DELETE_ACCOUNT = BASE_URL
				+ "/user/deleteAccount" + EXTENSION;
		public final String URL_UPDATE_PRIVACY_SETTINGS = BASE_URL
				+ "/user/updatePrivacySettings" + EXTENSION;
		public final String URL_DAILY_PICS_LIST = BASE_URL
				+ "/userSharedPic/list" + EXTENSION;
		public final String URL_BLOCKED_USER = BASE_URL + "/blockUser/me"
				+ EXTENSION;
		public final String URL_SHARED_PIC_DETAILS = BASE_URL
				+ "/userSharedPic/details" + EXTENSION;
		public final String URL_ADD_COMMENT = BASE_URL
				+ "/userSharedPic/addComment" + EXTENSION;
		public final String URL_DELETE_COMMENT = BASE_URL
				+ "/userSharedPic/deleteComment" + EXTENSION;
		public final String URL_MUTUAL_BUDDIES = BASE_URL
				+ "/user/mutualBuddies" + EXTENSION;
		public final String URL_BLOCK_BUDDY = BASE_URL + "/blockUser/toggle"
				+ EXTENSION;
		public final String URL_TOGGLE_BOOST = BASE_URL
				+ "/userSharedPic/toggleLike" + EXTENSION;

		public final String URL_SOCAIL_INVETE_BUDDY = BASE_URL
				+ "/alarm/invite" + EXTENSION;

		// notifications
		public final String URL_USER_NOTIFICATIONS = BASE_URL
				+ "/notification/me" + EXTENSION;
		public final String URL_USER_BUZZ_NOTIFICATIONS = BASE_URL
				+ "/buzzNotification/me" + EXTENSION;
		public final String URL_NOTIFICATION_READ = BASE_URL
				+ "/notification/updateStatus" + EXTENSION;
		public final String URL_NEXT_ALARMS = BASE_URL + "/alarm/next"
				+ EXTENSION;
		public final String URL_UPDATE_BY_KEY = BASE_URL + "/user/updateByKey"
				+ EXTENSION;

		// chat
		public final String URL_UPLOAD = BASE_URL + "/chat/upload" + EXTENSION;
		public final String URL_CHAT_HISTORY = BASE_URL + "/chat/history"
				+ EXTENSION;
		public final String URL_SEND_DEFAULT_MESSAGE = BASE_URL
				+ "/notification/sendDefaultMessage" + EXTENSION;
		public final String URL_REMOVE_CHAT_URL = BASE_URL + "/chat/remove"
				+ EXTENSION;

		// reviews
		public final String URL_ADD_REVIEW = BASE_URL
				+ "/specialProfileReviews/add" + EXTENSION;
		public final String URL_GET_REVIEWS = BASE_URL
				+ "/specialProfileReviews/list" + EXTENSION;
		public final String URL_DELETE_REVIEWS = BASE_URL
				+ "/specialProfileReviews/delete" + EXTENSION;

		// achievements

		public final String URL_ACHIEVEMENTS = BASE_URL + "/achievements/get"
				+ EXTENSION;
		public final String URL_NO_OF_INSTALLATIONS = BASE_URL
				+ "/tracker/update" + EXTENSION;

		// version check
		public final String URL_VERSION_CHECK = BASE_URL
				+ "/version/check.json" + EXTENSION;

	}

}
