function Api(){
    var vue;
}
Api.prototype = {
    setVue : function(vue){
        this.vue = vue;
    },
    // 加载数据
    loaddata : function(params){
        let dir = params.loaddir
        let url = this.getLoadUrl(dir)
        return new Promise((resolve, reject) => {
            this.vue.$request.get(url,params).then((d)=>{
                resolve(d);
            }).catch((e)=>{
                reject(e);
            })
        })
    },
    // 保存展现行为数据
    saveShowBehavior : function(params){
        let ids = [];
        for(let k in params){
            if(params[k]){
                ids.push({id:k});
            }
        }
        console.log(params)
        if(ids.length>0){
            // let url = this.vue.$config.urls.get('show_behavior')
            let url = 'behavior/api/v1/behavior/save_behavior';
            return new Promise((resolve, reject) => {
                this.vue.$request.post(url, JSON.stringify({equipmentId:1,articleIds:ids})).then((d)=>{
                    d.data=ids
                    resolve(d);
                }).catch((e)=>{
                    reject(e);
                })
            })
        }
    },
    // 区别请求那个URL
    getLoadUrl : function(dir){
        let url = this.vue.$config.urls.get('load')
        if(dir==0)
            url = this.vue.$config.urls.get('loadnew')
        else if(dir==2)
            url = this.vue.$config.urls.get('loadmore')
        return url;
    }
}

export default new Api()