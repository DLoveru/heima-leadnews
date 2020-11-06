<template>
    <div class="botton" @click="click">
        <text class="icon" v-if="icon!=''" :style="{color:active?'red':'#997283'}">{{icon}}</text>
        <text class="text">{{getText()}}</text>
    </div>
</template>

<script>
    export default {
        name: "button",
        props:{
            text : {
                type:String,
                default : ''
            },
            icon : {
                type:String,
                default: '\uf164'
            },
            active : {
                type:Boolean,
                default: false
            },
            activeText : {
                type:String,
                default : ''
            }
        },
        data(){
            return {
                color:''
            }
        },
        methods : {
            click : function(){
                this.$emit('onClick', {});
            },
            getText : function(){
                if(this.active){
                    return this.activeText==''?this.text:this.activeText;
                }else{
                    return this.text;
                }
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '../../styles/common';
    .botton{
        flex: 1;
        border-width: 1px;
        border-radius: 30px;
        border-color: @border-color;
        line-height: 60px;
        flex-direction: row;
        align-items: center;
        vertical-align: center;
        margin: 0px 10px;
    }
    .icon{
        font-size: 32px;
        color: @border-color;
        width: 40px;
        margin-left: 10px;
    }
    .text{
        color: @border-color;
        font-size: 26px;
    }

</style>
