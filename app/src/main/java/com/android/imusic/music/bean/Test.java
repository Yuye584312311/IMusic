package com.android.imusic.music.bean;

import java.util.List;

/**
 * Created by TinyHung@Outlook.com
 * 2020/3/24
 */
public class Test {

    /**
     * code : 1
     * data : {"activity_config":{"activity_type":"1","big_height":"409","big_img":"http://a.tn990.com/hyshy1.png","big_width":"310","height":"240","jump_url":"huayan://jump?type=38","small_img":"http://image.lushihudong.com/guaguale/xiaotu-20tixian.gif","width":"192"},"app_sdk_config":{"bugly_app_id":"2e97dfbc53","byte_app_id":"5052589","byte_app_name":"走样","um_app_id":"5dc0d9bd4ca35717c4000dc0"},"change_app_ad_config":{"full_screen_ad":"1","table_screen_ad":"0"},"change_main_ad_config":{"full_screen_ad":"1","table_screen_ad":"2"},"common_insert_ad_config":{"ad_code":"945082019","ad_source":"1","ad_type":"2","delayed_second":"3"},"copyright_ad_config":{"ad_code":"945082014","ad_source":"1","ad_type":"4","delayed_second":"0"},"default_image_config":{"is_blur":"0","radius":"10","sampling":"2"},"event_config":{"activity_type":"1","height":"240","jump_url":"huayan://jump?type=38","small_img":"http://image.lushihudong.com/guaguale/xiaotu-20tixian.gif","width":"192"},"full_video_ad_config":{"ad_code":"945082016","ad_source":"1","ad_type":"5","delayed_second":"0"},"guagua_banner_ad_config":{"ad_code":"945082020","ad_source":"1","ad_type":"3","delayed_second":"0"},"img_config":{"tag_img":"http://a.tn990.com/app/tag.png","video_img":"http://a.tn990.com/app/video.png","vip_img":"http://a.tn990.com/app/vip.png"},"index_top_bar":{"jump_url":"huayan://jump?type=38","title":"<font color='#FF0000'><b>刮刮乐<\/b><\/font>"},"insert_ad_scene":{"image_player_enter":"0","image_player_quit":"1","mine_enter":"1","mine_quit":"1","scratch_anchor_enter":"1","scratch_anchor_quit":"1","scratch_enter":"0","scratch_main_enter":"1","scratch_main_quit":"1","scratch_quit":"1","scratch_reward_enter":"1","scratch_reward_quit":"1","videro_player_enter":"0","videro_player_quit":"1"},"insert_prepare_load":"1","locker_ad_config":{"ad_code":"945082017","ad_source":"1","ad_type":"2","delayed_second":"0"},"main_ad_config":{"ad_code":"945082020","ad_source":"1","ad_type":"3","delayed_second":"30"},"main_content":[{"height":"0","img_url":"","show_index":"0","son_page":[{"height":"0","img_url":"","show_index":"0","son_page":[],"target_id":"112","text":"推荐","type":"1","width":"0"},{"height":"0","img_url":"","show_index":"0","son_page":[],"target_id":"112","text":"最新","type":"2","width":"0"},{"height":"0","img_url":"","show_index":"0","son_page":[],"target_id":"112","text":"热门","type":"4","width":"0"}],"target_id":"11","text":"推荐","type":"0","width":"0"}],"main_inset_ad_config":{"ad_code":"945082019","ad_source":"1","ad_type":"2","delayed_second":"4"},"mine_insert_ad":{"ad_code":"945082019","ad_source":"1","ad_type":"2","delayed_second":"0"},"mine_item_ad_config":{"ad_code":"945082021","ad_source":"1","ad_type":"1","delayed_second":"0"},"new_ad_item_config":{"ad_code":"945082022","ad_source":"1","ad_type":"8","delayed_second":"0","show_index":"4,9"},"show_main_position":"0","splash_ad_config":{"ad_code":"887305351","ad_source":"1","ad_type":"7","delayed_second":"0"},"vip_ad_config":{"ad_code":"945082014","ad_source":"1","ad_type":"4","delayed_second":"0"}}
     * message : 成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * activity_config : {"activity_type":"1","big_height":"409","big_img":"http://a.tn990.com/hyshy1.png","big_width":"310","height":"240","jump_url":"huayan://jump?type=38","small_img":"http://image.lushihudong.com/guaguale/xiaotu-20tixian.gif","width":"192"}
         * app_sdk_config : {"bugly_app_id":"2e97dfbc53","byte_app_id":"5052589","byte_app_name":"走样","um_app_id":"5dc0d9bd4ca35717c4000dc0"}
         * change_app_ad_config : {"full_screen_ad":"1","table_screen_ad":"0"}
         * change_main_ad_config : {"full_screen_ad":"1","table_screen_ad":"2"}
         * common_insert_ad_config : {"ad_code":"945082019","ad_source":"1","ad_type":"2","delayed_second":"3"}
         * copyright_ad_config : {"ad_code":"945082014","ad_source":"1","ad_type":"4","delayed_second":"0"}
         * default_image_config : {"is_blur":"0","radius":"10","sampling":"2"}
         * event_config : {"activity_type":"1","height":"240","jump_url":"huayan://jump?type=38","small_img":"http://image.lushihudong.com/guaguale/xiaotu-20tixian.gif","width":"192"}
         * full_video_ad_config : {"ad_code":"945082016","ad_source":"1","ad_type":"5","delayed_second":"0"}
         * guagua_banner_ad_config : {"ad_code":"945082020","ad_source":"1","ad_type":"3","delayed_second":"0"}
         * img_config : {"tag_img":"http://a.tn990.com/app/tag.png","video_img":"http://a.tn990.com/app/video.png","vip_img":"http://a.tn990.com/app/vip.png"}
         * index_top_bar : {"jump_url":"huayan://jump?type=38","title":"<font color='#FF0000'><b>刮刮乐<\/b><\/font>"}
         * insert_ad_scene : {"image_player_enter":"0","image_player_quit":"1","mine_enter":"1","mine_quit":"1","scratch_anchor_enter":"1","scratch_anchor_quit":"1","scratch_enter":"0","scratch_main_enter":"1","scratch_main_quit":"1","scratch_quit":"1","scratch_reward_enter":"1","scratch_reward_quit":"1","videro_player_enter":"0","videro_player_quit":"1"}
         * insert_prepare_load : 1
         * locker_ad_config : {"ad_code":"945082017","ad_source":"1","ad_type":"2","delayed_second":"0"}
         * main_ad_config : {"ad_code":"945082020","ad_source":"1","ad_type":"3","delayed_second":"30"}
         * main_content : [{"height":"0","img_url":"","show_index":"0","son_page":[{"height":"0","img_url":"","show_index":"0","son_page":[],"target_id":"112","text":"推荐","type":"1","width":"0"},{"height":"0","img_url":"","show_index":"0","son_page":[],"target_id":"112","text":"最新","type":"2","width":"0"},{"height":"0","img_url":"","show_index":"0","son_page":[],"target_id":"112","text":"热门","type":"4","width":"0"}],"target_id":"11","text":"推荐","type":"0","width":"0"}]
         * main_inset_ad_config : {"ad_code":"945082019","ad_source":"1","ad_type":"2","delayed_second":"4"}
         * mine_insert_ad : {"ad_code":"945082019","ad_source":"1","ad_type":"2","delayed_second":"0"}
         * mine_item_ad_config : {"ad_code":"945082021","ad_source":"1","ad_type":"1","delayed_second":"0"}
         * new_ad_item_config : {"ad_code":"945082022","ad_source":"1","ad_type":"8","delayed_second":"0","show_index":"4,9"}
         * show_main_position : 0
         * splash_ad_config : {"ad_code":"887305351","ad_source":"1","ad_type":"7","delayed_second":"0"}
         * vip_ad_config : {"ad_code":"945082014","ad_source":"1","ad_type":"4","delayed_second":"0"}
         */

