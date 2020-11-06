<template>
    <div class="bar_bg">
        <text class="icon">&#xf039;</text>
        <Search type="search" @onFocus="onFocus" :icon="icon" left-width="25" rightWidth="20" placeholder="请输入搜索关键字..."/>
        <text class="icon">&#xf002;</text>
    </div>
</template>

<script>
    import Search from '@/compoents/inputs/search';
    export default {
        name: "index",
        components: { Search},
        data:()=>{
            return {
                icon:'\uF002'
            }
        },
        mounted(){
            this.backgroundColor = this.$config.style.main_bg;
        },
        methods: {
            onFocus : function(){
                this.$router.push('/search')
            },
            minibarLeftButtonClick () {
            },
            minibarRightButtonClick () {
            }
        }
    };
</script>

<style lang="less" scoped>
    @import '../../styles/common';
    .bar_bg{
        width: @screen-width;
        flex-direction: row;
        background-color: @mian-color;
        border-style: solid;
        height: @top-height;
        padding: 7px 15px 10px;
        align-items: center;
    }
    .icon{
        color: #ffffff;
        font-family: fontawesome;
        font-size: 32px;
    }
</style>
