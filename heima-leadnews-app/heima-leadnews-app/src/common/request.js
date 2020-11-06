var querystring=require("querystring");
function Request() {
    var stream;
}
Request.prototype={
    __check : function(){
        if(!this.stream){
            this.stream = weex.requireModule("stream");
        }
        return this.stream;
    },
    post : function(path,body){
        let stream = this.__check();
        return new Promise((resolve, reject) => {
            stream.fetch({
                method: 'POST',
                url: path,
                type: 'json',
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                },
                body:body
            }, (response) => {
                if (response.status == 200) {
                    resolve(response.data)
                }
                else {
                    reject(response)
                }
            }, () => {})
        })
    },
    get : function(path,parms){
        let stream = this.__check();
        if(parms){
            let tmp = querystring.stringify(parms)
            if(path.indexOf("?")==-1){
                tmp="?"+tmp;
            }else{
                tmp="&"+tmp;
            }
            path+=tmp;
        }
        return new Promise((resolve, reject) => {
            stream.fetch({
                method: 'GET',
                url: path,
                type: 'json'
            }, (response) => {
                if (response.status == 200) {
                    resolve(response.data)
                }
                else {
                    reject(response)
                }
            }, () => {})
        })
    }
}
export  default new Request()