        private ActivityConfigBean activity_config;
        private AppSdkConfigBean app_sdk_config;
        private ChangeAppAdConfigBean change_app_ad_config;
        private ChangeMainAdConfigBean change_main_ad_config;
        private CommonInsertAdConfigBean common_insert_ad_config;
        private CopyrightAdConfigBean copyright_ad_config;
        private DefaultImageConfigBean default_image_config;
        private EventConfigBean event_config;
        private FullVideoAdConfigBean full_video_ad_config;
        private GuaguaBannerAdConfigBean guagua_banner_ad_config;
        private ImgConfigBean img_config;
        private IndexTopBarBean index_top_bar;
        private InsertAdSceneBean insert_ad_scene;
        private String insert_prepare_load;
        private LockerAdConfigBean locker_ad_config;
        private MainAdConfigBean main_ad_config;
        private MainInsetAdConfigBean main_inset_ad_config;
        private MineInsertAdBean mine_insert_ad;
        private MineItemAdConfigBean mine_item_ad_config;
        private NewAdItemConfigBean new_ad_item_config;
        private String show_main_position;
        private SplashAdConfigBean splash_ad_config;
        private VipAdConfigBean vip_ad_config;
        private List<MainContentBean> main_content;

        public ActivityConfigBean getActivity_config() {
            return activity_config;
        }

