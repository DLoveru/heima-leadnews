<template>
    <div class="bar_bg">
        <text class="icon" @click="back">&#xf104;</text>
        <Search type="search"
                autofocus="autofocus"
                @onSubmit="onSubmit"
                @onInput="onInput"
                @onBlur="onBlur"
                @onChange="onChange"
                :icon="icon"
                placeholder="请输入搜索关键字..."
                rightWidth="0" />
    </div>
</template>

<script>
    import Search from '@/compoents/inputs/search';
    export default {
        name: "search_top_bar",
        components: {Search},
        data(){
            return {
                icon:'\uF002',
                autofocus:true
            }
        },
        methods:{
            back : function(){
                this.$router.back();
            },
            onSubmit : function(val){
                this.$router.push({name:'search_result',params:{'keyword':val}})
            },
            onInput:function(val){
                this.$emit("onInput",val)
            },
            onChange:function(val){
                this.$emit("onChange",val)
            },
            onBlur:function(val){
                this.$emit("onBlur",val)
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '../../styles/common';
    .bar_bg{
        width: @screen-width;
        flex-direction: row;
        background-color: @bg-white;
        border-style: solid;
        height: @top-height;
        padding-top: 5px;
        padding-right: 35px;
        align-items: center;
    }
    .icon{
        color: #ababab;
        font-family: fontawesome;
        font-size: 40px;
        padding:0px 30px 0px 20px;
    }
</style>
