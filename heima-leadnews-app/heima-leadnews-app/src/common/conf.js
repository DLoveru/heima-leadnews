const  config = {

    urls:{
        baseUrl:'/toutiao',
        load:'api/v1/article/load',
        loadmore:'api/v1/article/loadmore',
        loadnew:'api/v1/article/loadnew',
        show_behavior:'save_behavior',
        // 解决多平台问题
        getBase : function(){
            if(weex.config.env.platform=='Web'){
                return config.urls.baseUrl;
            }else{
                return "http://m.toutiao.com"
            }
        },
        get:function(name){
            let tmp = config.urls[name];
            if(tmp)
                return config.urls.getBase()+"/"+tmp;
            else
                return config.urls.getBase()+"/"+name;
        }
    },style:{
        main_bg:'#3296fa'
    }

}
export default config