        public void setActivity_config(ActivityConfigBean activity_config) {
            this.activity_config = activity_config;
        }

        public AppSdkConfigBean getApp_sdk_config() {
            return app_sdk_config;
        }

        public void setApp_sdk_config(AppSdkConfigBean app_sdk_config) {
            this.app_sdk_config = app_sdk_config;
        }

        public ChangeAppAdConfigBean getChange_app_ad_config() {
            return change_app_ad_config;
        }

        public void setChange_app_ad_config(ChangeAppAdConfigBean change_app_ad_config) {
            this.change_app_ad_config = change_app_ad_config;
        }

        public ChangeMainAdConfigBean getChange_main_ad_config() {
            return change_main_ad_config;
        }

        public void setChange_main_ad_config(ChangeMainAdConfigBean change_main_ad_config) {
            this.change_main_ad_config = change_main_ad_config;
        }

        public CommonInsertAdConfigBean getCommon_insert_ad_config() {
            return common_insert_ad_config;
        }

        public void setCommon_insert_ad_config(CommonInsertAdConfigBean common_insert_ad_config) {
            this.common_insert_ad_config = common_insert_ad_config;
        }

        public CopyrightAdConfigBean getCopyright_ad_config() {
            return copyright_ad_config;
        }

        public void setCopyright_ad_config(CopyrightAdConfigBean copyright_ad_config) {
            this.copyright_ad_config = copyright_ad_config;
        }

        public DefaultImageConfigBean getDefault_image_config() {
            return default_image_config;
        }

        public void setDefault_image_config(DefaultImageConfigBean default_image_config) {
            this.default_image_config = default_image_config;
        }

        public EventConfigBean getEvent_config() {
            return event_config;
        }

        public void setEvent_config(EventConfigBean event_config) {
            this.event_config = event_config;
        }

        public FullVideoAdConfigBean getFull_video_ad_config() {
            return full_video_ad_config;
        }

        public void setFull_video_ad_config(FullVideoAdConfigBean full_video_ad_config) {
            this.full_video_ad_config = full_video_ad_config;
        }

        public GuaguaBannerAdConfigBean getGuagua_banner_ad_config() {
            return guagua_banner_ad_config;
        }

        public void setGuagua_banner_ad_config(GuaguaBannerAdConfigBean guagua_banner_ad_config) {
            this.guagua_banner_ad_config = guagua_banner_ad_config;
        }

        public ImgConfigBean getImg_config() {
            return img_config;
        }

        public void setImg_config(ImgConfigBean img_config) {
            this.img_config = img_config;
        }

        public IndexTopBarBean getIndex_top_bar() {
            return index_top_bar;
        }

        public void setIndex_top_bar(IndexTopBarBean index_top_bar) {
            this.index_top_bar = index_top_bar;
        }

        public InsertAdSceneBean getInsert_ad_scene() {
            return insert_ad_scene;
        }

        public void setInsert_ad_scene(InsertAdSceneBean insert_ad_scene) {
            this.insert_ad_scene = insert_ad_scene;
        }

        public String getInsert_prepare_load() {
            return insert_prepare_load;
        }

        public void setInsert_prepare_load(String insert_prepare_load) {
            this.insert_prepare_load = insert_prepare_load;
        }

        public LockerAdConfigBean getLocker_ad_config() {
            return locker_ad_config;
        }

        public void setLocker_ad_config(LockerAdConfigBean locker_ad_config) {
            this.locker_ad_config = locker_ad_config;
        }

        public MainAdConfigBean getMain_ad_config() {
            return main_ad_config;
        }

        public void setMain_ad_config(MainAdConfigBean main_ad_config) {
            this.main_ad_config = main_ad_config;
        }

        public MainInsetAdConfigBean getMain_inset_ad_config() {
            return main_inset_ad_config;
        }

        public void setMain_inset_ad_config(MainInsetAdConfigBean main_inset_ad_config) {
            this.main_inset_ad_config = main_inset_ad_config;
        }

        public MineInsertAdBean getMine_insert_ad() {
            return mine_insert_ad;
        }

        public void setMine_insert_ad(MineInsertAdBean mine_insert_ad) {
            this.mine_insert_ad = mine_insert_ad;
        }

        public MineItemAdConfigBean getMine_item_ad_config() {
            return mine_item_ad_config;
        }

        public void setMine_item_ad_config(MineItemAdConfigBean mine_item_ad_config) {
            this.mine_item_ad_config = mine_item_ad_config;
        }

        public NewAdItemConfigBean getNew_ad_item_config() {
            return new_ad_item_config;
        }

        public void setNew_ad_item_config(NewAdItemConfigBean new_ad_item_config) {
            this.new_ad_item_config = new_ad_item_config;
        }

        public String getShow_main_position() {
            return show_main_position;
        }

        public void setShow_main_position(String show_main_position) {
            this.show_main_position = show_main_position;
        }

        public SplashAdConfigBean getSplash_ad_config() {
            return splash_ad_config;
        }

        public void setSplash_ad_config(SplashAdConfigBean splash_ad_config) {
            this.splash_ad_config = splash_ad_config;
        }

        public VipAdConfigBean getVip_ad_config() {
            return vip_ad_config;
        }

        public void setVip_ad_config(VipAdConfigBean vip_ad_config) {
            this.vip_ad_config = vip_ad_config;
        }

        public List<MainContentBean> getMain_content() {
            return main_content;
        }

        public void setMain_content(List<MainContentBean> main_content) {
            this.main_content = main_content;
        }

        public static class ActivityConfigBean {
            /**
             * activity_type : 1
             * big_height : 409
             * big_img : http://a.tn990.com/hyshy1.png
             * big_width : 310
             * height : 240
             * jump_url : huayan://jump?type=38
             * small_img : http://image.lushihudong.com/guaguale/xiaotu-20tixian.gif
             * width : 192
             */

            private String activity_type;
            private String big_height;
            private String big_img;
            private String big_width;
            private String height;
            private String jump_url;
            private String small_img;
            private String width;

            public String getActivity_type() {
                return activity_type;
            }

            public void setActivity_type(String activity_type) {
                this.activity_type = activity_type;
            }

            public String getBig_height() {
                return big_height;
            }

            public void setBig_height(String big_height) {
                this.big_height = big_height;
            }

            public String getBig_img() {
                return big_img;
            }

            public void setBig_img(String big_img) {
                this.big_img = big_img;
            }

            public String getBig_width() {
                return big_width;
            }

            public void setBig_width(String big_width) {
                this.big_width = big_width;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getJump_url() {
                return jump_url;
            }

            public void setJump_url(String jump_url) {
                this.jump_url = jump_url;
            }

            public String getSmall_img() {
                return small_img;
            }

            public void setSmall_img(String small_img) {
                this.small_img = small_img;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            @Override
            public String toString() {
                return "ActivityConfigBean{" +
                        "activity_type='" + activity_type + '\'' +
                        ", big_height='" + big_height + '\'' +
                        ", big_img='" + big_img + '\'' +
                        ", big_width='" + big_width + '\'' +
                        ", height='" + height + '\'' +
                        ", jump_url='" + jump_url + '\'' +
                        ", small_img='" + small_img + '\'' +
                        ", width='" + width + '\'' +
                        '}';
            }
        }

        public static class AppSdkConfigBean {
            /**
             * bugly_app_id : 2e97dfbc53
             * byte_app_id : 5052589
             * byte_app_name : 走样
             * um_app_id : 5dc0d9bd4ca35717c4000dc0
             */

            private String bugly_app_id;
            private String byte_app_id;
            private String byte_app_name;
            private String um_app_id;

            public String getBugly_app_id() {
                return bugly_app_id;
            }

            public void setBugly_app_id(String bugly_app_id) {
                this.bugly_app_id = bugly_app_id;
            }

            public String getByte_app_id() {
                return byte_app_id;
            }

            public void setByte_app_id(String byte_app_id) {
                this.byte_app_id = byte_app_id;
            }

            public String getByte_app_name() {
                return byte_app_name;
            }

            public void setByte_app_name(String byte_app_name) {
                this.byte_app_name = byte_app_name;
            }

            public String getUm_app_id() {
                return um_app_id;
            }

            public void setUm_app_id(String um_app_id) {
                this.um_app_id = um_app_id;
            }

            @Override
            public String toString() {
                return "AppSdkConfigBean{" +
                        "bugly_app_id='" + bugly_app_id + '\'' +
                        ", byte_app_id='" + byte_app_id + '\'' +
                        ", byte_app_name='" + byte_app_name + '\'' +
                        ", um_app_id='" + um_app_id + '\'' +
                        '}';
            }
        }

        public static class ChangeAppAdConfigBean {
            /**
             * full_screen_ad : 1
             * table_screen_ad : 0
             */

            private String full_screen_ad;
            private String table_screen_ad;

            public String getFull_screen_ad() {
                return full_screen_ad;
            }

            public void setFull_screen_ad(String full_screen_ad) {
                this.full_screen_ad = full_screen_ad;
            }

            public String getTable_screen_ad() {
                return table_screen_ad;
            }

            public void setTable_screen_ad(String table_screen_ad) {
                this.table_screen_ad = table_screen_ad;
            }

            @Override
            public String toString() {
                return "ChangeAppAdConfigBean{" +
                        "full_screen_ad='" + full_screen_ad + '\'' +
                        ", table_screen_ad='" + table_screen_ad + '\'' +
                        '}';
            }
        }

        public static class ChangeMainAdConfigBean {
            /**
             * full_screen_ad : 1
             * table_screen_ad : 2
             */

            private String full_screen_ad;
            private String table_screen_ad;

            public String getFull_screen_ad() {
                return full_screen_ad;
            }

            public void setFull_screen_ad(String full_screen_ad) {
                this.full_screen_ad = full_screen_ad;
            }

            public String getTable_screen_ad() {
                return table_screen_ad;
            }

            public void setTable_screen_ad(String table_screen_ad) {
                this.table_screen_ad = table_screen_ad;
            }

            @Override
            public String toString() {
                return "ChangeMainAdConfigBean{" +
                        "full_screen_ad='" + full_screen_ad + '\'' +
                        ", table_screen_ad='" + table_screen_ad + '\'' +
                        '}';
            }
        }

        public static class CommonInsertAdConfigBean {
            /**
             * ad_code : 945082019
             * ad_source : 1
             * ad_type : 2
             * delayed_second : 3
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "CommonInsertAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class CopyrightAdConfigBean {
            /**
             * ad_code : 945082014
             * ad_source : 1
             * ad_type : 4
             * delayed_second : 0
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "CopyrightAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class DefaultImageConfigBean {
            /**
             * is_blur : 0
             * radius : 10
             * sampling : 2
             */

            private String is_blur;
            private String radius;
            private String sampling;

            public String getIs_blur() {
                return is_blur;
            }

            public void setIs_blur(String is_blur) {
                this.is_blur = is_blur;
            }

            public String getRadius() {
                return radius;
            }

            public void setRadius(String radius) {
                this.radius = radius;
            }

            public String getSampling() {
                return sampling;
            }

            public void setSampling(String sampling) {
                this.sampling = sampling;
            }

            @Override
            public String toString() {
                return "DefaultImageConfigBean{" +
                        "is_blur='" + is_blur + '\'' +
                        ", radius='" + radius + '\'' +
                        ", sampling='" + sampling + '\'' +
                        '}';
            }
        }

        public static class EventConfigBean {
            /**
             * activity_type : 1
             * height : 240
             * jump_url : huayan://jump?type=38
             * small_img : http://image.lushihudong.com/guaguale/xiaotu-20tixian.gif
             * width : 192
             */

            private String activity_type;
            private String height;
            private String jump_url;
            private String small_img;
            private String width;

            public String getActivity_type() {
                return activity_type;
            }

            public void setActivity_type(String activity_type) {
                this.activity_type = activity_type;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getJump_url() {
                return jump_url;
            }

            public void setJump_url(String jump_url) {
                this.jump_url = jump_url;
            }

            public String getSmall_img() {
                return small_img;
            }

            public void setSmall_img(String small_img) {
                this.small_img = small_img;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            @Override
            public String toString() {
                return "EventConfigBean{" +
                        "activity_type='" + activity_type + '\'' +
                        ", height='" + height + '\'' +
                        ", jump_url='" + jump_url + '\'' +
                        ", small_img='" + small_img + '\'' +
                        ", width='" + width + '\'' +
                        '}';
            }
        }

        public static class FullVideoAdConfigBean {
            /**
             * ad_code : 945082016
             * ad_source : 1
             * ad_type : 5
             * delayed_second : 0
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "FullVideoAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class GuaguaBannerAdConfigBean {
            /**
             * ad_code : 945082020
             * ad_source : 1
             * ad_type : 3
             * delayed_second : 0
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "GuaguaBannerAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class ImgConfigBean {
            /**
             * tag_img : http://a.tn990.com/app/tag.png
             * video_img : http://a.tn990.com/app/video.png
             * vip_img : http://a.tn990.com/app/vip.png
             */

            private String tag_img;
            private String video_img;
            private String vip_img;

            public String getTag_img() {
                return tag_img;
            }

            public void setTag_img(String tag_img) {
                this.tag_img = tag_img;
            }

            public String getVideo_img() {
                return video_img;
            }

            public void setVideo_img(String video_img) {
                this.video_img = video_img;
            }

            public String getVip_img() {
                return vip_img;
            }

            public void setVip_img(String vip_img) {
                this.vip_img = vip_img;
            }

            @Override
            public String toString() {
                return "ImgConfigBean{" +
                        "tag_img='" + tag_img + '\'' +
                        ", video_img='" + video_img + '\'' +
                        ", vip_img='" + vip_img + '\'' +
                        '}';
            }
        }

        public static class IndexTopBarBean {
            /**
             * jump_url : huayan://jump?type=38
             * title : <font color='#FF0000'><b>刮刮乐</b></font>
             */

            private String jump_url;
            private String title;

            public String getJump_url() {
                return jump_url;
            }

            public void setJump_url(String jump_url) {
                this.jump_url = jump_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            @Override
            public String toString() {
                return "IndexTopBarBean{" +
                        "jump_url='" + jump_url + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }

        public static class InsertAdSceneBean {
            /**
             * image_player_enter : 0
             * image_player_quit : 1
             * mine_enter : 1
             * mine_quit : 1
             * scratch_anchor_enter : 1
             * scratch_anchor_quit : 1
             * scratch_enter : 0
             * scratch_main_enter : 1
             * scratch_main_quit : 1
             * scratch_quit : 1
             * scratch_reward_enter : 1
             * scratch_reward_quit : 1
             * videro_player_enter : 0
             * videro_player_quit : 1
             */

            private String image_player_enter;
            private String image_player_quit;
            private String mine_enter;
            private String mine_quit;
            private String scratch_anchor_enter;
            private String scratch_anchor_quit;
            private String scratch_enter;
            private String scratch_main_enter;
            private String scratch_main_quit;
            private String scratch_quit;
            private String scratch_reward_enter;
            private String scratch_reward_quit;
            private String videro_player_enter;
            private String videro_player_quit;

            public String getImage_player_enter() {
                return image_player_enter;
            }

            public void setImage_player_enter(String image_player_enter) {
                this.image_player_enter = image_player_enter;
            }

            public String getImage_player_quit() {
                return image_player_quit;
            }

            public void setImage_player_quit(String image_player_quit) {
                this.image_player_quit = image_player_quit;
            }

            public String getMine_enter() {
                return mine_enter;
            }

            public void setMine_enter(String mine_enter) {
                this.mine_enter = mine_enter;
            }

            public String getMine_quit() {
                return mine_quit;
            }

            public void setMine_quit(String mine_quit) {
                this.mine_quit = mine_quit;
            }

            public String getScratch_anchor_enter() {
                return scratch_anchor_enter;
            }

            public void setScratch_anchor_enter(String scratch_anchor_enter) {
                this.scratch_anchor_enter = scratch_anchor_enter;
            }

            public String getScratch_anchor_quit() {
                return scratch_anchor_quit;
            }

            public void setScratch_anchor_quit(String scratch_anchor_quit) {
                this.scratch_anchor_quit = scratch_anchor_quit;
            }

            public String getScratch_enter() {
                return scratch_enter;
            }

            public void setScratch_enter(String scratch_enter) {
                this.scratch_enter = scratch_enter;
            }

            public String getScratch_main_enter() {
                return scratch_main_enter;
            }

            public void setScratch_main_enter(String scratch_main_enter) {
                this.scratch_main_enter = scratch_main_enter;
            }

            public String getScratch_main_quit() {
                return scratch_main_quit;
            }

            public void setScratch_main_quit(String scratch_main_quit) {
                this.scratch_main_quit = scratch_main_quit;
            }

            public String getScratch_quit() {
                return scratch_quit;
            }

            public void setScratch_quit(String scratch_quit) {
                this.scratch_quit = scratch_quit;
            }

            public String getScratch_reward_enter() {
                return scratch_reward_enter;
            }

            public void setScratch_reward_enter(String scratch_reward_enter) {
                this.scratch_reward_enter = scratch_reward_enter;
            }

            public String getScratch_reward_quit() {
                return scratch_reward_quit;
            }

            public void setScratch_reward_quit(String scratch_reward_quit) {
                this.scratch_reward_quit = scratch_reward_quit;
            }

            public String getVidero_player_enter() {
                return videro_player_enter;
            }

            public void setVidero_player_enter(String videro_player_enter) {
                this.videro_player_enter = videro_player_enter;
            }

            public String getVidero_player_quit() {
                return videro_player_quit;
            }

            public void setVidero_player_quit(String videro_player_quit) {
                this.videro_player_quit = videro_player_quit;
            }

            @Override
            public String toString() {
                return "InsertAdSceneBean{" +
                        "image_player_enter='" + image_player_enter + '\'' +
                        ", image_player_quit='" + image_player_quit + '\'' +
                        ", mine_enter='" + mine_enter + '\'' +
                        ", mine_quit='" + mine_quit + '\'' +
                        ", scratch_anchor_enter='" + scratch_anchor_enter + '\'' +
                        ", scratch_anchor_quit='" + scratch_anchor_quit + '\'' +
                        ", scratch_enter='" + scratch_enter + '\'' +
                        ", scratch_main_enter='" + scratch_main_enter + '\'' +
                        ", scratch_main_quit='" + scratch_main_quit + '\'' +
                        ", scratch_quit='" + scratch_quit + '\'' +
                        ", scratch_reward_enter='" + scratch_reward_enter + '\'' +
                        ", scratch_reward_quit='" + scratch_reward_quit + '\'' +
                        ", videro_player_enter='" + videro_player_enter + '\'' +
                        ", videro_player_quit='" + videro_player_quit + '\'' +
                        '}';
            }
        }

        public static class LockerAdConfigBean {
            /**
             * ad_code : 945082017
             * ad_source : 1
             * ad_type : 2
             * delayed_second : 0
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "LockerAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class MainAdConfigBean {
            /**
             * ad_code : 945082020
             * ad_source : 1
             * ad_type : 3
             * delayed_second : 30
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "MainAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class MainInsetAdConfigBean {
            /**
             * ad_code : 945082019
             * ad_source : 1
             * ad_type : 2
             * delayed_second : 4
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "MainInsetAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class MineInsertAdBean {
            /**
             * ad_code : 945082019
             * ad_source : 1
             * ad_type : 2
             * delayed_second : 0
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "MineInsertAdBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class MineItemAdConfigBean {
            /**
             * ad_code : 945082021
             * ad_source : 1
             * ad_type : 1
             * delayed_second : 0
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "MineItemAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class NewAdItemConfigBean {
            /**
             * ad_code : 945082022
             * ad_source : 1
             * ad_type : 8
             * delayed_second : 0
             * show_index : 4,9
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;
            private String show_index;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            public String getShow_index() {
                return show_index;
            }

            public void setShow_index(String show_index) {
                this.show_index = show_index;
            }

            @Override
            public String toString() {
                return "NewAdItemConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        ", show_index='" + show_index + '\'' +
                        '}';
            }
        }

        public static class SplashAdConfigBean {
            /**
             * ad_code : 887305351
             * ad_source : 1
             * ad_type : 7
             * delayed_second : 0
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "SplashAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class VipAdConfigBean {
            /**
             * ad_code : 945082014
             * ad_source : 1
             * ad_type : 4
             * delayed_second : 0
             */

            private String ad_code;
            private String ad_source;
            private String ad_type;
            private String delayed_second;

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getAd_source() {
                return ad_source;
            }

            public void setAd_source(String ad_source) {
                this.ad_source = ad_source;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDelayed_second() {
                return delayed_second;
            }

            public void setDelayed_second(String delayed_second) {
                this.delayed_second = delayed_second;
            }

            @Override
            public String toString() {
                return "VipAdConfigBean{" +
                        "ad_code='" + ad_code + '\'' +
                        ", ad_source='" + ad_source + '\'' +
                        ", ad_type='" + ad_type + '\'' +
                        ", delayed_second='" + delayed_second + '\'' +
                        '}';
            }
        }

        public static class MainContentBean {
            /**
             * height : 0
             * img_url :
             * show_index : 0
             * son_page : [{"height":"0","img_url":"","show_index":"0","son_page":[],"target_id":"112","text":"推荐","type":"1","width":"0"},{"height":"0","img_url":"","show_index":"0","son_page":[],"target_id":"112","text":"最新","type":"2","width":"0"},{"height":"0","img_url":"","show_index":"0","son_page":[],"target_id":"112","text":"热门","type":"4","width":"0"}]
             * target_id : 11
             * text : 推荐
             * type : 0
             * width : 0
             */

            private String height;
            private String img_url;
            private String show_index;
            private String target_id;
            private String text;
            private String type;
            private String width;
            private List<SonPageBean> son_page;

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getShow_index() {
                return show_index;
            }

            public void setShow_index(String show_index) {
                this.show_index = show_index;
            }

            public String getTarget_id() {
                return target_id;
            }

            public void setTarget_id(String target_id) {
                this.target_id = target_id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public List<SonPageBean> getSon_page() {
                return son_page;
            }

            public void setSon_page(List<SonPageBean> son_page) {
                this.son_page = son_page;
            }

            public static class SonPageBean {
                /**
                 * height : 0
                 * img_url :
                 * show_index : 0
                 * son_page : []
                 * target_id : 112
                 * text : 推荐
                 * type : 1
                 * width : 0
                 */

                private String height;
                private String img_url;
                private String show_index;
                private String target_id;
                private String text;
                private String type;
                private String width;
                private List<?> son_page;

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getShow_index() {
                    return show_index;
                }

                public void setShow_index(String show_index) {
                    this.show_index = show_index;
                }

                public String getTarget_id() {
                    return target_id;
                }

                public void setTarget_id(String target_id) {
                    this.target_id = target_id;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public List<?> getSon_page() {
                    return son_page;
                }

                public void setSon_page(List<?> son_page) {
                    this.son_page = son_page;
                }

                @Override
                public String toString() {
                    return "SonPageBean{" +
                            "height='" + height + '\'' +
                            ", img_url='" + img_url + '\'' +
                            ", show_index='" + show_index + '\'' +
                            ", target_id='" + target_id + '\'' +
                            ", text='" + text + '\'' +
                            ", type='" + type + '\'' +
                            ", width='" + width + '\'' +
                            ", son_page=" + son_page +
                            '}';
                }
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "activity_config=" + activity_config +
                    ", app_sdk_config=" + app_sdk_config +
                    ", change_app_ad_config=" + change_app_ad_config +
                    ", change_main_ad_config=" + change_main_ad_config +
                    ", common_insert_ad_config=" + common_insert_ad_config +
                    ", copyright_ad_config=" + copyright_ad_config +
                    ", default_image_config=" + default_image_config +
                    ", event_config=" + event_config +
                    ", full_video_ad_config=" + full_video_ad_config +
                    ", guagua_banner_ad_config=" + guagua_banner_ad_config +
                    ", img_config=" + img_config +
                    ", index_top_bar=" + index_top_bar +
                    ", insert_ad_scene=" + insert_ad_scene +
                    ", insert_prepare_load='" + insert_prepare_load + '\'' +
                    ", locker_ad_config=" + locker_ad_config +
                    ", main_ad_config=" + main_ad_config +
                    ", main_inset_ad_config=" + main_inset_ad_config +
                    ", mine_insert_ad=" + mine_insert_ad +
                    ", mine_item_ad_config=" + mine_item_ad_config +
                    ", new_ad_item_config=" + new_ad_item_config +
                    ", show_main_position='" + show_main_position + '\'' +
                    ", splash_ad_config=" + splash_ad_config +
                    ", vip_ad_config=" + vip_ad_config +
                    ", main_content=" + main_content +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Test{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
